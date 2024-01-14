package com.dgnklz.studentteachertraining.api;

import com.dgnklz.studentteachertraining.business.abstracts.TeacherService;
import com.dgnklz.studentteachertraining.business.constants.Paths;
import com.dgnklz.studentteachertraining.business.dto.requests.teacher.ChangeTeacherPasswordRequest;
import com.dgnklz.studentteachertraining.business.dto.requests.teacher.CreateTeacherRequest;
import com.dgnklz.studentteachertraining.business.dto.requests.teacher.UpdateTeacherRequest;
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
@RequestMapping(Paths.api + "teachers")
public class TeacherController {
    private TeacherService service;

    @GetMapping
    DataResult<List<GetAllTeachersResponse>> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    DataResult<GetTeacherResponse> getById(@PathVariable int id) {
        return service.getById(id);
    }

    @PostMapping
    @Valid
    @ResponseStatus(HttpStatus.CREATED)
    DataResult<CreateTeacherResponse> add(@Valid @RequestBody CreateTeacherRequest request) {
        return service.add(request);
    }

    @PutMapping("/{id}")
    DataResult<UpdateTeacherResponse> update(@Valid @RequestBody UpdateTeacherRequest request, @PathVariable int id) {
        return service.update(request, id);
    }

    @PutMapping("/changePassword/{id}")
    Result changePassword(@RequestBody ChangeTeacherPasswordRequest request, @PathVariable int id) {
        return service.changePassword(request, id);
    }

    @DeleteMapping("/{id}")
    Result delete(@PathVariable int id) {
        return service.delete(id);
    }
}
