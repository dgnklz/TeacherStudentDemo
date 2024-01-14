package com.dgnklz.studentteachertraining.business.conceretes;

import com.dgnklz.studentteachertraining.business.abstracts.TeacherService;
import com.dgnklz.studentteachertraining.business.constants.Messages;
import com.dgnklz.studentteachertraining.business.constants.ValidationMessages;
import com.dgnklz.studentteachertraining.business.dto.requests.teacher.ChangeTeacherPasswordRequest;
import com.dgnklz.studentteachertraining.business.dto.requests.teacher.CreateTeacherRequest;
import com.dgnklz.studentteachertraining.business.dto.requests.teacher.UpdateTeacherRequest;
import com.dgnklz.studentteachertraining.business.dto.responses.teacher.CreateTeacherResponse;
import com.dgnklz.studentteachertraining.business.dto.responses.teacher.GetAllTeachersResponse;
import com.dgnklz.studentteachertraining.business.dto.responses.teacher.GetTeacherResponse;
import com.dgnklz.studentteachertraining.business.dto.responses.teacher.UpdateTeacherResponse;
import com.dgnklz.studentteachertraining.core.exception.BusinessException;
import com.dgnklz.studentteachertraining.core.mapping.ModelMapperService;
import com.dgnklz.studentteachertraining.core.result.DataResult;
import com.dgnklz.studentteachertraining.core.result.Result;
import com.dgnklz.studentteachertraining.core.result.SuccessDataResult;
import com.dgnklz.studentteachertraining.core.result.SuccessResult;
import com.dgnklz.studentteachertraining.entity.Teacher;
import com.dgnklz.studentteachertraining.repository.StudentRepository;
import com.dgnklz.studentteachertraining.repository.TeacherRepository;
import jakarta.validation.ValidationException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class TeacherManager implements TeacherService {

    private TeacherRepository repository;
    private ModelMapperService mapper;

    @Override
    public DataResult<List<GetAllTeachersResponse>> getAll() {
        List<Teacher> teachers = repository.findAll();
        List<GetAllTeachersResponse> data = teachers
                .stream()
                .map(teacher -> mapper.forResponse().map(teacher, GetAllTeachersResponse.class))
                .toList();

        return new SuccessDataResult<>(data, Messages.Teacher.ListAll);
    }

    @Override
    public DataResult<GetTeacherResponse> getById(int id) {
        checkIfTeacherExistById(id);
        Teacher teacher = repository.findById(id).orElse(null);
        GetTeacherResponse data = mapper.forResponse().map(teacher, GetTeacherResponse.class);

        return new SuccessDataResult<>(data, Messages.Teacher.ListById);
    }

    @Override
    public DataResult<CreateTeacherResponse> add(CreateTeacherRequest request) {
        comparePassword(request.getPassword(), request.getConfirmPassword());
        checkIfTeacherExistByNationalIdentity(request.getNationalIdentity());
        Teacher teacher = mapper.forRequest().map(request, Teacher.class);
        repository.save(teacher);
        CreateTeacherResponse data = mapper.forResponse().map(teacher, CreateTeacherResponse.class);

        return new SuccessDataResult<>(data, Messages.Teacher.Created);
    }

    @Override
    public DataResult<UpdateTeacherResponse> update(UpdateTeacherRequest request, int id) {
        checkIfTeacherExistById(id);
        comparePassword(request.getPassword(), request.getConfirmPassword());
        checkIfTeacherExistByNationalIdentity(request.getNationalIdentity());
        Teacher teacher = mapper.forRequest().map(request, Teacher.class);
        teacher.setId(id);
        repository.save(teacher);
        UpdateTeacherResponse data = mapper.forResponse().map(teacher, UpdateTeacherResponse.class);

        return new SuccessDataResult<>(data, Messages.Teacher.Updated);
    }

    @Override
    public Result changePassword(ChangeTeacherPasswordRequest request, int id) {
        checkIfTeacherExistById(id);
        checkPasswordIsCorrect(request.getOldPassword(), id);
        checkPasswordIsNew(request.getOldPassword(), request.getNewPassword());
        comparePassword(request.getNewPassword(), request.getConfirmPassword());
        repository.changePassword(request.getNewPassword(), id);

        return new SuccessResult(Messages.Teacher.PasswordChanged);
    }

    @Override
    public Result delete(int id) {
        checkIfTeacherExistById(id);
        repository.deleteById(id);

        return new SuccessResult(Messages.Teacher.Deleted);
    }

    /// Domain Rules \\\

    private void checkIfTeacherExistById(int id) {
        if (!repository.existsById(id)) {
            throw new BusinessException(Messages.Teacher.TeacherNotExists);
        }
    }

    private void checkIfTeacherExistByNationalIdentity(String nationalIdentity) {
        if (repository.existsTeacherByNationalIdentity(nationalIdentity)) {
            throw new BusinessException(Messages.Teacher.TeacherExists);
        }
    }

    private void comparePassword(String password, String confirmPassword) {
        if (!password.equals(confirmPassword)) {
            throw new ValidationException(ValidationMessages.Teacher.ConfirmPasswordValid);
        }
    }

    private void checkPasswordIsNew(String oldPassword, String newPassword) {
        if (oldPassword.equals(newPassword)) {
            throw new ValidationException(ValidationMessages.Teacher.ThereIsNoChangeInPassword);
        }
    }

    private void checkPasswordIsCorrect(String oldPassword, int id) {
        if (!repository.findById(id).get().getPassword().equals(oldPassword)) {
            throw new ValidationException(ValidationMessages.Teacher.OldPasswordNotMatch);
        }
    }
}
