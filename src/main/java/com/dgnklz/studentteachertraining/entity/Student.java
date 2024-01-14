package com.dgnklz.studentteachertraining.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "students")
public class Student extends User {
    @Column(name = "about")
    private String about;
}
