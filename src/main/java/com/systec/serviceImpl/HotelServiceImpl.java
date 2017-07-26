package com.systec.serviceImpl;

import com.systec.domain.Hotel;
import com.systec.mapper.HotelMapper;
import com.systec.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by wh on 7/20/2017.
 */
@Service("userService")
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelMapper mapper;

    @Override
    public void insert(Hotel record) {
        mapper.insert(record);
    }

    @Override
    public void deleteById(String id) {
        mapper.deleteByPrimaryKey(id);
    }

    @Override
    public Hotel selectById(String id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateSelective(Hotel record) {
        mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public void update(Hotel record) {
        mapper.updateByPrimaryKey(record);
    }
}
