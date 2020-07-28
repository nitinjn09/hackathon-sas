package com.example.applicationserver;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties()
public class ApplicationServerConfigReader
{
    private String projectManagerService;
    private String projectManagerServicePort;

    public String getProjectManagerService() {
        return projectManagerService;
    }

    public void setProjectManagerService(String projectManagerService) {
        this.projectManagerService = projectManagerService;
    }

    public String getProjectManagerServicePort() {
        return projectManagerServicePort;
    }

    public void setProjectManagerServicePort(String projectManagerServicePort) {
        this.projectManagerServicePort = projectManagerServicePort;
    }
}
