package org.tw;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class BaiduPage  {
    public static WebDriver driver;

    public BaiduPage() {
        driver = new ChromeDriver();
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver driver) {
        BaiduPage.driver = driver;
    }
}
