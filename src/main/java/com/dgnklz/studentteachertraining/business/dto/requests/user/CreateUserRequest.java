package com.dgnklz.studentteachertraining.business.dto.requests.user;

import com.dgnklz.studentteachertraining.business.constants.ValidationMessages;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserRequest {
    @NotBlank(message = ValidationMessages.User.FirstNameBlank)
    @Length(min = 2, max = 50, message = ValidationMessages.User.FirstNameLength)
    private String firstName;

    @NotBlank(message = ValidationMessages.User.LastNameBlank)
    @Length(min = 2, max = 50, message = ValidationMessages.User.LastNameLength)
    private String lastName;

    @NotNull(message = ValidationMessages.User.DateOfBirthBlank)
    private LocalDate dateOfBirth;

    @NotBlank(message = ValidationMessages.User.NationalIdentityBlank)
    @Length(min = 11, max = 11, message = ValidationMessages.User.NationalIdentityLength)
    private String nationalIdentity;
}