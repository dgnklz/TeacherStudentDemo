package com.dgnklz.studentteachertraining.api;

import com.dgnklz.studentteachertraining.business.abstracts.StudentService;
import com.dgnklz.studentteachertraining.business.abstracts.TeacherService;
import com.dgnklz.studentteachertraining.business.constants.Paths;
import com.dgnklz.studentteachertraining.business.dto.requests.student.CreateStudentRequest;
import com.dgnklz.studentteachertraining.business.dto.requests.student.UpdateStudentRequest;
import com.dgnklz.studentteachertraining.business.dto.requests.teacher.ChangeTeacherPasswordRequest;
import com.dgnklz.studentteachertraining.business.dto.requests.teacher.CreateTeacherRequest;
import com.dgnklz.studentteachertraining.business.dto.requests.teacher.UpdateTeacherRequest;
import com.dgnklz.studentteachertraining.business.dto.responses.student.CreateStudentResponse;
import com.dgnklz.studentteachertraining.business.dto.responses.student.GetAllStudentsResponse;
import com.dgnklz.studentteachertraining.business.dto.responses.student.GetStudentResponse;
import com.dgnklz.studentteachertraining.business.dto.responses.student.UpdateStudentResponse;
import com.dgnklz.studentteachertraining.business.dto.responses.teacher.CreateTeacherResponse;
import com.dgnklz.studentteachertraining.business.dto.responses.teacher.GetAllTeachersResponse;
import com.dgnklz.studentteachertraining.business.dto.responses.teacher.GetTeacherResponse;
import com.dgnklz.studentteachertraining.business.dto.responses.teacher.UpdateTeacherResponse;
import com.dgnklz.studentteachertraining.core.result.DataResult;
import com.dgnklz.studentteachertraining.core.result.Result;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(Paths.api + "students")
public class StudentController {
    private StudentService service;

    @GetMapping
    DataResult<List<GetAllStudentsResponse>> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    DataResult<GetStudentResponse> getById(@PathVariable int id) {
        return service.getById(id);
    }

    @PostMapping
    @Valid
    @ResponseStatus(HttpStatus.CREATED)
    DataResult<CreateStudentResponse> add(@Valid @RequestBody CreateStudentRequest request) {
        return service.add(request);
    }

    @PutMapping("/{id}")
    DataResult<UpdateStudentResponse> update(@Valid @RequestBody UpdateStudentRequest request, @PathVariable int id) {
        return service.update(request, id);
    }

    @DeleteMapping("/{id}")
    Result delete(@PathVariable int id) {
        return service.delete(id);
    }
}
