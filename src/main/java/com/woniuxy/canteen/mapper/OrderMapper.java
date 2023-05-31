package com.woniuxy.canteen.mapper;

import com.woniuxy.canteen.entity.Order;
import com.woniuxy.canteen.query.OrderQO;

import java.util.List;

public interface OrderMapper {
    void add(Order order);

    void update(Order order);

    void delete(int id);

    List<Order> getByCondition(OrderQO orderQO);
}
