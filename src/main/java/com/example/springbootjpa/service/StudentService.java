package com.example.springbootjpa.service;

import com.example.springbootjpa.dao.StudentDao;
import com.example.springbootjpa.entity.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author Jmy
 * @date 2019/5/28 23:04
 * @email jiaomingyu5778@gmail.com
 */
@Service
@Transactional(rollbackOn = Exception.class)
public class StudentService {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StudentDao studentDao;

    /**
     *  保存一个学生对象
     * @param student
     */
    public void addStudent(Student student){
        System.out.println("只有第一次才会打印sql语句");
        studentDao.save(student);
    }

    /**
     * 根据ID删除一个学生
     * @param id
     */
    public void delStudentById(Long id) {
        studentDao.deleteById(id);
    }

    /**
     * 保存学生信息
     * @param student
     */
    public void updateStudent(Student student){
        studentDao.save(student);
    }

    /**
     * 查询所有
     * @return
     */
    public List<Student> findAll(){
        return studentDao.findAll();
    }

    /**
     * 根据ID查询一个学生
     * @param id
     * @return
     */
    public Student findStudentById(Long id){
        Student student = (Student) redisTemplate.opsForValue().get(id);
        if (student == null) {
            logger.info("reids 中没有该数据！");
            student = studentDao.findById(id).get();
            redisTemplate.opsForValue().set(id,student);
        } else {
            logger.info("reids 中已经含有该数据了！");
        }
        return student;
    }

    /**
     * 根据姓名查询多个记录
     * @param name
     * @return
     */
    public List<Student> findStudentByName(String name){
        return studentDao.findByName(name);
    }

    /**
     *
     * @param name
     * @return
     */
    public List<Student> findStudentByNameLike(String name) {
        return studentDao.findByNameLike(name);
    }
}
