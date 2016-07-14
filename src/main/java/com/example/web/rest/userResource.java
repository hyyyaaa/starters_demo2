package com.example.web.rest;

import com.example.domain.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Created by bugrahansahin on 14/07/16.
 */
@RequestMapping("/api")
@RestController
public class UserResource {
    @Autowired
    UserService userService;
    @RequestMapping("/test")
    String test(){
        return "test";
    }

    @RequestMapping("/users")
    Collection<User> allUsers() {
        return userService.allUsers();
    }

    @RequestMapping("/users/{id}")
    User findUserById(@PathVariable Long id) {
        return userService.findUserById(id);
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    String deleteUserById(@PathVariable Long id) {
        return userService.deleteUserById(id);
    }


    @RequestMapping(value = "/users", method = RequestMethod.POST)
    String addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @RequestMapping("/users/name/{name}")
    Collection<User> findUsersWithName(@PathVariable String name) {
        return userService.findUsersWithName(name);
    }

    @RequestMapping(value = "/users/name/{name}", method = RequestMethod.DELETE)
    String deleteUsersWithName(@PathVariable String name) {
        return userService.deleteUsersWithName(name);
    }

    @RequestMapping("/users/name/{name}/changeto/{newname}")
    String replaceNames(@PathVariable String name, @PathVariable String newname) {
        return userService.replaceNames(name, newname);
    }
}
