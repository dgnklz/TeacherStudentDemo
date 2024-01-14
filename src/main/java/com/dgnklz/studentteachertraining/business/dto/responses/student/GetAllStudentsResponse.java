package com.dgnklz.studentteachertraining.business.dto.responses.student;

import com.dgnklz.studentteachertraining.business.dto.responses.user.GetAllUsersResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetAllStudentsResponse extends GetAllUsersResponse {
    private String about;
}
