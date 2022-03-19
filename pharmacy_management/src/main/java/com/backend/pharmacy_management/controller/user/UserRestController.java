package com.backend.pharmacy_management.controller.user;

import com.backend.pharmacy_management.model.dto.user_role.UserDto;
import com.backend.pharmacy_management.model.entity.user_role.Role;
import com.backend.pharmacy_management.model.entity.user_role.User;
import com.backend.pharmacy_management.model.service.user.IRoleService;
import com.backend.pharmacy_management.model.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("api/users")
@CrossOrigin()
public class UserRestController {
    @Autowired
    private IUserService userService;

    @Autowired
    private IRoleService roleService;

    @CrossOrigin
    @GetMapping
    public ResponseEntity<Page<User>> findAllUser(@RequestParam Integer page,
                                                  @RequestParam Integer size,
                                                  @RequestParam String keyWord,
                                                  @RequestParam Long property,
                                                  @RequestParam Integer roleId
    ) {
        Page<User> users = userService.findAllByProperty(PageRequest.of(page,size),keyWord,property,roleId);

        if (users.isEmpty()) {
            return new ResponseEntity<>(users, HttpStatus.OK);
        }
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity<User> findUserById(@PathVariable Long id) {
        Optional<User> userOptional = userService.findById(id);
        if (!userOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(userOptional.get(), HttpStatus.OK);
    }


    @CrossOrigin
    @PutMapping(value= "edit/{id}")
    public Map<String,Object> updateUser(@PathVariable Long id, @Valid @RequestBody UserDto userDto, BindingResult bindingResult) {
        return userService.update(userDto,bindingResult,id);
    }

    @CrossOrigin
    @GetMapping(value= "/role")
    public ResponseEntity<Iterable<Role>> findAllUser() {
        Iterable<Role> roles = roleService.findAll();

        if (roles == null) {
            return new ResponseEntity<>(roles, HttpStatus.OK);
        }
        return new ResponseEntity<>(roles, HttpStatus.OK);
    }

}
