package com.ea.framework.base;

import org.openqa.selenium.WebDriver;

public class Browser extends  Base{
    public  BrowserType Type;
    private WebDriver _driver;

    public Browser(WebDriver driver){
        _driver=driver;
    }

public void goToUrl(String url){
    _driver.get(url);
}
public  void  maximize(){
    _driver.manage().window().maximize();
}
}


