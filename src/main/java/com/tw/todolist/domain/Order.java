package com.tw.todolist.domain;

public class Order {

    private Customer customer;
    private String orderNumber;


    public Order(Customer customer, String orderNumber) {
        this.customer = customer;
        this.orderNumber = orderNumber;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
