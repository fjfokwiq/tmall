package com.okw.service.impl;

import com.okw.mapper.OrderMapper;
import com.okw.pojo.Order;
import com.okw.pojo.OrderExample;
import com.okw.pojo.User;
import com.okw.service.IOrderService;
import com.okw.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("orderService")
public class OrderServiceImpl implements IOrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    @Qualifier("userService")
    private IUserService userService;

    @Override
    public List<Order> listOrder() {
        OrderExample example = new OrderExample();
        example.setOrderByClause("id desc");
        List<Order> orderList = orderMapper.selectByExample(example);
        setUser(orderList);
        return orderList;
    }

    private void setUser(List<Order> orderList) {
        for (Order order : orderList) {
            setUser(order);
        }
    }

    private void setUser(Order order) {
        User user=userService.getUser(order.getUid());
        order.setUser(user);
    }

    @Override
    public Order getOrder(int id) {
        return orderMapper.selectByPrimaryKey(id);
    }

    @Override
    public void addOrder(Order order) {
        orderMapper.insertSelective(order);
    }

    @Override
    public void deleteOrder(int id) {
        orderMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void updateOrder(Order order) {
        orderMapper.updateByPrimaryKeySelective(order);
    }
}
