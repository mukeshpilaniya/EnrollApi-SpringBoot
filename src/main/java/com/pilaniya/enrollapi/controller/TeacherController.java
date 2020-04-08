package com.pilaniya.enrollapi.controller;

import com.pilaniya.enrollapi.model.Course;
import com.pilaniya.enrollapi.model.CourseStudent;
import com.pilaniya.enrollapi.model.User;
import com.pilaniya.enrollapi.service.CourseStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class TeacherController {
    @Autowired
    private CourseStudentService courseStudentService;

    @GetMapping(value = "/teacher/students/{teacherId}")
    public ResponseEntity<?> findAllStudentsOfInstructor(@PathVariable Long teacherId){
        List<User> studentList=courseStudentService.findAllStudentsOfInstructor(teacherId).stream().map(p->p.getStudent()).collect(Collectors.toList());
        return  new ResponseEntity<>(studentList, HttpStatus.OK);

    }
    @GetMapping(value = "/teacher/courses/{teacherId}")
    public ResponseEntity<?> findAllCoursesOfInstructor(@PathVariable Long teacherId){
        List<Course> courseList=courseStudentService.findAllStudentsOfInstructor(teacherId).stream().map(p->p.getCourse()).collect(Collectors.toList());
        return new ResponseEntity<>(courseList,HttpStatus.OK);
    }
}
