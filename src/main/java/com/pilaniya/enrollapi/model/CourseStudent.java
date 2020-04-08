package com.pilaniya.enrollapi.model;

import lombok.Data;
import org.springframework.data.repository.cdi.Eager;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "course_student")
public class CourseStudent implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "student_id",referencedColumnName = "id")
    private User student;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "course_id",referencedColumnName = "id")
    private Course course;

}
