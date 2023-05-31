package com.woniuxy.canteen.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.woniuxy.canteen.entity.Order;
import com.woniuxy.canteen.entity.PageBean;
import com.woniuxy.canteen.mapper.FoodMapper;
import com.woniuxy.canteen.mapper.OrderMapper;
import com.woniuxy.canteen.query.OrderQO;
import com.woniuxy.canteen.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderMapper orderMapper;

    @Resource
    private FoodMapper foodMapper;

    @Override
    public void add(Order order) {
        orderMapper.add(order);
    }

    @Override
    public void update(Order order) {
        orderMapper.update(order);
    }

    @Override
    public void delete(int id) {
        orderMapper.delete(id);
    }

    @Override
    public PageBean<Order> getByPage(OrderQO orderQO, int page) {
        int pageSize = 3;
        PageBean<Order> pageBean = new PageBean<>();
        PageHelper.startPage(page, pageSize);
        Page<Order> p = (Page<Order>) orderMapper.getByCondition(orderQO);
        pageBean.setData(p.getResult());
        pageBean.setCurrPage(page);
        pageBean.setPageSize(pageSize);
        pageBean.setActualNum(pageBean.getData().size());
        pageBean.setTotalNums((int) p.getTotal());
        pageBean.setTotalPage(p.getPages());
        return pageBean;
    }

    @Override
    public PageBean<Order> getByIdPage(int id, int page) {
        int pageSize = 3;
        PageBean<Order> pageBean = new PageBean<>();
        PageHelper.startPage(page, pageSize);
        Page<Order> p = (Page<Order>) foodMapper.getOrderByCustomerId(id);
        pageBean.setData(p.getResult());
        pageBean.setCurrPage(page);
        pageBean.setPageSize(pageSize);
        pageBean.setActualNum(pageBean.getData().size());
        pageBean.setTotalNums((int) p.getTotal());
        pageBean.setTotalPage(p.getPages());
        return pageBean;
    }

}
