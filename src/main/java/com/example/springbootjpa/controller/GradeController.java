package com.example.springbootjpa.controller;

import com.example.springbootjpa.service.GradeService;
import com.example.springbootjpa.entity.Grade;
import com.example.springbootjpa.util.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Jmy
 * @date 2019/5/29 22:04
 * @email jiaomingyu5778@gmail.com
 */
@RestController
public class GradeController {

    @Autowired
    private GradeService gradeService;
    
    @PostMapping(value = "/saveGrade")
    public CommonResult result(Grade grade) {
        CommonResult result = new CommonResult();
        try {
            gradeService.saveGrade(grade);
            return result;
        }catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("失败");
            return result;
        }
    }


}
