package com.ea.test.pages;

import com.ea.framework.base.Basepage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage extends Basepage {

    public LoginPage() {

    }

    @FindBy(how= How.XPATH,using = "//label[text()='UserName']//parent::div//div//input")
    public WebElement txtUsername;

    @FindBy(how= How.XPATH,using = "//label[text()='Password']//parent::div//div//input")
    public WebElement txtPassword;

    @FindBy(how= How.XPATH,using = "//div//input[@id='loginIn']")
    public WebElement btnsubmit;


    public  void  Login(String UserName,String Password) throws InterruptedException {
        Thread.sleep(10000);
        txtUsername.sendKeys(UserName);
        txtPassword.sendKeys(Password);




    }

    public  HomePage clickLogin(){
        btnsubmit.click();
        return GetInstance(HomePage.class);
    }


}
