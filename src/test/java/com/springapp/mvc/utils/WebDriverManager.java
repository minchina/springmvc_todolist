package com.springapp.mvc.utils;

import org.tw.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.tw.PageOperation.on;

public class WebDriverManager {

    private static WebDriver webDriver;

    public static WebDriver getWebDriver() {
        if (webDriver == null){
            System.setProperty("webdriver.chrome.driver", "D:\\Code\\chromedriver.exe");
            webDriver = new ChromeDriver();
            webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }
        return webDriver;
    }

    public static void deleteWebDriver(){
        if(webDriver != null){
            webDriver.close();
        }
    }

    public static <T extends Page> T goToPage(String subURL, Class<T> pageClass){
        webDriver.navigate().to(subURL);
        return on(pageClass);
    }

}
