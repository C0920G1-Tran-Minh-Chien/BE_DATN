package com.backend.pharmacy_management.model.service.user;

import com.backend.pharmacy_management.model.dto.user_role.UserDto;
import com.backend.pharmacy_management.model.entity.user_role.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.BindingResult;

import java.util.Map;
import java.util.Optional;

public interface IUserService {
    Page<User> findAll(Pageable pageable);

    Optional<User> findById(Long id);

    void save(User user);

    Page<User> findAllByProperty(Pageable pageable,String keyWord,Long property,Integer roleId);

    Iterable<User> findAllNoPage();

    Map<String,Object> update(UserDto putData, BindingResult bindingResult, Long id);
}
