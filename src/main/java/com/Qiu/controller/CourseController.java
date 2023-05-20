package com.Qiu.controller;


import com.Qiu.domain.Course;
import com.Qiu.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping
    public Result save(@RequestBody Course course) {
        boolean flag = courseService.save(course);
        return new Result(flag ? Code.SAVE_OK:Code.SAVE_ERR,flag);
    }

    @PutMapping
    public Result update(@RequestBody Course course) {
        boolean flag = courseService.update(course);
        return new Result(flag ? Code.UPDATE_OK:Code.UPDATE_ERR,flag);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        boolean flag = courseService.delete(id);
        return new Result(flag ? Code.DELETE_OK:Code.DELETE_ERR,flag);
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        Course course = courseService.getById(id);
        Integer code = course != null ? Code.GET_OK : Code.GET_ERR;
        String msg = course != null ? "" : "数据查询失败，请重试！";
        return new Result(code,course,msg);
    }

    @GetMapping
    public Result getAll() {
        List<Course> courseList = courseService.getAll();
        Integer code = courseList != null ? Code.GET_OK : Code.GET_ERR;
        String msg = courseList != null ? "" : "数据查询失败，请重试！";
        return new Result(code,courseList,msg);
    }
}
