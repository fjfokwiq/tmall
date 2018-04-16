package com.okw.controller;

import com.okw.pojo.Order;
import com.okw.service.IOrderItemService;
import com.okw.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class OrderController {
    @Autowired
    @Qualifier("orderService")
    private IOrderService orderService;

    @Autowired
    @Qualifier("orderItemService")
    private IOrderItemService orderItemService;

    @RequestMapping("admin_order_list")
    public String listOrder(Model model) {
        List<Order> orderList=orderService.listOrder();
        orderItemService.fill(orderList);
        model.addAttribute("orderList", orderList);
        return "admin/listOrder";
    }
}
