package org.tw.todo.functional;

import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.tw.todo.functional.data.ToDo;

@RunWith(ConcordionRunner.class)
public class HelloWorldTest {


    private ToDo toDo;


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
