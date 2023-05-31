package com.woniuxy.canteen.service;

import com.woniuxy.canteen.entity.Food;
import com.woniuxy.canteen.entity.PageBean;
import com.woniuxy.canteen.query.FoodQO;

public interface FoodService {
    void add(Food food);
    void update(Food food);
    void delete(int id);
    PageBean<Food> getByPage(FoodQO foodQO, int page);
    PageBean<Food> getByIdPage(int id,int page);
}
