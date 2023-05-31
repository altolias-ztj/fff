package com.woniuxy.canteen.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.woniuxy.canteen.entity.Food;
import com.woniuxy.canteen.entity.PageBean;
import com.woniuxy.canteen.mapper.FoodMapper;
import com.woniuxy.canteen.query.FoodQO;
import com.woniuxy.canteen.service.FoodService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class FoodServiceImpl implements FoodService {

    @Resource
    private FoodMapper foodMapper;

    @Override
    public void add(Food food) {
        foodMapper.add(food);
    }

    @Override
    public void update(Food food) {
        foodMapper.update(food);
    }

    @Override
    public void delete(int id) {
        foodMapper.delete(id);
    }

    @Override
    public PageBean<Food> getByPage(FoodQO foodQO, int page) {
        int pageSize = 4;
        PageBean<Food> pageBean = new PageBean<>();
        PageHelper.startPage(page, pageSize);
        Page<Food> p = (Page<Food>) foodMapper.getByCondition(foodQO);
        pageBean.setData(p.getResult());
        pageBean.setCurrPage(page);
        pageBean.setPageSize(pageSize);
        pageBean.setActualNum(pageBean.getData().size());
        pageBean.setTotalNums((int) p.getTotal());
        pageBean.setTotalPage(p.getPages());
        return pageBean;
    }

    @Override
    public PageBean<Food> getByIdPage(int id, int page) {
        int pageSize = 3;
        PageBean<Food> pageBean = new PageBean<>();
        PageHelper.startPage(page, pageSize);
        Page<Food> p = (Page<Food>) foodMapper.getCollectByCustomerId(id);
        pageBean.setData(p.getResult());
        pageBean.setCurrPage(page);
        pageBean.setPageSize(pageSize);
        pageBean.setActualNum(pageBean.getData().size());
        pageBean.setTotalNums((int) p.getTotal());
        pageBean.setTotalPage(p.getPages());
        return pageBean;
    }
}
