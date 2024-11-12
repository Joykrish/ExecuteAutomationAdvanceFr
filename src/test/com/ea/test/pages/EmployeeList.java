package com.ea.test.pages;

import com.ea.framework.base.Basepage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class EmployeeList extends Basepage {

    public EmployeeList(){

    }


    @FindBy(how= How.CSS,using = "//a[@class='btn btn-primary']")
    public WebElement btnCreateEmployee;
}
