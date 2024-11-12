package com.ea.test.Steps;

import com.ea.framework.base.Base;
import com.ea.framework.config.Settings;
import com.ea.test.pages.HomePage;
import com.ea.test.pages.LoginPage;


import com.ea.test.pages.Popup;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import org.junit.Assert;

import java.util.List;

public class LoginSteps extends Base {

        @And("^I see the application opened$")
        public void iSeetheApplicationOpened() throws Throwable{
                Settings.logs.Write("Into method iSeetheApplicationOpened");
                CurrentPage=GetInstance(HomePage.class);
                Assert.assertTrue("The login page is not loaded",CurrentPage.As(HomePage.class).isLogin());


        }

        @Then("^I click login link$")
        public void iClickLoginLink() throws Throwable {
                //Navigation to Login Page
                CurrentPage = CurrentPage.As(HomePage.class).clickLogin();
                Thread.sleep(3000);
        }

        @Then("^I enter UserName and Password$")
        public void ienterUserNameandpassword(DataTable dataTable) throws Throwable {

                Settings.logs.Write("Into method ienterUserNameandpassword");
                Thread.sleep(20000);
                Popup pP = new Popup();
                pP.acceptPopup();
                Settings.logs.Write("Clicked on the Pop-up");
                List<List<String>> table = dataTable.asLists(String.class);
                CurrentPage.As(LoginPage.class).Login(table.get(1).get(0).toString(),table.get(1).get(1).toString());
        }

        @Then("^I click login button$")
        public void iClickLoginbutton() throws Throwable {
                CurrentPage=CurrentPage.GetInstance(LoginPage.class).clickLogin();
        }
        @Then("^I should see the userName with hello$")
        public void IshouldseetheuserNamewithhello() throws Throwable {
                Assert.assertEquals("This is not the admin user","Hello admin!",CurrentPage.As(HomePage.class).getLoggedInUser());

        }


        }












