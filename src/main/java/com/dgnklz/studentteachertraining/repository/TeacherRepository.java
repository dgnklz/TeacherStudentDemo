package com.dgnklz.studentteachertraining.repository;

import com.dgnklz.studentteachertraining.entity.Teacher;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer>{
    boolean existsTeacherByNationalIdentity(String nationalIdentity);

    @Modifying
    @Query(value = "update Teachers set password = :newPassword where id = :id", nativeQuery = true)
    @Transactional
    void changePassword(String newPassword, int id);
}
