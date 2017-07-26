package com.systec.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by wh on 7/13/2017.
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Person implements Serializable{

    private static final long serialVersionUID = 1L;

    private String id;

    private String name;

    private Integer age;

}
