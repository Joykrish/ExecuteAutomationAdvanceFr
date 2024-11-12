package com.ea.framework.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

abstract public class Basepage extends Base {

    public Basepage() {
        PageFactory.initElements(DriverContext.driver, this);
    }

    public <Tpage extends Basepage> Tpage As(Class<Tpage> pageInstance) {
        try {
            return (Tpage)this;
        } catch (Exception e) {
            e.getStackTrace();
        }
        return null;
    }
}