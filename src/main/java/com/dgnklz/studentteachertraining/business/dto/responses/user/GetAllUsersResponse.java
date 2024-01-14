package com.dgnklz.studentteachertraining.business.dto.responses.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetAllUsersResponse {
    private int id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String nationalIdentity;
}
