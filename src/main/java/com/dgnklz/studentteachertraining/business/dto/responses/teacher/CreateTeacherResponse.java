package com.dgnklz.studentteachertraining.business.dto.responses.teacher;

import com.dgnklz.studentteachertraining.business.dto.responses.user.CreateUserResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateTeacherResponse extends CreateUserResponse {
    private String branch;
    private String email;
    private String password;
}
