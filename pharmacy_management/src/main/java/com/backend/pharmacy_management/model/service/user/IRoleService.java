package com.backend.pharmacy_management.model.service.user;

import com.backend.pharmacy_management.model.entity.user_role.Role;

public interface IRoleService {
    Iterable<Role> findAll();
}
