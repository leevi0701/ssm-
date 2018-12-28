package com.itheima.domain;

import org.springframework.security.core.userdetails.User;

import java.io.Serializable;
import java.util.List;

/**
 * @author: liwei
 * @Date: 2018-12-27
 */
public class Role implements Serializable{

    private String id;
    private String roleName;
    private String roleDesc;
    private List<Permission> permissions;
    private List<User> users;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
