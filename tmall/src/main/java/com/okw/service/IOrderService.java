package com.okw.service;

import com.okw.pojo.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IOrderService {
    String waitPay = "waitPay";
    String waitDelivery = "waitDelivery";
    String waitConfirm = "waitConfirm";
    String waitReview = "waitReview";
    String finish = "finish";
    String delete = "delete";

    List<Order> listOrder();

    Order getOrder(int id);

    void addOrder(Order order);

    void deleteOrder(int id);

    void updateOrder(Order order);

}
