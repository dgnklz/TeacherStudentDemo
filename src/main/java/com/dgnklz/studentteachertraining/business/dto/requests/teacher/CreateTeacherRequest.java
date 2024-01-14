package com.dgnklz.studentteachertraining.business.dto.requests.teacher;

import com.dgnklz.studentteachertraining.business.constants.Regexes;
import com.dgnklz.studentteachertraining.business.constants.ValidationMessages;
import com.dgnklz.studentteachertraining.business.dto.requests.user.CreateUserRequest;
import jakarta.validation.constraints.Email;
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
public class CreateTeacherRequest extends CreateUserRequest {
    @NotBlank(message = ValidationMessages.Teacher.BranchBlank)
    @Length(min = 2, max = 50, message = ValidationMessages.Teacher.BranchLength)
    private String branch;

    @NotBlank(message = ValidationMessages.Teacher.EmailBlank)
    @Email(regexp = Regexes.Email, message = ValidationMessages.Teacher.EmailValid)
    private String email;

    @NotBlank(message = ValidationMessages.Teacher.PasswordBlank)
    @Pattern(regexp = Regexes.Password, message = ValidationMessages.Teacher.PasswordValid)
    private String password;

    @NotBlank(message = ValidationMessages.Teacher.ConfirmPasswordBlank)
    private String confirmPassword;
}
