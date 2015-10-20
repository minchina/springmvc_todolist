package org.tw.todo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

public abstract class Page {


    public static <T extends Page> T continueFlow(WebDriver webDriver,Class<T> pageClass) {
        T page = PageFactory.initElements(webDriver, pageClass);
        PageFactory.initElements(new DefaultElementLocatorFactory(webDriver), page);
        return page;
    }
}
