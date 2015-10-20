package org.tw.todo.functional;

import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.tw.todo.pages.LoginPage;
import org.tw.todo.pages.TestFixure;
import org.tw.todo.pages.ToDoListPage;

@RunWith(ConcordionRunner.class)
public class HelloWorldTest  {

    public static LoginPage loginPage;
    public static WebDriver webDriver;

    @BeforeClass
    public static void setUp() {
        webDriver = TestFixure.getWebDriver();
        loginPage = new LoginPage(webDriver);
        loginPage.open();
    }

    public void goToIndex(){

        loginPage.goToIndex();
    }

    public void login(String userName, String password) {
        loginPage.Login(userName, password);
    }

    public String getGreeting(String what) {
        return "Hello " + what + "!";
    }

    public LoginPage getLoginPage() {
        return loginPage;
    }

    public void setLoginPage(LoginPage loginPage) {
        this.loginPage = loginPage;
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @AfterClass
    public static void close() {
        webDriver.close();
    }
}
