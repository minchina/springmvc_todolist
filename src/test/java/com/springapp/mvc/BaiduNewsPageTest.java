package com.springapp.mvc;

import org.junit.BeforeClass;
import org.junit.Test;
import org.tw.BaiduNewsPage;

public class BaiduNewsPageTest extends PageTest{

    private static BaiduNewsPage baiduNewsPage;


    @BeforeClass
    public static void initSystem() {
        baiduNewsPage = BaiduNewsPage.navigateTo(webDriver);
    }

    @Test
    public void should_go_to_news_page(){
        System.out.println(webDriver.getTitle());
    }
}
