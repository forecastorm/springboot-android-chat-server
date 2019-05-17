package com.nil.server.dao;

import com.nil.server.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {


    User findByUserName(String userName);

}