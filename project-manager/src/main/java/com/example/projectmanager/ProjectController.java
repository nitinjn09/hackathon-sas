package com.example.projectmanager;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProjectController
{
    @GetMapping("/collect-logs")
    public String collectLogs()
    {
        //Write login to collect and return logs
        return "Hi from project manager";
    }
}
