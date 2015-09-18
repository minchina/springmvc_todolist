package org.tw.todo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestFixure {

    static {
        System.setProperty("webdriver.chrome.driver", "/Users/ncmao/dev/package/chromedriver");
    }

    public static WebDriver getWebDriver() {

        return new ChromeDriver();
    }
}
