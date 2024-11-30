package com.schoolmgmt.schoolMgmt.repo;

import com.schoolmgmt.schoolMgmt.entity.ERole;
import com.schoolmgmt.schoolMgmt.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByName(ERole status);
}
