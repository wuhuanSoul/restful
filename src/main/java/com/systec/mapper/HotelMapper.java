package com.systec.mapper;

import com.systec.domain.Hotel;
import org.apache.ibatis.annotations.Mapper;

public interface HotelMapper {

    int deleteByPrimaryKey(String id);

    int insert(Hotel record);

    int insertSelective(Hotel record);

    Hotel selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Hotel record);

    int updateByPrimaryKey(Hotel record);
}