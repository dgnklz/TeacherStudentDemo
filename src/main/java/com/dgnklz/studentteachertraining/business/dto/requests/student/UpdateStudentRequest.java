package com.dgnklz.studentteachertraining.business.dto.requests.student;

import com.dgnklz.studentteachertraining.business.constants.ValidationMessages;
import com.dgnklz.studentteachertraining.business.dto.requests.user.UpdateUserRequest;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateStudentRequest extends UpdateUserRequest {
    @NotBlank(message = ValidationMessages.Student.AboutBlank)
    @Length(min = 5, max = 100, message = ValidationMessages.Student.AboutLength)
    private String about;
}
