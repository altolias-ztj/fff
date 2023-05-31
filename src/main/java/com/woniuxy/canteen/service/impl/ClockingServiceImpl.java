package com.woniuxy.canteen.service.impl;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.woniuxy.canteen.entity.Clocking;
import com.woniuxy.canteen.entity.PageBean;
import com.woniuxy.canteen.mapper.ClockingMapper;
import com.woniuxy.canteen.query.ClockingQO;
import com.woniuxy.canteen.service.ClockingService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ClockingServiceImpl implements ClockingService {
    @Resource
    private ClockingMapper clockingMapper;

    @Override
    public void add(Clocking clocking) {
        clockingMapper.add(clocking);
    }

    @Override
    public void delete(int id) {
        clockingMapper.delete(id);
    }

    @Override
    public PageBean<Clocking> getByPage(ClockingQO clockingQO, int page) {
        int pageSize = 3;
        PageBean<Clocking> pageBean = new PageBean<>();
        PageHelper.startPage(page, pageSize);
        Page<Clocking> p = (Page<Clocking>) clockingMapper.getByCondition(clockingQO);
        pageBean.setData(p.getResult());
        pageBean.setCurrPage(page);
        pageBean.setPageSize(pageSize);
        pageBean.setActualNum(pageBean.getData().size());
        pageBean.setTotalNums((int) p.getTotal());
        pageBean.setTotalPage(p.getPages());
        return pageBean;
    }
}
