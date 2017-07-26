package com.systec.redisDao;

import com.systec.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by wh on 7/13/2017.
 */
@Repository
public class PersonDao {

    @Autowired
    RedisTemplate<Object, Object> redisTemplate;

    @Resource(name = "redisTemplate")
    ValueOperations<Object, Object> valueOperations;

    public void save(Person person){
        valueOperations.set(person.getId(), person);
    }

    public Person getPerson(String id){
        return (Person)valueOperations.get(id);
    }

}
