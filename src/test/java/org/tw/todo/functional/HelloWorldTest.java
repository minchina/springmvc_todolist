package org.tw.todo.functional;

import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.tw.todo.pages.LoginPage;
import org.tw.todo.pages.TestFixure;

@RunWith(ConcordionRunner.class)
public class HelloWorldTest  {

    private LoginPage loginPage;
    private WebDriver webDriver;

    public HelloWorldTest() {
        webDriver = TestFixure.getWebDriver();
        loginPage = new LoginPage(webDriver);
        loginPage.open();

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
}
