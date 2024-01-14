package com.dgnklz.studentteachertraining.business.dto.responses.teacher;

import com.dgnklz.studentteachertraining.business.dto.responses.user.GetAllUsersResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetAllTeachersResponse extends GetAllUsersResponse {
    private String branch;
    private String email;
    private String password;
}
