package com.schoolmgmt.schoolMgmt.config;

import com.schoolmgmt.schoolMgmt.entity.Users;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

public class UserInfoDetails implements UserDetails {

    private String username;
    private String password;
    private Set<GrantedAuthority> authorities;

    //convert enum to string by name()
    UserInfoDetails(Users users){
        System.out.println(users.getUsername()+"1111111"+users.getPassword());
        username = users.getUsername();
        password=users.getPassword();
        authorities=users.getRoles().stream().map((role)->
                new SimpleGrantedAuthority(role.getName().name())).collect(Collectors.toSet());
        System.out.println("authorities"+authorities);
        users.getRoles().forEach(s->{
            System.out.println("Role---------------"+s.getName());
        });
//        authorities = Arrays.stream(users.getRoles().)
//                .map(SimpleGrantedAuthority::new)
//                .collect(Collectors.toList());

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
