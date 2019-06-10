package com.example.springbootjpa.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author Jmy
 * @date 2019/5/29 21:39
 * @email jiaomingyu5778@gmail.com
 */
@Data
@Entity(name = "t_grade")
public class Grade {

    @Id
    @GeneratedValue
    @Column(name = "id" ,length = 35)
    private Long id;
    @Column(name = "mathematics" ,length = 4)
    private Integer mathematics;
    @Column(name = "english" ,length = 4)
    private Integer english;
    @Column(name = "student_id" ,length = 4)
    private Integer studentId;
}
