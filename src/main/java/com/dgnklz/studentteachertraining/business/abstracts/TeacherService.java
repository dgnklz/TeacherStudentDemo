package com.dgnklz.studentteachertraining.business.abstracts;

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

import java.util.List;

public interface TeacherService {
    DataResult<List<GetAllTeachersResponse>> getAll();
    DataResult<GetTeacherResponse> getById(int id);
    DataResult<CreateTeacherResponse> add(CreateTeacherRequest request);
    DataResult<UpdateTeacherResponse> update(UpdateTeacherRequest request, int id);
    Result changePassword(ChangeTeacherPasswordRequest request, int id);
    Result delete(int id);
}
