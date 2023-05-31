package com.woniuxy.canteen.mapper;

import com.woniuxy.canteen.entity.Food;
import com.woniuxy.canteen.entity.Order;
import com.woniuxy.canteen.query.FoodQO;

import java.util.List;

public interface FoodMapper {
    void add(Food food);
    void update(Food food);
    void delete(int id);
    List<Food> getCollectByCustomerId(int id);
    List<Order> getOrderByCustomerId(int id);
    List<Food> getByCondition(FoodQO foodQO);
}
