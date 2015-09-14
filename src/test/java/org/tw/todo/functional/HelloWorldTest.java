package org.tw.todo.functional;

import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;

@RunWith(ConcordionRunner.class)
public class HelloWorldTest {

    public String getGreeting() {
        return "Hello World!";
    }
}
