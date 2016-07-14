package com.example.service;

import com.example.domain.User;
import com.example.resources.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by bugrahansahin on 14/07/16.
 */
@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    public Collection<User> allUsers() {
        return this.userRepository.findAll();
    }

    public User findUserById(Long id) {
        return this.userRepository.findOne(id);
    }

    public String deleteUserById(Long id) {
        this.userRepository.delete(id);
        return "User Deleted Successfully!";
    }

    public String addUser(User user) {
        this.userRepository.save(user);
        return "User Added Successfully!";
    }

    public Collection<User> findUsersWithName(String name) {
        return this.userRepository.findByName(name);
    }

    public String deleteUsersWithName(String name) {
        this.userRepository.findByName(name).forEach(user->{this.userRepository.delete(user);});
        return "Users Successfuly Deleted!";
    }


    public String replaceNames(String name, String newname) {
        this.userRepository.findByNameStartingWith(name).forEach(user->{
            user.setName(newname);
            this.userRepository.save(user);
        });
        return "Replacement is done";
    }


}
