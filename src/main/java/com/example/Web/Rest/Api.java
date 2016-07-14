package com.example.Web.Rest;

import com.example.Domain.User;
import com.example.Services.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Created by bugrahansahin on 14/07/16.
 */
@RestController
@RequestMapping("/api")
public class Api {
    @Autowired
    Services services;

    @RequestMapping("/test")
    String test(){
        return "test";
    }

    @RequestMapping("/users")
    Collection<User> allUsers() {
        return services.allUsers();
    }

    @RequestMapping("/users/{id}")
    User findUserById(@PathVariable Long id) {
        return services.findUserById(id);
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    String deleteUserById(@PathVariable Long id) {
        return services.deleteUserById(id);
    }


    @RequestMapping(value = "/users", method = RequestMethod.POST)
    String addUser(@RequestBody User user) {
        return services.addUser(user);
    }

    @RequestMapping("/users/name/{name}")
    Collection<User> findUsersWithName(@PathVariable String name) {
        return services.findUsersWithName(name);
    }

    @RequestMapping(value = "/users/name/{name}", method = RequestMethod.DELETE)
    String deleteUsersWithName(@PathVariable String name) {
        return services.deleteUsersWithName(name);
    }

    @RequestMapping("/users/name/{name}/changeto/{newname}")
    String replaceNames(@PathVariable String name, @PathVariable String newname) {
        return services.replaceNames(name, newname);
    }
}
