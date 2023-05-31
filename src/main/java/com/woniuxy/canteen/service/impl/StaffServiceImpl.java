package com.woniuxy.canteen.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.woniuxy.canteen.entity.PageBean;
import com.woniuxy.canteen.entity.Staff;
import com.woniuxy.canteen.mapper.StaffMapper;
import com.woniuxy.canteen.service.StaffService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StaffServiceImpl implements StaffService {
    @Resource
    private StaffMapper staffMapper;

    @Override
    public void add(Staff staff) {
        staffMapper.add(staff);
    }

    @Override
    public void update(Staff staff) {
        staffMapper.update(staff);
    }

    @Override
    public void delete(int id) {
        staffMapper.delete(id);
    }

    @Override
    public PageBean<Staff> getByPage(Staff staff, int page) {
        int pageSize = 3;
        PageBean<Staff> pageBean = new PageBean<>();
        PageHelper.startPage(page, pageSize);
        Page<Staff> p = (Page<Staff>) staffMapper.getByCondition(staff);
        pageBean.setData(p.getResult());
        pageBean.setCurrPage(page);
        pageBean.setPageSize(pageSize);
        pageBean.setActualNum(pageBean.getData().size());
        pageBean.setTotalNums((int) p.getTotal());
        pageBean.setTotalPage(p.getPages());
        return pageBean;
    }

    @Override
    public Staff login(String account) {
        return staffMapper.getByAccount(account);
    }

    @Override
    public List<Staff> getAll() {
        return staffMapper.getByCondition(null);
    }

    @Override
    public boolean isExist(String account) {
        return staffMapper.getCountByAccount(account) == 0;
    }
}
