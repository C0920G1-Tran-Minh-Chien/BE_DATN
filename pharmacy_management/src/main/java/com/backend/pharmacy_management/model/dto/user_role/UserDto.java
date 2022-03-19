package com.backend.pharmacy_management.model.dto.user_role;

import com.backend.pharmacy_management.model.entity.employee.Employee;
import com.backend.pharmacy_management.model.entity.user_role.Role;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

public class UserDto {

    private Long userId;
    @NotEmpty(message = "Tên tài khoản không được để trống!")
    @Size(min = 5,max = 20,message = "Tên tài khoản phải lớn hơn 5 và nhỏ hơn 20 kí tự!")
    @Pattern(regexp = "^[0-9a-zA-Z]*$",message = "Tên tài khoản không chứa kí tự đặc biệt!")
    private String userName;
    private String userCode;
    private String accountName;
    private String password;
    private Employee employee;
    private Set<Role> roles = new HashSet<>();

    public UserDto() {
    }

    public UserDto(Long userId, String userName, String userCode, @NotEmpty(message = "Tên tài khoản không được để trống!") @Size(min = 5, max = 20, message = "Tên tài khoản phải lớn hơn 5 và nhỏ hơn 20 kí tự!") @Pattern(regexp = "^[0-9a-zA-Z]*$", message = "Tên tài khoản không chứa kí tự đặc biệt!") String accountName, String password, Employee employee, Set<Role> roles) {
        this.userId = userId;
        this.userName = userName;
        this.userCode = userCode;
        this.accountName = accountName;
        this.password = password;
        this.employee = employee;
        this.roles = roles;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
