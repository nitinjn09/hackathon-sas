package com.example.projectmanager;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@RestController
public class ProjectController
{
    @GetMapping("/collect-logs")
    public String collectLogs()
    {
        //Write login to collect and return logs
        return "Hi from project manager";
    }

    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public ResponseEntity<Object> downloadFile() throws IOException
    {
        String inputFile = "C:\\TNPS\\njaintnps\\tnps\\hackathon-sas\\project-manager\\logs\\projectManager.log";
        String filename = "projectManager.log";
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
}
