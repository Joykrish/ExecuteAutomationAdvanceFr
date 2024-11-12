package com.ea.test.Steps;


import com.ea.framework.utils.CucumberUtils;
import com.ea.test.pages.CreateEmployeePage;
import com.ea.test.pages.EmployeeListPage;
import com.ea.test.pages.HomePage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;


import java.util.List;

import static com.ea.framework.base.Base.CurrentPage;


public class EmployeeSteps  {
    @And("^I click employeeList link$")
    public void iClickEmployeeListLink() throws Throwable {
        CurrentPage = CurrentPage.As(HomePage.class).ClickEmployeeList();
        Thread.sleep(3000);
    }


    @Then("^I click create new button$")
    public void iClickCreatenewButton() throws Throwable {
        CurrentPage = CurrentPage.As(EmployeeListPage.class).ClickCreateNew();
        Thread.sleep(3000);
    }

    @And("^I enter following details$")
    public void iEnterFollowingDetails(DataTable table) throws Throwable {

        System.out.println("Table is: " + table);

// Convert the DataTable to a dictionary (populates dataCollectionMap)
        CucumberUtils.convertDataTableToDictionary(table);

// Example rowNumber for retrieving data
        int rowNumber = 1;

// Retrieve each cell value by column name and row number
        String name = CucumberUtils.getCellValue("Name", rowNumber);
        String salary = CucumberUtils.getCellValue("Salary", rowNumber);
        String durationWorked = CucumberUtils.getCellValue("DurationWorked", rowNumber);
        String grade = CucumberUtils.getCellValue("Grade", rowNumber);
        String email = CucumberUtils.getCellValue("Email", rowNumber);

// Print the converted data to check it has been stored correctly
        System.out.println("Converted Data: " + CucumberUtils.dataCollectionMap);

// Call the CreateEmployee method with retrieved values
        CurrentPage.As(CreateEmployeePage.class)
                .CreateEmployee(name, salary, durationWorked, grade, email);

        Thread.sleep(3000);

    }

    @And("^I click create button$")
    public void iClickCreateButton() throws Throwable {
        CurrentPage.As(CreateEmployeePage.class).ClickCreateButton();
        Thread.sleep(3000);
    }

}
