package org.tw.todo.functional;

import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.tw.todo.pages.LoginPage;
import org.tw.todo.pages.Page;
import org.tw.todo.pages.ToDoListPage;
import org.tw.todo.utils.TestFixture;

import static org.tw.todo.pages.LoginPage.LOGIN_URL;

@RunWith(ConcordionRunner.class)
public class HelloWorldTest  {


    public static WebDriver webDriver;

    public void login(String userName, String password) {
        webDriver = TestFixture.getWebDriver();
        webDriver.get(LOGIN_URL);
        LoginPage loginPage = Page.continueFlow(webDriver, LoginPage.class);
        loginPage.Login(userName, password);
    }


    public String getUserListText() {
        ToDoListPage toDoListPage = Page.continueFlow(webDriver, ToDoListPage.class);
        return toDoListPage.getUserListText();
    }


    public String getGreeting(String what) {
        return "Hello " + what + "!";
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
