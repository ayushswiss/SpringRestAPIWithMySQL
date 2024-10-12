/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ayush.first.project.SpringWithDb.repository;
import com.ayush.first.project.SpringWithDb.model.User;
import java.util.*;

/**
 *
 * @author ayush
 */
public class UserManagement {
    List<User> userList = new ArrayList<>();
    
    public UserManagement()
    {}
    
    
    public User createUser(User user)
    {        
        userList.add(user);
        return user;
    }
    
    public Optional<User> getUserByID(Long id)
    {
         return userList.stream().filter(u -> Objects.equals(u.getId(), id)).findFirst();
    }
    
    public void deleteUser(Long id)
    {
        userList.removeIf(u -> Objects.equals(u.getId(), id));
    }
    
    public List<User> getAllUsers()
    {
        return userList;
    }
}
