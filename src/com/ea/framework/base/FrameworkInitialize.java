package com.ea.framework.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FrameworkInitialize extends Base {
    public void InitializeBrowser(BrowserType browserTypes) {
        WebDriver driver = null;
        switch (browserTypes) {
            case Chrome: {
                System.setProperty("webdriver.chrome.driver", "D:\\DataDriven\\ExecuteAutomation\\chromedriver.exe");
                driver = new ChromeDriver();

                break;
            }
            case Firefox: {
                driver = new FirefoxDriver();

                break;

            }
            case IE: {
                break;
            }
        }
        DriverContext.setDriver(driver);

        DriverContext.browser=new Browser(driver);

    }
}