package com.tw.todolist.service;


import com.tw.todolist.domain.Order;

public interface OrderManager {

    void send(Order order);

    void sendTo(Order order);
}
