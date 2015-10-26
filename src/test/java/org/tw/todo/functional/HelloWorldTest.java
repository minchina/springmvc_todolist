package org.tw.todo.functional;

import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.tw.todo.functional.data.ToDo;
import org.tw.todo.functional.pages.Page;
import org.tw.todo.functional.pages.ToDoListPage;
import org.tw.todo.functional.pages.UserListPage;
import org.tw.todo.utils.WaitUtil;

@RunWith(ConcordionRunner.class)
public class HelloWorldTest {


    private ToDo toDo;

    public static WebDriver webDriver;

    public void startApp() {
        toDo = new ToDo();
        toDo.getWebDriver().get(ToDo.LOGIN_URL);
    }

    public void login(String userName, String password) {
        toDo.login(userName, password);
    }

    public String getToDosButtonText() {
        return toDo.getToDosButtonText();
    }

    public void goUserListPage() {
        toDo.goUserListPage();
    }

    public void addNewUser(String userName) throws InterruptedException {
         toDo.addNewUser(userName);
    }

    public int getAllUsers() {
        return toDo.showAllUsers();
    }


    public void destroy() {
        toDo.getWebDriver().close();
    }


}
