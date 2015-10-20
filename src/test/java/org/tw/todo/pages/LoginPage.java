package org.tw.todo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Page {

    public static String LOGIN_URL="http://localhost:8080/login";
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
