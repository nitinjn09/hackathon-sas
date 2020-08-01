package com.tnps.sas.sastool;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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