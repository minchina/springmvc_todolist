package org.tw.todo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver webDriver;

    @FindBy(id = "loginUser")
    private WebElement loginUser;

    @FindBy(id = "loginPass")
    private WebElement loginPass;

    @FindBy(id = "login")
    private WebElement loginButton;


    public LoginPage(WebDriver driver) {

        this.webDriver = driver;
        PageFactory.initElements(getWebDriver(), this);
    }

    public void open() {
        this.webDriver.get("http://localhost:8080/login");
    }

    public void Login(String userName, String password) {
        loginUser.sendKeys(userName);
        loginPass.sendKeys(password);
        loginButton.click();

    }

    public void goToIndex(){
        this.webDriver.get("http://localhost:8080/");
        ToDoListPage toDoListPage = new ToDoListPage(webDriver);
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }


}
