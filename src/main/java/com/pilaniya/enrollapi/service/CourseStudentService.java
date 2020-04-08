package com.pilaniya.enrollapi.service;

import com.pilaniya.enrollapi.model.CourseStudent;

import java.util.List;

public interface CourseStudentService  {
    CourseStudent saveCourseStudent(CourseStudent courseStudent);

    List<CourseStudent> findAllCourseOfStudent(Long studentId);

    List<CourseStudent> findAllStudentsOfInstructor(Long instructorId);

    List<CourseStudent> findAllEnrollments();
}
