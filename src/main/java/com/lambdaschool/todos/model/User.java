package com.lambdaschool.todos.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

// User is considered the parent entity of all - the Grand Poobah!

@Entity
@Table(name = "users")
public class User extends Auditable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userid;

    @Column(nullable = false,
            unique = true)
    private String username;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @OneToMany(mappedBy = "user",
               cascade = CascadeType.ALL)
    @JsonIgnoreProperties("users")
    private List<UserRoles> userRoles = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    @JsonIgnoreProperties("user")
    private List<Todo> userTodos = new ArrayList<>();

    public User()
    {
    }
    public User(String username, String password, List<UserRoles> userRoles)

    {
        setUsername(username);
        setPassword(password);
        for (UserRoles ur : userRoles)
        {
            ur.setUser(this);
        }

        this.userRoles = userRoles;
    }

    public long getUserid()
    {
        return userid;
    }

    public void setUserid(long userid)
    {
        this.userid = userid;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public List<UserRoles> getUserRoles()
    {
        return userRoles;
    }

    public void setUserRoles(List<UserRoles> userRoles)
    {
        this.userRoles = userRoles;
    }

    public List<Todo> getUserTodos() {
        return userTodos;
    }

    public void setUserTodos(List<Todo> userTodos) {
        this.userTodos = userTodos;
    }
}