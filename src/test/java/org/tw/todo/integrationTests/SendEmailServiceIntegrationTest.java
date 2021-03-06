package org.tw.todo.integrationTests;

import com.tw.todolist.domain.Customer;
import com.tw.todolist.domain.Order;
import com.tw.todolist.service.OrderManager;
import com.tw.todolist.service.impl.RegistrationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })

public class SendEmailServiceIntegrationTest {

    @Autowired
    private OrderManager orderManager;

    @Autowired
    private RegistrationService registrationService;

    @Test
    public void shouldRunSendEmailWell() {

        Customer customer = new Customer("mao", "nc", "minchina91@gmail.com");
        Order order = new Order(customer, "1234");
        orderManager.send(order);
    }

    @Test
    public void shouldRunSendEmailWell1() {

        Customer customer = new Customer("mao", "nc", "minchina91@gmail.com");
        Order order = new Order(customer, "1234");
        orderManager.sendTo(order);
    }

    @Test
    public void shouldSendEmailSuccessByTemplate() {

        Customer customer = new Customer("mao", "nc", "minchina91@gmail.com");
        Order order = new Order(customer, "1234");
        registrationService.register(order);

    }
}
