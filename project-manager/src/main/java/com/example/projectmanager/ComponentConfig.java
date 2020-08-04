package com.example.projectmanager;

import java.util.HashMap;
import java.util.Map;

public class ComponentConfig
{
    public static String featureOneEnable = "featureOneEnable";
    public static String featureTwoEnable = "featureTwoEnable";
    public static Map<String, String> configMap = new HashMap<>();
    private static ComponentConfig instance;

    public static ComponentConfig getInstance()
    {
        if(instance == null)
        {
            instance = new ComponentConfig();
        }
        return instance;
    }

    private ComponentConfig()
    {
        configMap.put(featureOneEnable, Boolean.toString(true));
        configMap.put(featureTwoEnable, Boolean.toString(true));
    }

    public static Map<String, String> getConfigMap() {
        return configMap;
    }
}
