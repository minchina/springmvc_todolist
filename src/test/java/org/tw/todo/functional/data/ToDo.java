package org.tw.todo.functional.data;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.tw.todo.functional.pages.LoginPage;
import org.tw.todo.functional.pages.Page;
import org.tw.todo.functional.pages.ToDoListPage;
import org.tw.todo.functional.pages.UserListPage;
import org.tw.todo.utils.TestFixture;
import org.tw.todo.utils.WaitUtil;

public class ToDo {

    public static String LOGIN_URL = "http://localhost:8080/login";

    private Page currentPage;

    private WebDriver webDriver;

    public ToDo() {
        webDriver = TestFixture.getWebDriver();
    }

    public ToDo(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void login(String userName, String password) {
        Page.continueFlow(webDriver, LoginPage.class).Login(userName, password);
    }

    public String getToDosButtonText() {
        return Page.continueFlow(webDriver, ToDoListPage.class).getUserListText();
    }

    public void goUserListPage() {
        Page.continueFlow(webDriver, ToDoListPage.class).goToUserListPage();
    }

    public void addNewUser(String userName) throws InterruptedException {
        Page.continueFlow(webDriver, UserListPage.class).addNewUser(userName);
        int currentUser = showAllUsers() + 1;
        String selector = "#todo-list > li:nth-child(" + currentUser + ") > div > a";
        WaitUtil.waitFor(webDriver, By.cssSelector(selector));
    }

    public int showAllUsers() {
        return Page.continueFlow(webDriver, UserListPage.class).getUserList().findElements(By.tagName("li")).size();
    }


    public WebDriver getWebDriver() {
        return webDriver;
    }
}
