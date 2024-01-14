package com.dgnklz.studentteachertraining.business.dto.responses.teacher;

import com.dgnklz.studentteachertraining.business.dto.responses.user.UpdateUserResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateTeacherResponse extends UpdateUserResponse {
    private String branch;
    private String email;
    private String password;
}
