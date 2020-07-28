package com.example.projectmanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ProjectManagerController
{
    @Autowired
    private ProjectManagerConfigReader configReader;

    @GetMapping("/test")
    public String test()
    {
        String url = null;
        /*String host = configReader.getDbCoreService();
        String port = configReader.getDbCoreServicePort();
        url = "http://" + host + ":" + port + "/test";*/
        String retVal;
        try
        {
            url = "http://db-core-service:80/test";
            retVal = " Project Manager {";
            RestTemplate restTemplate = new RestTemplate();
            String dataRead = restTemplate.getForObject(url, String.class);
            retVal += dataRead + " }";
        }
        catch (Exception e)
        {
            retVal = " Project Manager Failed. URL: " + url;
        }
        return retVal;
    }
}
