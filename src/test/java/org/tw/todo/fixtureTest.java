package org.tw.todo;


import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.tw.todo.pages.LoginPage;
import org.tw.todo.pages.TestFixure;

import static org.junit.Assert.assertTrue;

public class FixtureTest {

    private static WebDriver driver;

    @BeforeClass
    public static void Setup() {
        driver = TestFixure.getWebDriver();
    }
    

    @Test
    public void shouldGetWebDriver() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.Login("demo", "demo");
        assertTrue(true);
    }

    @AfterClass
    public static void destory() {
        driver.close();
    }
}
