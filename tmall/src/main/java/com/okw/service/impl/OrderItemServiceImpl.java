package com.okw.service.impl;

import com.okw.mapper.OrderItemMapper;
import com.okw.pojo.Order;
import com.okw.pojo.OrderItem;
import com.okw.pojo.OrderItemExample;
import com.okw.pojo.Product;
import com.okw.service.IOrderItemService;
import com.okw.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("orderItemService")
public class OrderItemServiceImpl implements IOrderItemService {
    @Autowired
    private OrderItemMapper orderItemMapper;

    @Autowired
    @Qualifier("productService")
    private IProductService productService;

    @Override
    public List<OrderItem> listOrderItem() {
        OrderItemExample example = new OrderItemExample();
        example.setOrderByClause("id desc");

        return orderItemMapper.selectByExample(example);
    }

    @Override
    public OrderItem getOrderItem(int id) {
        OrderItem orderItem = orderItemMapper.selectByPrimaryKey(id);
        setProperty(orderItem);
        return orderItemMapper.selectByPrimaryKey(id);
    }

    private void setProperty(OrderItem orderItem) {
        Product product = productService.getProduct(orderItem.getPid());
        orderItem.setProduct(product);
    }

    @Override
    public void addOrderItem(OrderItem orderItem) {
        orderItemMapper.insertSelective(orderItem);
    }

    @Override
    public void updateOrderItem(OrderItem orderItem) {
        orderItemMapper.updateByPrimaryKeySelective(orderItem);
    }

    @Override
    public void deleteOrderItem(int id) {
        orderItemMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void fill(List<Order> orderList) {
        for (Order order : orderList) {
            fill(order);
        }
    }

    @Override
    public void fill(Order order) {
        OrderItemExample example = new OrderItemExample();
        example.createCriteria().andOidEqualTo(order.getId());
        example.setOrderByClause("id desc");
        List<OrderItem> orderItemList = orderItemMapper.selectByExample(example);
        setProperty(orderItemList);

        float total=0;
        int totalNumber=0;

        for (OrderItem orderItem : orderItemList) {
            total+=orderItem.getNumber()*orderItem.getProduct().getPromotePrice();
            totalNumber+=orderItem.getNumber();
        }

        order.setTotal(total);
        order.setTotalNumber(totalNumber);
        order.setOrderItems(orderItemList);

    }

    private void setProperty(List<OrderItem> orderItemList) {
        for (OrderItem orderItem : orderItemList) {
            setProperty(orderItem);
        }
    }
}
