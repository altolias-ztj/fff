package com.woniuxy.canteen.service.impl;

import com.woniuxy.canteen.entity.Menu;
import com.woniuxy.canteen.mapper.MenuMapper;
import com.woniuxy.canteen.service.MenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Resource
    private MenuMapper menuMapper;

    @Override
    public List<Menu> getByStaffId(int id) {
        return menuMapper.getByStaffId(id);
    }

    @Override
    public Menu getById(int id) {
        return menuMapper.getById(id);
    }
}
