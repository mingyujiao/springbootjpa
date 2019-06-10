package com.example.springbootjpa.service;

import com.example.springbootjpa.dao.GradeDao;
import com.example.springbootjpa.entity.Grade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author Jmy
 * @date 2019/5/29 21:55
 * @email jiaomingyu5778@gmail.com
 */
@Service
@Transactional(rollbackOn = Exception.class)
public class GradeService {

    @Autowired
    private GradeDao gradeDao;

    public void saveGrade(Grade grade){
        gradeDao.save(grade);
    }

    public void updateGrade(Grade grade) {
        gradeDao.save(grade);
    }

    public Grade findById (Long id) {
        return gradeDao.findById(id).get();
    }

    public List<Grade> findAll () {
        return gradeDao.findAll();
    }

    public void deleteGrade(Long id) {
        gradeDao.deleteById(id);
    }
}
