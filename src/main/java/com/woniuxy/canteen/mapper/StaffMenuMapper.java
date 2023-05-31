package com.woniuxy.canteen.mapper;

import org.apache.ibatis.annotations.Param;

public interface StaffMenuMapper {
    void add(@Param("sId")int sId,@Param("mId")int mId);
    void delete(@Param("sId")int sId,@Param("mId")int mId);
}
