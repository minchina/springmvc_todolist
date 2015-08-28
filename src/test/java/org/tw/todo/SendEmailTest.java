package org.tw.todo;

import com.tw.todolist.domain.Customer;
import com.tw.todolist.domain.Order;
import com.tw.todolist.service.impl.RegistrationService;
import org.junit.Test;

public class SendEmailTest {

    @Test
    public void shouldThrowException() {
        Customer customer = new Customer("mao", "nc", "minchina91@gmail.com");
        Order order = new Order(customer, "1234");
    }
}
