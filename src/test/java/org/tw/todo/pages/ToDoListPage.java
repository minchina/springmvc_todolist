package org.tw.todo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ToDoListPage {

    @FindBy(id = "user_list")
    private WebElement userListButton;


    public ToDoListPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver,this);
    }

    public void goToUsers(){
        userListButton.click();
    }
}
