package com.schoolmgmt.schoolMgmt.repo.utility;

import lombok.Data;

@Data
public class UserDto {

    private String name;
    private String username;
    private String password;
    private String userType;
    private String role;

}
