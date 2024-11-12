package com.ea.framework.base;


import org.openqa.selenium.support.PageFactory;

public class Base {

public static Basepage CurrentPage;

public  <TPage extends Basepage> TPage GetInstance(Class<TPage> page){
    Object obj= PageFactory.initElements(DriverContext.driver,page);

    return  page.cast(obj);
}

}
