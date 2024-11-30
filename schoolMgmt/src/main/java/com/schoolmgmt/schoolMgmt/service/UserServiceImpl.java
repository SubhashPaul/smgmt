package com.schoolmgmt.schoolMgmt.service;

import com.schoolmgmt.schoolMgmt.entity.*;
import com.schoolmgmt.schoolMgmt.repo.*;
import com.schoolmgmt.schoolMgmt.repo.utility.StudentDto;
import com.schoolmgmt.schoolMgmt.repo.utility.TeacherDto;
import com.schoolmgmt.schoolMgmt.repo.utility.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    RoleRepository roleRepository;
    @Override
    public String saveUser(UserDetailsDto userDetailsDto) {
        String returnData="";

        try {
           UserDto userDto = userDetailsDto.getUserDto();
            if(userDto.getUserType().equalsIgnoreCase("STUDENT")){
                Users users=new Users();
                users.setName(userDto.getName());
                //users.getUserType(userDto.getUserType());
                users.setUsername(userDto.getUsername());
                String encodedPassword = passwordEncoder.encode(userDto.getPassword());
                users.setPassword(encodedPassword);
                String roles=userDto.getRole();
                Set<Role> role=new HashSet<>();
                if(roles==null){
                   // Role roless=roleRepository.findByName(ERole.ROLE_STUDENT.toString());
                    Role roless = new Role(ERole.ROLE_STUDENT);

                  role.add(roless);
                }
                users.setRoles(role);
                users.setPassword(userDto.getPassword());

                userRepository.save(users);
                StudentDto studentDto = userDetailsDto.getStudentDto();
                Student student=new Student();
                student.setCourse(studentDto.getCourse());
                student.setName(studentDto.getName());
                studentRepository.save(student);
                returnData="student data saved successfully";

            } else if (userDto.getUserType().equalsIgnoreCase("TEACHER")) {

                Users users=new Users();
                users.setName(userDto.getName());
                //users.getUserType(userDto.getUserType());
                users.setUsername(userDto.getUsername());
                String encodedPassword = passwordEncoder.encode(userDto.getPassword());
                users.setPassword(encodedPassword);
                String roles=userDto.getRole();
                Set<Role> role=new HashSet<>();
                if(roles==null){
               //     Role roless=roleRepository.findByName(ERole.ROLE_STUDENT);
                    Role roless = new Role(ERole.ROLE_TEACHER);

                    role.add(roless);
                }
                users.setRoles(role);
                users.setPassword(userDto.getPassword());

                userRepository.save(users);
                Teacher teacher=new Teacher();
                TeacherDto teacherDto = userDetailsDto.getTeacherDto();
                teacher.setName(teacherDto.getName());
                teacher.setSubject(teacherDto.getSubject());
                teacherRepository.save(teacher);
                returnData="teacher data saved successfully";

            }
        }catch (Exception ex){
            ex.printStackTrace();
        }

        return returnData;
    }
}
