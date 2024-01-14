package com.dgnklz.studentteachertraining.business.conceretes;

import com.dgnklz.studentteachertraining.business.abstracts.StudentService;
import com.dgnklz.studentteachertraining.business.constants.Messages;
import com.dgnklz.studentteachertraining.business.dto.requests.student.CreateStudentRequest;
import com.dgnklz.studentteachertraining.business.dto.requests.student.UpdateStudentRequest;
import com.dgnklz.studentteachertraining.business.dto.responses.student.CreateStudentResponse;
import com.dgnklz.studentteachertraining.business.dto.responses.student.GetAllStudentsResponse;
import com.dgnklz.studentteachertraining.business.dto.responses.student.GetStudentResponse;
import com.dgnklz.studentteachertraining.business.dto.responses.student.UpdateStudentResponse;
import com.dgnklz.studentteachertraining.core.exception.BusinessException;
import com.dgnklz.studentteachertraining.core.mapping.ModelMapperService;
import com.dgnklz.studentteachertraining.core.result.DataResult;
import com.dgnklz.studentteachertraining.core.result.Result;
import com.dgnklz.studentteachertraining.core.result.SuccessDataResult;
import com.dgnklz.studentteachertraining.core.result.SuccessResult;
import com.dgnklz.studentteachertraining.entity.Student;
import com.dgnklz.studentteachertraining.repository.StudentRepository;
import jakarta.validation.ValidationException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@AllArgsConstructor
@Service
public class StudentManager implements StudentService {

    private StudentRepository repository;
    private ModelMapperService mapper;

    @Override
    public DataResult<List<GetAllStudentsResponse>> getAll() {
        List<Student> students = repository.findAll();
        List<GetAllStudentsResponse> data = students
                .stream()
                .map(student -> mapper.forResponse().map(student, GetAllStudentsResponse.class))
                .toList();

        return new SuccessDataResult<>(data, Messages.Student.ListAll);
    }

    @Override
    public DataResult<GetStudentResponse> getById(int id) {
        checkIfStudentExistById(id);
        Student student = repository.findById(id).orElse(null);
        GetStudentResponse data = mapper.forResponse().map(student, GetStudentResponse.class);

        return new SuccessDataResult<>(data, Messages.Student.ListById);
    }

    @Override
    public DataResult<CreateStudentResponse> add(CreateStudentRequest request) {
        checkIfStudentExistByNationalIdentity(request.getNationalIdentity());
        Student student = mapper.forRequest().map(request, Student.class);
        repository.save(student);
        CreateStudentResponse data = mapper.forResponse().map(student, CreateStudentResponse.class);

        return new SuccessDataResult<>(data, Messages.Student.Created);
    }

    @Override
    public DataResult<UpdateStudentResponse> update(UpdateStudentRequest request, int id) {
        checkIfStudentExistById(id);
        checkIfStudentExistByNationalIdentity(request.getNationalIdentity());
        Student student = mapper.forRequest().map(request, Student.class);
        student.setId(id);
        repository.save(student);
        UpdateStudentResponse data = mapper.forResponse().map(student, UpdateStudentResponse.class);

        return new SuccessDataResult<>(data, Messages.Student.Updated);
    }

    @Override
    public Result delete(int id) {
        checkIfStudentExistById(id);
        repository.deleteById(id);

        return new SuccessResult(Messages.Student.Deleted);
    }

    /// Domain Rules \\\

    private void checkIfStudentExistById(int id) {
        if (!repository.existsById(id)) {
            throw new BusinessException(Messages.Student.StudentNotExists);
        }
    }

    private void checkIfStudentExistByNationalIdentity(String nationalIdentity) {
        if (repository.existsStudentByNationalIdentity(nationalIdentity)) {
            throw new BusinessException(Messages.Student.StudentExists);
        }
    }

}
