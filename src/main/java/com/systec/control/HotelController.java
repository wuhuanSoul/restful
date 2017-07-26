package com.systec.control;

import com.systec.domain.Hotel;
import com.systec.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by wh on 7/13/2017.
 */
@RestController
@RequestMapping("hotel")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void insert(@ModelAttribute("hotel") Hotel hotel) {
      hotelService.insert(hotel);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable String id){
        hotelService.deleteById(id);
    }

    @RequestMapping(value = "/updateSelective", method = RequestMethod.POST)
    public void updateSelective(@ModelAttribute("hotel") Hotel hotel){
        hotelService.updateSelective(hotel);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public void update(@ModelAttribute("hotel") Hotel hotel){
        hotelService.update(hotel);
    }

    @RequestMapping(value = "/select/{id}", method = RequestMethod.GET)
    public Hotel select(@PathVariable String id){
        return hotelService.selectById(id);
    }
}
