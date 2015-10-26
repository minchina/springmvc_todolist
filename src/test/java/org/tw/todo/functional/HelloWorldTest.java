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
import org.tw.todo.utils.WaitUtil;

import static java.lang.Thread.sleep;
import static org.tw.todo.functional.pages.LoginPage.LOGIN_URL;

@RunWith(ConcordionRunner.class)
public class HelloWorldTest {

    private ToDoListPage toDoListPage;
    private UserListPage userListPage;
    public static WebDriver webDriver;

    public void login(String userName, String password) {
        webDriver = TestFixture.getWebDriver();
        webDriver.get(LOGIN_URL);
        Page.continueFlow(webDriver, LoginPage.class).Login(userName, password);
    }


    public String getUserListText() {
        toDoListPage = Page.continueFlow(webDriver, ToDoListPage.class);
        return toDoListPage.getUserListText();
    }

    public void goToUserListPage() {
        toDoListPage.goToUserListPage();
    }

    public int showAllUsers() {
        return Page.continueFlow(webDriver, UserListPage.class).getUserList().findElements(By.tagName("li")).size();
    }

    public void addNewUser(String userName) throws InterruptedException {
        Page.continueFlow(webDriver, UserListPage.class).addNewUser(userName);
        int currentUser = showAllUsers() + 1;
        String selector = "#todo-list > li:nth-child(" + currentUser + ") > div > a";
        WaitUtil.waitFor(webDriver, By.cssSelector(selector));
    }


    @AfterClass
    public static void close() {
        webDriver.close();
    }
}
