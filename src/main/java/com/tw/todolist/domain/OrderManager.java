package com.tw.todolist.domain;


public interface OrderManager {

    void send(Order order);

    void sendTo(Order order);
}
