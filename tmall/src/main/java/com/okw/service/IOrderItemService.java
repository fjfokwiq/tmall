package com.okw.service;

import com.okw.pojo.Order;
import com.okw.pojo.OrderItem;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IOrderItemService {

    List<OrderItem> listOrderItem();

    OrderItem getOrderItem(int id);

    void addOrderItem(OrderItem orderItem);

    void updateOrderItem(OrderItem orderItem);

    void deleteOrderItem(int id);

    void fill(List<Order> orderList);

    void fill(Order order);

}
