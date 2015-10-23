package org.tw.todo.functional.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ToDoListPage extends Page {

    @FindBy(id = "user_list")
    private WebElement userListButton;


    public ToDoListPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver,this);
    }

    public String getUserListText() {
        return userListButton.getText();
    }
}
