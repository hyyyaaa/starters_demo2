package com.example.Resources;

/**
 * Created by bugrahansahin on 14/07/16.
 */

import com.example.Domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface UserRepository extends JpaRepository<User,Long>{
    Collection<User> findByName(String name);
    Collection<User> findByNameStartingWith(String name);
}
