package org.tw.todo.functional;

import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.tw.todo.functional.pages.LoginPage;
import org.tw.todo.functional.pages.Page;
import org.tw.todo.functional.pages.ToDoListPage;
import org.tw.todo.functional.pages.UserListPage;
import org.tw.todo.utils.TestFixture;

import static org.tw.todo.functional.pages.LoginPage.LOGIN_URL;

@RunWith(ConcordionRunner.class)
public class HelloWorldTest  {

    private ToDoListPage toDoListPage;
    private UserListPage userListPage;
    public static WebDriver webDriver;

    public void login(String userName, String password) {
        webDriver = TestFixture.getWebDriver();
        webDriver.get(LOGIN_URL);
        LoginPage loginPage = Page.continueFlow(webDriver, LoginPage.class);
        loginPage.Login(userName, password);
    }


    public String getUserListText() {
        toDoListPage = Page.continueFlow(webDriver, ToDoListPage.class);
        return toDoListPage.getUserListText();
    }

    public int showAllUsers() {
        toDoListPage.goToUserListPage();
        userListPage = Page.continueFlow(webDriver, UserListPage.class);
        return userListPage.getUserList().findElements(By.tagName("li")).size();
    }

    public String addNewUser(String userName) {
        return userListPage.addNewUser(userName);
    }


    public String getGreeting(String what) {
        return "Hello " + what + "!";
    }


    @AfterClass
    public static void close() {
        webDriver.close();
    }
}
