package com.woniuxy.canteen.service;

import com.woniuxy.canteen.entity.Order;
import com.woniuxy.canteen.entity.PageBean;
import com.woniuxy.canteen.query.OrderQO;

public interface OrderService {
    void add(Order order);

    void update(Order order);

    void delete(int id);

    PageBean<Order> getByPage(OrderQO orderQO, int page);

    PageBean<Order> getByIdPage(int id, int page);
}
