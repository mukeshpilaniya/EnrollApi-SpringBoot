package com.pilaniya.enrollapi.service;

import com.pilaniya.enrollapi.model.CourseStudent;
import com.pilaniya.enrollapi.repository.CourseStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseStudentServiceImpl implements CourseStudentService {
    @Autowired
    private CourseStudentRepository courseStudentRepository;
    @Override
    public CourseStudent saveCourseStudent(CourseStudent courseStudent){
        return courseStudentRepository.save(courseStudent);
    }
    @Override
    public List<CourseStudent> findAllCourseOfStudent(Long studentId){
        return courseStudentRepository.findByStudentId(studentId);
    }
    @Override
    public List<CourseStudent> findAllStudentsOfInstructor(Long instructorId){
        return courseStudentRepository.findByCourseInstructorId(instructorId);
    }
        @Override
    public List<CourseStudent> findAllEnrollments(){
        return courseStudentRepository.findAll();
    }
}













