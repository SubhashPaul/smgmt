package com.schoolmgmt.schoolMgmt.config;

import com.schoolmgmt.schoolMgmt.entity.Users;
import com.schoolmgmt.schoolMgmt.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class UserInfo implements UserDetailsService {

    @Autowired
    public UserRepository userRepository;
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user=userRepository.findByUsername(username);
        if(!ObjectUtils.isEmpty(user)){
            return new UserInfoDetails(user);
        }
        else {
            throw new IllegalArgumentException("Username is not found");
        }

    }
}
