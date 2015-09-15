package org.tw.todo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestFixure {

    public static WebDriver getWebDriver() {
        return new ChromeDriver();
    }
}
