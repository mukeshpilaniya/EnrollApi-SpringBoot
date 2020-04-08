package com.pilaniya.enrollapi.controller;

import com.pilaniya.enrollapi.model.Course;
import com.pilaniya.enrollapi.model.CourseStudent;
import com.pilaniya.enrollapi.service.CourseService;
import com.pilaniya.enrollapi.service.CourseStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class StudentController {
    @Autowired
    private CourseStudentService courseStudentService;
    @Autowired
    private CourseService courseService;

    @GetMapping(value = "/student/courses/{studentId}")
    public ResponseEntity<?> findAllCoursesOfStudent(@PathVariable Long studentId){
        List<Course> courseList=courseStudentService.findAllCourseOfStudent(studentId).stream().map(cs->cs.getCourse()).collect(Collectors.toList());
        return new ResponseEntity<>(courseList, HttpStatus.OK);
    }

    @PostMapping(value = "/student/enroll")
    public ResponseEntity<?> enroll(@RequestBody CourseStudent courseStudent){
        return  new ResponseEntity<>(courseStudentService.saveCourseStudent(courseStudent),HttpStatus.CREATED);
    }

    @GetMapping(value = "/student/courselist")
    public ResponseEntity<?> courseList(){
        return new ResponseEntity<>(courseService.findAllCourses(),HttpStatus.OK);
    }
}
