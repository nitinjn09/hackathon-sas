package com.example.projectmanager;

import jdk.jshell.spi.ExecutionControlProvider;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@RestController
@Slf4j
public class ProjectController
{
    @Value("${logging.file.name}")
    String logFile;

    @Value("${conf.application.path}")
    String applicationConfPath;

    @Value("{conf.dbsnap.path}")
    String dbSnapPath;

    //@Value("{sas.url}")
    //String sasUrl;

    @GetMapping("/test")
    public String collectLogs()
    {
        return "Hi from project manager";
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/pm-logs", method = RequestMethod.GET)
    public ResponseEntity<Object> downloadFile() throws IOException
    {
        File file = new File(logFile);
        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
        HttpHeaders headers = new HttpHeaders();

        headers.add("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getName()));
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");

        ResponseEntity<Object>
                responseEntity = ResponseEntity.ok().headers(headers).contentLength(file.length()).contentType(
                MediaType.parseMediaType("application/txt")).body(resource);

        return responseEntity;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/upload-conf", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String fileUpload(@RequestParam("File") MultipartFile file) throws IOException, ParseException
    {
        String content = new String(file.getBytes(), StandardCharsets.UTF_8);
        JSONParser jsonParser = new JSONParser(content);
        Object obj = jsonParser.parse();
        Set<Map.Entry> entrySet = ((HashMap) obj).entrySet();
        Map<String, String> configMap = ComponentConfig.getInstance().getConfigMap();
        for(Map.Entry entry : entrySet)
        {
            String key = (String) entry.getKey();
            String val = (String) entry.getValue();
            if(configMap.containsKey(key))
            {
                configMap.put(key, val);
            }
        }
        return "Config updated to:\n" + configMap.toString();
    }
	
	@CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/config", method = RequestMethod.GET)
    public ResponseEntity<Object> getYmlJson() throws IOException
    {
        File file = new File(applicationConfPath);
        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
        HttpHeaders headers = new HttpHeaders();

        headers.add("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getName()));
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");

        ResponseEntity<Object>
                responseEntity = ResponseEntity.ok().headers(headers).contentLength(file.length()).contentType(
                MediaType.parseMediaType("application/txt")).body(resource);

        return responseEntity;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/dbsnap", method = RequestMethod.GET)
    public ResponseEntity<Object> getJson() throws IOException
    {
        File file = new File(dbSnapPath);
        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
        HttpHeaders headers = new HttpHeaders();

        headers.add("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getName()));
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");

        ResponseEntity<Object>
                responseEntity = ResponseEntity.ok().headers(headers).contentLength(file.length()).contentType(
                MediaType.parseMediaType("application/txt")).body(resource);

        return responseEntity;
    }

}
