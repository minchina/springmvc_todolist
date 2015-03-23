package org.tw;

import org.openqa.selenium.WebDriver;

public class BaiduNewsPage extends Page{

    private WebDriver webDriver;

    public BaiduNewsPage(WebDriver driver) {
        this.webDriver = driver;
    }


    public WebDriver getWebDriver() {
        return webDriver;
    }

    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
}
