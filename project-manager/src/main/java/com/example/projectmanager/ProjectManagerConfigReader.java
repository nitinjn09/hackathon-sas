package com.example.projectmanager;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties()
public class ProjectManagerConfigReader
{
    private String dbCoreService;
    private String dbCoreServicePort;

    public String getDbCoreService() {
        return dbCoreService;
    }

    public void setDbCoreService(String dbCoreService) {
        this.dbCoreService = dbCoreService;
    }

    public String getDbCoreServicePort() {
        return dbCoreServicePort;
    }

    public void setDbCoreServicePort(String dbCoreServicePort) {
        this.dbCoreServicePort = dbCoreServicePort;
    }
}
