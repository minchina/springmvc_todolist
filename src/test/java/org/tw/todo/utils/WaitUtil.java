package org.tw.todo.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtil {

    public static void waitFor(WebDriver webDriver, By by) {

        WebDriverWait wait = new WebDriverWait(webDriver, 500);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
}
