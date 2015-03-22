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
    private static BaiduHomePage baiduHomePage;


    @BeforeClass
    public static void initSystem() {
        System.setProperty("webdriver.chrome.driver", "D:\\Code\\chromedriver.exe");
        webDriver = new ChromeDriver();
        baiduHomePage = BaiduHomePage.navigateTo(webDriver);
    }

    @Test
    public void should_get_the_baidu_home_page_object() {
        waitForReady("百度");
        assertThat(baiduHomePage.getNews().getText(), is("新闻"));
    }

    @Test
    public void should_do_search() {
        baiduHomePage.doSearch("cuit");
        waitForReady("cuit");
        assertThat(webDriver.getTitle().startsWith("cuit"), is(true));
    }

    @AfterClass
    public static void closeDriver() {
        webDriver.close();
    }

    private void waitForReady(final String startWith) {
        (new WebDriverWait(webDriver, 10)).until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return driver.getTitle().startsWith(startWith);
            }
        });
    }


}
