package org.tw;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BaiduNewsPage {

    private WebDriver webDriver;

    public BaiduNewsPage(WebDriver driver) {
        this.webDriver = driver;
    }

    public static BaiduNewsPage navigateTo(WebDriver webDriver){
        webDriver.get("http://news.baidu.com");
        return PageFactory.initElements(webDriver, BaiduNewsPage.class);
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
}
