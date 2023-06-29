package com.flipkart.bean;

public class Roles {
    private int roleId;
    private String roleName;
    private String roleDesc;

    public Roles(int roleId, String roleName, String roleDesc) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.roleDesc = roleDesc;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }
}
