package com.ea.test.pages;

import com.ea.framework.base.Basepage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage extends Basepage {

    public  HomePage(){

    }

    @FindBy(how= How.LINK_TEXT,using = "Login")
    public WebElement lnkLogin;
    @FindBy(how= How.LINK_TEXT,using = "Employee List")
    public WebElement lnkEmployeeList;
@FindBy(how=How.XPATH,using = "//a[text()='Hello admin!']")
public WebElement linkUserName;

    public Basepage clickLogin(){
        lnkLogin.click();
        return GetInstance(LoginPage.class);
    }
    public boolean isLogin(){
        return lnkLogin.isDisplayed();
    }

    public String getLoggedInUser(){
        return linkUserName.getText();
    }

    public EmployeeListPage ClickEmployeeList() {
        lnkEmployeeList.click();
        return GetInstance(EmployeeListPage.class);
    }

}
