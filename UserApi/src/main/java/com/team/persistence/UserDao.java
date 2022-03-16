package com.team.persistence;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.team.entity.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("update User set balance=:balance where id=:id")
	public void updateBalance(@Param("balance") double balance, @Param("id") int id);
	
	@Query("from User where email=:email and password=:pwd")
	public User findUserByEmailAndPassword(@Param("email") String email,@Param("pwd") String password);
	
	@Transactional
	@Modifying
	@Query("update User set firstName=:firstName, lastName=:lastName, email=:email where id=:id")
	public int updateUser(@Param("firstName") String firstName, @Param("lastName") String lastName, @Param("email") String email, @Param("id") int id);
}
