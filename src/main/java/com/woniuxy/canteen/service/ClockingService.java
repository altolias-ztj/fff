package com.woniuxy.canteen.service;

import com.woniuxy.canteen.entity.Clocking;
import com.woniuxy.canteen.entity.PageBean;
import com.woniuxy.canteen.query.ClockingQO;

import java.util.List;

public interface ClockingService {
    void add(Clocking clocking);
    void delete(int id);
    PageBean<Clocking> getByPage(ClockingQO clockingQO, int page);
}
