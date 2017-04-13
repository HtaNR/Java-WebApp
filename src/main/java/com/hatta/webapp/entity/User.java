/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hatta.webapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hatta.webapp.annotation.UniqueUsername;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author Hatta NR
 */
@Entity
@Table(name = "app_user")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Size (min=3, message="Name must be at least 3 characters!")
    @Column(unique = true)
    @UniqueUsername(message = "Such username already exists")
    private String name;
    @Size(min = 1, message = "Invalid email address")
    @Email(message = "Invalid email address")
    private String email;
    @Size (min=5, message="Password must be at least 5 characters!")
    private String password;
    private boolean enabled;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable
    private List<Role> roles;
    @OneToMany(mappedBy="user",cascade = CascadeType.REMOVE)
    private List<Blog> blogs;
    
    public User() {
		super();
	}
	
	public User(int id, String name, String email, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
	}
    
    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
    
//    need this to make fetch eager not looping 
   @JsonIgnore 
    public List<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }
    @JsonIgnore
    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
         this.password = password;

       
    }
      
}
