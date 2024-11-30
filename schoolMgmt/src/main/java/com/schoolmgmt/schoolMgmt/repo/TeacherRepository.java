package com.schoolmgmt.schoolMgmt.repo;

import com.schoolmgmt.schoolMgmt.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher,Long> {
}
