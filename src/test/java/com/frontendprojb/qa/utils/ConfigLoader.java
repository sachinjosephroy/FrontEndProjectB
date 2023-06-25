package com.frontendprojb.qa.utils;

import java.util.Properties;

public class ConfigLoader {
    private final Properties properties;
    private static ConfigLoader configLoader;

    private ConfigLoader() {
        properties = PropertyUtils.propertyLoader("src/test/resources/stg_config.properties");
    }

    public static ConfigLoader getInstance() {
        if(configLoader == null) {
            configLoader = new ConfigLoader();
        }
        return configLoader;
    }

    public String getBaseUrl() {
        String url = properties.getProperty("base_url");
        if(url == null) throw new RuntimeException("Base Url is not in config file");
        else return url;
    }
}
