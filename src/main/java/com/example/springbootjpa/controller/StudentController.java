package com.example.springbootjpa.controller;

import com.example.springbootjpa.service.StudentService;
import com.example.springbootjpa.entity.Student;
import com.example.springbootjpa.util.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Jmy
 * @date 2019/5/28 23:22
 * @email jiaomingyu5778@gmail.com
 */

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    /**
     *
     * @param student
     * @return
     */
    @PostMapping(value = "/addStudent")
    public CommonResult result(Student student){
        CommonResult result = new CommonResult();
        try {
            studentService.addStudent(student);
            return result;
        }catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("失败");
            return result;
        }
    }


    /**
     * 修改一个学生(jpa是根据id来修改的)
     */
    @PutMapping(value = "/updateStudent")
    public CommonResult updateStudentById(Student student) {
        CommonResult result = new CommonResult();
        try {
            studentService.updateStudent(student);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("失败");
            return result;
        }
    }

    /**
     * 根据id删除一条数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/deleteStudent/{id}")
    public CommonResult deleteStudentById(@PathVariable(name = "id", required = true) Long id) {
        CommonResult result = new CommonResult();
        try {
            studentService.delStudentById(id);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("失败");
            return result;
        }
    }

    /**
     *    查询所有
     */
    @GetMapping(value = "/findAll")
    public CommonResult findAll() {
        CommonResult result = new CommonResult();
        try {
            List<Student> list = studentService.findAll();
            //将查询结果封装到CommonResult中
            result.setData(list);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("失败");
            return result;
        }
    }

    /**
     *     根据id查询一条数据(2.0后不能使用findOne了)
     */
    @GetMapping(value = "/findStudentById/{id}")
    public CommonResult findStudentById(@PathVariable(name = "id") Long id) {
        CommonResult result = new CommonResult();
        try {
            Student student = studentService.findStudentById(id);
            //将查询结果封装到CommonResult中
            result.setData(student);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("失败");
            return result;
        }
    }

    /**
     *      根据学生姓名查询多条数据
     */
    @GetMapping(value = "/findStudentByName")
    public CommonResult findStudentByName(String name) {
        CommonResult result = new CommonResult();
        try {
            List<Student> studentList = studentService.findStudentByName(name);
            //将查询结果封装到CommonResult中
            result.setData(studentList);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("失败");
            return result;
        }
    }

    @GetMapping(value = "/findStudentByNameLike")
    public CommonResult findStudentByNameLike(String name) {
        CommonResult result = new CommonResult();
        try {
            List<Student> studentList = studentService.findStudentByNameLike(name);
            result.setData(studentList);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("失败");
            return result;
        }
    }

}
