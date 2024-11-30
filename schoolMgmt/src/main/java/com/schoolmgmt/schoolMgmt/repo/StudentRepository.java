package com.schoolmgmt.schoolMgmt.repo;

import com.schoolmgmt.schoolMgmt.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
}
