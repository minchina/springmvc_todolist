package com.springapp.mvc;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.core.Is.is;
import static org.springframework.test.util.MatcherAssertionErrors.assertThat;

public class ChromeTest {

    public static String chromeDriverPath = "/home/minchina/program/chromedriver";
    public static String chromeDriver = "webdriver.chrome.driver";

    @Test
    public void should_search_and_go_to_result_page_success(){
        final String searchKey = "成都信息工程学院";
        System.setProperty(chromeDriver, chromeDriverPath);
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.baidu.com");
        String firstPageTitle = driver.getTitle();
        assertThat(firstPageTitle,is("百度一下，你就知道"));
        
        WebElement element = driver.findElement(By.id("kw"));
        element.sendKeys(searchKey);
        element.submit();
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().substring(0, searchKey.length()).endsWith(searchKey);
            }
        });
        String secondPageTitle = driver.getTitle();
        assertThat(secondPageTitle.substring(0, searchKey.length()), is(searchKey));
        driver.quit();
    }

    private void print(String context){
        System.out.println(context);
    }
}
