package com.schoolmgmt.schoolMgmt.repo;

import com.schoolmgmt.schoolMgmt.entity.Student;
import com.schoolmgmt.schoolMgmt.entity.Teacher;
import com.schoolmgmt.schoolMgmt.entity.Users;
import com.schoolmgmt.schoolMgmt.repo.utility.StudentDto;
import com.schoolmgmt.schoolMgmt.repo.utility.TeacherDto;
import com.schoolmgmt.schoolMgmt.repo.utility.UserDto;
import lombok.Data;

@Data
public class UserDetailsDto {
    private TeacherDto teacherDto;
    private StudentDto studentDto;
    private UserDto userDto;
}
