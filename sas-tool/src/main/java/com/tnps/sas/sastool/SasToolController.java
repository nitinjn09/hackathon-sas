package com.tnps.sas.sastool;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SasToolController
{
    @GetMapping("/collect-logs")
    public String collectLogs()
    {
        //Write login to collect and return logs
        return "Hi from sas tool controller";
    }
}