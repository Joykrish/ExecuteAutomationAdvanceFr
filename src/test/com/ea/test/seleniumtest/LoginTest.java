package com.ea.test.seleniumtest;


import com.ea.framework.utils.ExcelUtils;

import com.ea.test.Steps.TestInitialize;
import com.ea.test.pages.HomePage;
import com.ea.test.pages.LoginPage;
import com.ea.test.pages.Popup;


import org.junit.Test;





public class LoginTest extends TestInitialize {
    @Test
    public void Login() throws InterruptedException {


        CurrentPage = GetInstance(HomePage.class);
        Popup pP = new Popup();
        pP.acceptPopup();
        CurrentPage = CurrentPage.As(HomePage.class).clickLogin();
        Thread.sleep(20000);
        pP.acceptPopup();
        CurrentPage.As(LoginPage.class).Login(ExcelUtils.readCell("UserName", 1), ExcelUtils.readCell("Password", 1));
        pP.acceptPopup();


    }
}
