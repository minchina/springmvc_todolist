package com.springapp.mvc;

import com.springapp.mvc.utils.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.tw.BaiduHomePage;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BaiduHomePageTest {

    public static BaiduHomePage baiduHomePage;
    public static WebDriver webDriver;

    @BeforeClass
    public static void init() {
        webDriver = WebDriverManager.getWebDriver();
        baiduHomePage = WebDriverManager.goToPage("http://www.baidu.com", BaiduHomePage.class);
    }

    @Test
    public void should_oepn_home_page_success() {
        waitForReady("百度");
        assertThat(baiduHomePage.getNews().getText(), is("新闻"));
    }

    @Test
    public void should_do_search() {
        baiduHomePage.doSearch("cuit");
        waitForReady("cuit");
        assertThat(webDriver.getTitle().startsWith("cuit"), is(true));
    }
    @Test
    public void should_execute_js() throws InterruptedException {

        WebElement webElement = webDriver.findElement(By.xpath("//*[contains(text(), '百度首页')]"));
        String _class = "." + webElement.getAttribute("class");
        String js = "$('.toindex')[0].setAttribute('style','background-color:red')";
        ((JavascriptExecutor) webDriver).executeScript(js);

        assertThat(webElement.getAttribute("style"), is("background-color: red;"));
    }

    private void waitForReady(final String startWith) {
        (new WebDriverWait(webDriver, 10)).until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return driver.getTitle().startsWith(startWith);
            }
        });
    }

    @AfterClass
    public static void destroy() {
        WebDriverManager.deleteWebDriver();
    }
}
