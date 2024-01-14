package com.dgnklz.studentteachertraining.business.abstracts;

import com.dgnklz.studentteachertraining.business.dto.requests.student.CreateStudentRequest;
import com.dgnklz.studentteachertraining.business.dto.requests.student.UpdateStudentRequest;
import com.dgnklz.studentteachertraining.business.dto.responses.student.CreateStudentResponse;
import com.dgnklz.studentteachertraining.business.dto.responses.student.GetAllStudentsResponse;
import com.dgnklz.studentteachertraining.business.dto.responses.student.GetStudentResponse;
import com.dgnklz.studentteachertraining.business.dto.responses.student.UpdateStudentResponse;
import com.dgnklz.studentteachertraining.core.result.DataResult;
import com.dgnklz.studentteachertraining.core.result.Result;

import java.util.List;

public interface StudentService {
    DataResult<List<GetAllStudentsResponse>> getAll();
    DataResult<GetStudentResponse> getById(int id);
    DataResult<CreateStudentResponse> add(CreateStudentRequest request);
    DataResult<UpdateStudentResponse> update(UpdateStudentRequest request, int id);
    Result delete(int id);
}
