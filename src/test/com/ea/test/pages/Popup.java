package com.ea.test.pages;

import com.ea.framework.base.Basepage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Popup extends Basepage {

    @FindBy(how= How.XPATH,using = "//div[@class='cookie-dialog']")
    public WebElement popUP;

    @FindBy(how= How.XPATH,using = "//div[@class='cookie-dialog']//p//following-sibling::button")
    public WebElement acceptButton;

    public Popup(){

    }

    public void acceptPopup(){
        if(popUP.isDisplayed()){
            acceptButton.click();
        }

    }


}
