package com.backend.pharmacy_management.model.dto.user_role;

public class RoleDto {
    private Long roleId;
    private String roleName;

    public RoleDto() {
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
