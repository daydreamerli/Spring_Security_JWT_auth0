package com.daydreamer.usersapi.repo;

import com.daydreamer.usersapi.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface RoleRepo extends JpaRepository<Role,Long> {

    Role findByName(String name);
}
