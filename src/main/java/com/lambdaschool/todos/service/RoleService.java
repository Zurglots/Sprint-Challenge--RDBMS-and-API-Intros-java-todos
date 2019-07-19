package com.lambdaschool.todos.service;

import com.lambdaschool.authenticatedusers.model.Role;
import com.lambdaschool.todos.model.Role;

import java.util.List;

public interface RoleService
{
    List<Role> findAll();

    Role findRoleById(long id);

    void delete(long id);

    Role save(Role role);
}