package org.tw.todo;

import com.tw.todolist.domain.Customer;
import com.tw.todolist.domain.Order;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class SendEmailTest {

    @Test
    public void shouldThrowException() {
        Customer customer = new Customer("mao", "nc", "minchina91@gmail.com");
        Order order = new Order(customer, "1234");
    }

    @Test
    public void 仅仅只是为了测试中文 () {
        Boolean True = Boolean.TRUE;
        assertTrue(True);
    }
}
