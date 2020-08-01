/*
package com.tnps.sas.sastool;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ConfigReader
{
    private String applicationServerHost;
    private int applicationServerPort;

    private String projectManagerHost;
    private int projectManagerPort;

    private String dbCoreHost;
    private int dbCorePort;

    public ConfigReader() {
    }

    @Value("${applcation-server.host}")
    public void setApplicationServerHost(String applicationServerHost) {
        this.applicationServerHost = applicationServerHost;
    }

    @Value("${applcation-server.port}")
    public void setApplicationServerPort(int applicationServerPort) {
        this.applicationServerPort = applicationServerPort;
    }

    @Value("${project-manager.host}")
    public void setProjectManagerHost(String projectManagerHost) {
        this.projectManagerHost = projectManagerHost;
    }

    @Value("${project-manager.port}")
    public void setProjectManagerPort(int projectManagerPort) {
        this.projectManagerPort = projectManagerPort;
    }

    @Value("${db-core.host}")
    public void setDbCoreHost(String dbCoreHost) {
        this.dbCoreHost = dbCoreHost;
    }

    @Value("${db-core.port}")
    public void setDbCorePort(int dbCorePort) {
        this.dbCorePort = dbCorePort;
    }

    public String getDbCoreHost() {
        return dbCoreHost;
    }

    public  int getDbCorePort() {
        return dbCorePort;
    }

    public int getProjectManagerPort() {
        return projectManagerPort;
    }

    public  String getProjectManagerHost() {
        return projectManagerHost;
    }

    public String getApplicationServerHost() {
        return applicationServerHost;
    }

    public  int getApplicationServerPort() {
        return applicationServerPort;
    }
}
*/
