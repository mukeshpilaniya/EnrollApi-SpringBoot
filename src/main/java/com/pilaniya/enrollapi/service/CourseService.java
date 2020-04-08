package com.pilaniya.enrollapi.service;

import com.pilaniya.enrollapi.model.Course;

import java.util.List;

public interface CourseService {
    Course addCourse(Course course);

    Course updateCourse(Course course);

    void  deleteCourse(Long courseId);

    List<Course> findAllCourses();
}
