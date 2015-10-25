package org.tw.todo.functional.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserListPage extends Page {


    @FindBy(id = "new-todo")
    private WebElement newUser;

    @FindBy(id = "todo-list")
    private WebElement userList;


    public WebElement getNewUser() {
        return newUser;
    }

    public void setNewUser(WebElement newUser) {
        this.newUser = newUser;
    }

    public WebElement getUserList() {
        return userList;
    }

    public void setUserList(WebElement userList) {
        this.userList = userList;
    }
}
