package com.systec.control;

import com.systec.redisDao.PersonDao;
import com.systec.domain.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by wh on 7/13/2017.
 */

@RestController
@RequestMapping(value = "/person")
public class ObjectRedisController {

    protected static Logger logger = LoggerFactory.getLogger(ObjectRedisController.class);

    @Autowired
    private PersonDao personDao;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void savaPerson(@ModelAttribute Person person){
        personDao.save(person);
    }

    @RequestMapping(value = "/getPerson/{id}", method = RequestMethod.GET)
    public Person getPerson(@PathVariable String id){
        return personDao.getPerson(id);
    }

}
