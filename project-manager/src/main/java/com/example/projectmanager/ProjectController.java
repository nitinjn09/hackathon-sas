package com.example.projectmanager;

import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@RestController
@Slf4j
public class ProjectController
{
    @GetMapping("/test")
    public String collectLogs()
    {
        return "Hi from project manager";
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/pm-logs", method = RequestMethod.GET)
    public ResponseEntity<Object> downloadFile() throws IOException
    {
        String inputFile = "C:\\TNPS\\njaintnps\\tnps\\hackathon-sas\\project-manager\\logs\\projectManager.log";
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
