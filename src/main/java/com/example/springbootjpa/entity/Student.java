package com.example.springbootjpa.entity;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author Jmy
 * @date 2019/5/28 21:52
 * @email jiaomingyu5778@gmail.com
 */
@Data
@Entity(name = "t_student")
public class Student implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id",length = 35)
    private Long id;

    @Column(name = "name", length = 20)
    private String name;

    @Column(name = "sex", length = 2)
    private String sex;

    @Column(name = "age", length = 3)
    private Integer age;

}
