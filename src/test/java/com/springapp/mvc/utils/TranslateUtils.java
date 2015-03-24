package com.springapp.mvc.utils;

import org.openqa.selenium.WebElement;

public class TranslateUtils {
    public static String translate(WebElement webElement, String flag) {
        String text = webElement.getText();
        int start = text.indexOf(flag);
        int end = start + flag.length();
        return "\""+ text.substring(0, start) +"<span style='background-color:red'>"+text.substring(start,end)+"</span>"+text.substring(end) + "\"";
    }
}
