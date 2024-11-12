package com.ea.framework.config;

import com.ea.framework.base.BrowserType;

import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    public  static void  populateSettings() throws IOException {
        ConfigReader reader=new ConfigReader();
        reader.readProperty();
    }

    private void readProperty() throws IOException {
        Properties p=new Properties();

        p.load(getClass().getResourceAsStream("GlobalConfig.properties"));
        Settings.ExcelFilepath=p.getProperty("ExcelFilepath");
        Settings.LogFilePath=p.getProperty("LogFilePath");
        Settings.SQLDriver=p.getProperty("SQLDriver");
        Settings.AUTurl=p.getProperty("AUTurl");
        Settings.browserType= BrowserType.valueOf(p.getProperty("BrowserType"));

    }
}
