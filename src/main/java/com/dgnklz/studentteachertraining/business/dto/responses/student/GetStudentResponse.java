package com.dgnklz.studentteachertraining.business.dto.responses.student;

import com.dgnklz.studentteachertraining.business.dto.responses.user.GetUserResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetStudentResponse extends GetUserResponse {
    private String about;
}
