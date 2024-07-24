package com.rsl.event.dao;

import org.springframework.data.repository.CrudRepository;

import com.rsl.event.entity.User;



public interface UserRepository extends CrudRepository<User, Integer> {
public User findByMailAndPassword(String mail, String password);
}
