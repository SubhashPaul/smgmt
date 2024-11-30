package com.schoolmgmt.schoolMgmt.service;


import com.schoolmgmt.schoolMgmt.entity.Users;
import com.schoolmgmt.schoolMgmt.repo.UserDetailsDto;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    public String saveUser(UserDetailsDto userDetailsDto);
}
