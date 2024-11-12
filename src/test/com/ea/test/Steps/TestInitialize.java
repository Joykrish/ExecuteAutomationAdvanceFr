package com.ea.test.Steps;

import com.ea.framework.base.DriverContext;
import com.ea.framework.base.FrameworkInitialize;
import com.ea.framework.config.ConfigReader;
import com.ea.framework.config.Settings;
import com.ea.framework.utils.DatabaseUtils;
import com.ea.framework.utils.ExcelUtils;
import com.ea.framework.utils.LogUtils;
import io.cucumber.java.Before;
import jxl.read.biff.BiffException;


import java.io.IOException;

public class TestInitialize extends FrameworkInitialize {

    @Before
    public void Initialize() throws InterruptedException, BiffException, IOException {


        ConfigReader.populateSettings();

       // Settings.autConnection = DatabaseUtils.open("jdbc:mysql://localhost:3306/clould_vender", "root", "MayapurDham12!");
        //DatabaseUtils.executeQuery("select * from cloudvenderinfo",Settings.autConnection);


        Settings.logs=new LogUtils();
        Settings.logs.createFile();
        Settings.logs.Write("Framework Initialize");


        InitializeBrowser(Settings.browserType);
        Settings.logs.Write("Initialize the browser");
        DriverContext.browser.goToUrl(Settings.AUTurl);
        Settings.logs.Write("Open the URL "+Settings.AUTurl);
        ExcelUtils utils = new ExcelUtils(Settings.ExcelFilepath);
        Settings.logs.Write("Initialize method /Before method executed  completely");

    }
}
