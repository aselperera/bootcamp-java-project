package com.team.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.team.entity.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {

}
