package com.example.projectmanager;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.YamlMapFactoryBean;
import org.springframework.beans.factory.config.YamlProcessor;
import org.springframework.boot.json.YamlJsonParser;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@RestController
@Slf4j
public class ProjectController
{
    @Value("${logging.file.name}")
    String logFile;

    @Value("${conf.path}")
    String confDir;

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
    public String fileUpload(@RequestParam("File") MultipartFile file) throws IOException, ParseException {
        File convertFile = new File(confDir + "\\" + file.getOriginalFilename());
        convertFile.createNewFile();
        FileReader reader = new FileReader(convertFile);
        //JSONParser jsonParser = new JSONParser(reader);
        //Object obj = jsonParser.parse();
        //Yaml yaml = new Yaml();

        ObjectMapper mapper = new ObjectMapper();
        ComponentConfig componentConfig = mapper.readValue(reader, ComponentConfig.class);
        System.out.println(componentConfig);

        //ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        //FileOutputStream fout = new FileOutputStream(convertFile);
        //fout.write(file.getBytes());
        //fout.close();
        return "File is upload successfully";
    }
}
