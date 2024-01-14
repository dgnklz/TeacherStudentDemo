package com.dgnklz.studentteachertraining.business.dto.requests.teacher;

import com.dgnklz.studentteachertraining.business.constants.Regexes;
import com.dgnklz.studentteachertraining.business.constants.ValidationMessages;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChangeTeacherPasswordRequest {
    @Length(message = ValidationMessages.Teacher.OldPasswordBlank)
    private String oldPassword;
    @NotBlank(message = ValidationMessages.Teacher.PasswordBlank)
    @Pattern(regexp = Regexes.Password, message = ValidationMessages.Teacher.PasswordValid)
    private String newPassword;
    @NotBlank(message = ValidationMessages.Teacher.ConfirmPasswordBlank)
    private String confirmPassword;
}
