package com.systec.service;

import com.systec.domain.Hotel;

/**
 * Created by wh on 7/20/2017.
 */
public interface HotelService {

    void insert(Hotel record);

    void deleteById(String id);

    Hotel selectById(String id);

    void updateSelective(Hotel record);

    void update(Hotel record);
}
