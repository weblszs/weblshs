package com.Qiu.service.impl;

import com.Qiu.dao.CourseDao;
import com.Qiu.domain.Course;
import com.Qiu.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseDao courseDao;

    public boolean save(Course course) {
        return courseDao.save(course) > 0;
    }

    public boolean update(Course course) {
        return courseDao.update(course) > 0;
    }

    public boolean delete(Integer id) {
        return courseDao.delete(id) > 0;
    }

    public Course getById(Integer id) {
        return courseDao.getById(id);
    }

    public List<Course> getAll() {
        return courseDao.getAll();
    }
}
