package com.vans.vans.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vans.vans.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}