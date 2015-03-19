package com.springapp.mvc;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BddTest {


    public static String CHROMEDRIVERPATH = "/home/minchina/program/chromedriver";
    public static String CHROMEDRIVER = "webdriver.chrome.driver";
    public static String url = "http://www.baidu.com";
    final String searchKey = "成都信息工程学院";

    @Test
    public void should_(){
        initBrowserPath(CHROMEDRIVER, CHROMEDRIVERPATH);

        WebDriver driver = new ChromeDriver();

        driver.navigate().to(url);
//        driver.get(url);
        String firstPageTitle = driver.getTitle();
        assertThat(firstPageTitle,is("百度一下，你就知道"));
        ((JavascriptExecutor)driver).executeScript("alert(\'hehe\')");
        WebElement element = driver.findElement(By.id("kw"));
        element.sendKeys(searchKey);

        element.submit();

        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().substring(0, searchKey.length()).endsWith(searchKey);
            }
        });

        String secondPageTitle = driver.getTitle();
        System.out.println(driver.getCurrentUrl());
        assertThat(secondPageTitle.substring(0, searchKey.length()), is(searchKey));
        driver.quit();

    }

    private void initBrowserPath(String driver, String driverPath){
        System.setProperty(driver, driverPath);
    }
}
