package com.tnps.sas.sastool;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

@RestController
public class SasToolController
{
    /*@Value("${project-manager.host}")
    String projectMaangerHost;
    @Value("${project-manager.port}")
    String projectManagerPort;*/

    @GetMapping("/collect-logs")
    public String collectLogs()
    {
        String pmServiceUrl = "http://project-manager:8082/collect-logs";
        String pmLogs = collectLogs(pmServiceUrl);
        return pmLogs;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/pm-logs", method = RequestMethod.GET)
    public ResponseEntity<Object> downloadFile() throws IOException
    {
        String inputFile = "C:\\projectManager.log";
        File file = new File(inputFile);
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

    private String collectLogs(String serviceUrl)
    {
        String retVal = "SAS: ";
        try
        {
            RestTemplate restTemplate = new RestTemplate();
            String dataRead = restTemplate.getForObject(serviceUrl, String.class);
            return dataRead;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            retVal= retVal + "Error:" + serviceUrl;
        }
        return retVal;
    }
}