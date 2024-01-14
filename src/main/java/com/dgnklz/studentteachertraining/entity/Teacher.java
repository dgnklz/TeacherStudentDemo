package com.dgnklz.studentteachertraining.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "teachers")
public class Teacher extends User{
    @Column(name = "branch")
    private String branch;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;
}