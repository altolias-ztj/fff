package com.woniuxy.canteen.service;

import com.woniuxy.canteen.entity.Menu;

import java.util.List;

public interface MenuService {
    List<Menu> getByStaffId(int id);

    Menu getById(int id);
}
