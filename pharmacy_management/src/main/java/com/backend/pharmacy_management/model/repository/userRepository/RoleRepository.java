package com.backend.pharmacy_management.model.repository.userRepository;

import com.backend.pharmacy_management.model.entity.user_role.ERole;
import com.backend.pharmacy_management.model.entity.user_role.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
