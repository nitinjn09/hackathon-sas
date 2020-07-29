package com.example.applicationserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ApplicationServerController
{
    @GetMapping("/collect-logs")
    public String collectLogs()
    {
        //Write login to collect and return logs
        return "Hi From application server";
    }
}
