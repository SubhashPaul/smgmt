package com.schoolmgmt.schoolMgmt.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

    @Data
    @Entity
    @AllArgsConstructor
    @NoArgsConstructor
    @Table(name = "role")
    public class Role {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @Enumerated(EnumType.STRING)
        @Column(name="role_name")
        private ERole name;
        @Column(name="description")
        private String discritption;

        public Role(ERole name) {
            this.name = name;
        }

        // @ManyToMany(mappedBy = "roles", fetch = FetchType.EAGER)
        //  private Set<Users> users;

    }

