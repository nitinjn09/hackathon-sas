package com.example.applicationserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ApplicationServerController
{
    @Autowired
    private ApplicationServerConfigReader configReader;

    @GetMapping("/test")
    public String test()
    {
        String url = null;
        /*String host = configReader.getProjectManagerService();
        String port = configReader.getProjectManagerServicePort();
        url = "http://" + host + ":" + port + "/test";*/
        String retVal;

        try
        {
            url = "http://project-manager-service:80/test";
            retVal = " Application Server: {";
            RestTemplate restTemplate = new RestTemplate();
            String dataRead = restTemplate.getForObject(url, String.class);
            retVal += dataRead + " }";
        }
        catch (Exception e)
        {
            retVal = " Application Server Failed. URL: " + url;
        }
        return retVal;
    }
}
