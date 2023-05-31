package com.woniuxy.canteen.mapper;

import com.woniuxy.canteen.entity.Menu;

import java.util.List;

public interface MenuMapper {
    List<Menu> getByStaffId(int id);

    Menu getById(int id);
}
