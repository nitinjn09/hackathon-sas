package com.tnps.sas.sastool;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class SasToolController
{
    @GetMapping("/")
    public String collectLogs()
    {
        try
        {
            String url = "http://localhost:8082/collect-logs";
            String retVal;
            RestTemplate restTemplate = new RestTemplate();
            String dataRead = restTemplate.getForObject(url, String.class);
            return dataRead;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        //Write login to collect and return logs
        return "Hi from sas tool controller";
    }
}