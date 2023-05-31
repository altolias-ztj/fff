package com.woniuxy.canteen.mapper;

import org.apache.ibatis.annotations.Param;

public interface CollectMapper {
    void add(@Param("cId")int cId, @Param("fId")int fId);
    void delete(@Param("cId")int cId, @Param("fId")int fId);
}
