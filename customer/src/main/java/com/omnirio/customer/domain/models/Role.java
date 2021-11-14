package com.omnirio.customer.domain.models;

public class Role {
    private String roleId;
    private String roleName;
    private String roleCode;

    public Role() { }

    public Role(
        String roleId,
        String roleName,
        String roleCode) {
        
        this.roleId = roleId;
        this.roleName = roleName;
        this.roleCode = roleCode;
    }

    public String getRoleId() {
        return roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public String getRoleCode() {
        return roleCode;
    }
}