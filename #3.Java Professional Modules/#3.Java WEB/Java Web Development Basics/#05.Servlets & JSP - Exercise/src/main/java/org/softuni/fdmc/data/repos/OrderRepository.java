package org.softuni.fdmc.data.repos;

import org.softuni.fdmc.data.models.Order;

import java.util.LinkedList;
import java.util.List;

public class OrderRepository {

    private List<Order> orders;

    public OrderRepository() {
        this.orders = new LinkedList<>();
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
