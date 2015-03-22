package com.springapp.mvc;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.tw.BaiduHomePage;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BaiduHomePageTest {
    public static WebDriver webDriver;


    @BeforeClass
    public static void initSystem(){
        System.setProperty("webdriver.chrome.driver","D:\\Code\\chromedriver.exe");
        webDriver = new ChromeDriver();
    }

    @Test
    public void should_get_the_baidu_home_page_object(){

        BaiduHomePage baiduHomePage = BaiduHomePage.navigateTo(webDriver);

        (new WebDriverWait(webDriver, 10)).until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return driver.getTitle().startsWith("百度");
            }
        });
        assertThat(baiduHomePage.getNews().getText(), is("新闻"));
    }

    @AfterClass
    public static void closeDriver(){
        webDriver.close();
    }

}
