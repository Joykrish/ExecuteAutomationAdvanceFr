package com.ea.test.pages;


import com.ea.framework.base.Basepage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by Karthik-pc on 12/6/2016.
 */
public class EmployeeListPage extends Basepage {

    @FindBy(how = How.NAME, using = "searchTerm")
    public WebElement txtSearch;

    @FindBy(how = How.LINK_TEXT, using = "Create New")
    public WebElement lnkCreateNew;

    @FindBy(how = How.CLASS_NAME, using = "table")
    public WebElement tblEmployeeList;


    public CreateEmployeePage ClickCreateNew()
    {
        lnkCreateNew.click();
        return GetInstance(CreateEmployeePage.class);
    }

    public WebElement GetEmployeeList()
    {
        return tblEmployeeList;
    }

}
