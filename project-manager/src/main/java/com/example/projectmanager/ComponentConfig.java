package com.example.projectmanager;

public class ComponentConfig
{
    public boolean featureOneEnable = true;
    public boolean featureTwoEnable = true;

    public boolean isFeatureOneEnable() {
        return featureOneEnable;
    }

    public void setFeatureOneEnable(boolean featureOneEnable) {
        this.featureOneEnable = featureOneEnable;
    }

    public boolean isFeatureTwoEnable() {
        return featureTwoEnable;
    }

    public void setFeatureTwoEnable(boolean featureTwoEnable) {
        this.featureTwoEnable = featureTwoEnable;
    }
}
