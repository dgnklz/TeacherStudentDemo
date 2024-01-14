package com.dgnklz.studentteachertraining.repository;

import com.dgnklz.studentteachertraining.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    boolean existsStudentByNationalIdentity(String nationalIdentity);
}
