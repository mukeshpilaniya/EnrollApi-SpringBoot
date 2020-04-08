package com.pilaniya.enrollapi.controller;

import com.pilaniya.enrollapi.model.CourseStudent;
import com.pilaniya.enrollapi.model.Role;
import com.pilaniya.enrollapi.model.User;
import com.pilaniya.enrollapi.service.CourseService;
import com.pilaniya.enrollapi.service.CourseStudentService;
import com.pilaniya.enrollapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
public class UserController {
    @Autowired
    private UserService  userService;
    @Autowired
    private CourseStudentService courseStudentService;
    @Autowired
    private CourseService courseService;

    @PostMapping(value = "/user/registration")
    public ResponseEntity<?> register(@RequestBody User user){
        if(userService.findByUsername(user.getUsername())!=null){
            return new ResponseEntity<>("Username already exits!",HttpStatus.CONFLICT);
        }
        user.setRole(Role.STUDENT);
        return  new ResponseEntity<>(userService.saveUser(user),HttpStatus.CREATED);
    }

    @GetMapping(value = "/user/login")
    public  ResponseEntity<?> getUser(Principal principal){
        if(principal==null){
            //this should be true because here may be logout path.
            return  ResponseEntity.ok(principal);
        }
        return new ResponseEntity<>(userService.findByUsername(principal.getName()),HttpStatus.OK);
    }

    @PostMapping(value = "/user/enroll")
    public ResponseEntity<?> enrollCourse(@RequestBody CourseStudent courseStudent){
        return new ResponseEntity<>(courseStudentService.saveCourseStudent(courseStudent),HttpStatus.CREATED);
    }

    @GetMapping(value = "/user/courses")
    public ResponseEntity<?> getAllCourses(){
        return ResponseEntity.ok(courseService.findAllCourses());
    }
}
