/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ayush.first.project.SpringWithDb.model;




import org.springframework.boot.autoconfigure.domain.EntityScan;
/**
 *
 * @author ayush
 */


public class User {
    private Long id;
    private String name;
    private String email;
    public User()
    {}
    public User (Long id, String name, String email)
    {
        this.id = id;
        this.name = name;
        this.email = email;
    }
    
    public Long getId()
    {
        return id;
    }
    
    public String getName()
    {
        return name;
    }
            
    public void setName(String name)
    {
        this.name = name;
    }
    
     public String getEmail()
    {
        return email;
    }
            
    public void setEmail(String email)
    {
        this.email = email;
    }
    
}
