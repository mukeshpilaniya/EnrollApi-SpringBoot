package com.pilaniya.enrollapi.service;

import com.pilaniya.enrollapi.model.Course;
import com.pilaniya.enrollapi.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;
    @Override
    public Course addCourse(Course course){
        return courseRepository.save(course);
    }
    @Override
    public Course updateCourse(Course course){
        return courseRepository.save(course);
    }
    @Override
    public  void  deleteCourse(Long courseId){
        courseRepository.deleteById(courseId);
    }
    @Override
    public List<Course> findAllCourses(){
        return courseRepository.findAll();
    }
}
























