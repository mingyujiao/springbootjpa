package com.example.springbootjpa.dao;

import com.example.springbootjpa.entity.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Jmy
 * @date 2019/5/29 21:54
 * @email jiaomingyu5778@gmail.com
 */
public interface GradeDao extends JpaRepository<Grade, Long> {
}
