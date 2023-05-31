package com.woniuxy.canteen.mapper;

import com.woniuxy.canteen.entity.Clocking;
import com.woniuxy.canteen.query.ClockingQO;

import java.util.List;

public interface ClockingMapper {
    void add(Clocking clocking);

    void delete(int id);

    List<Clocking> getByCondition(ClockingQO clockingQO);
}
