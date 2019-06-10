package com.example.springbootjpa.dao;

import com.example.springbootjpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author Jmy
 * @date 2019/5/28 23:02
 * @email jiaomingyu5778@gmail.com
 */
public interface StudentDao extends JpaRepository<Student,Long> {

    /**
     *     根据name查询学生
      */
    public List<Student> findByName(String name);

    /**
     *
     * @param name
     * @return
     */
    public List<Student> findByNameLike(@Param("name") String name);
}
