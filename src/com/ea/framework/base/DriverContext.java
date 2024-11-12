package com.ea.framework.base;

import org.openqa.selenium.WebDriver;

public class DriverContext {
    public static WebDriver driver;

    public static void setDriver(WebDriver Driver) {
        driver = Driver;
    }

    public  static Browser browser;


}
