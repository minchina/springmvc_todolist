package org.tw.todo.functional.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Page {


    @FindBy(id = "loginUser")
    private WebElement loginUser;

    @FindBy(id = "loginPass")
    private WebElement loginPass;

    @FindBy(id = "login")
    private WebElement loginButton;

    public void Login(String userName, String password) {
        loginUser.sendKeys(userName);
        loginPass.sendKeys(password);
        loginButton.click();

    }

}
