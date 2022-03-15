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
	@Modifying
	@Query("update User set password=:password where id=:id")
	public int updatePassword(@Param("password") String password, @Param("id") int id);
	
	@Query("from User where email=:email and password=:pwd")
	public User findUserByEmailAndPassword(@Param("email") String email,@Param("pwd") String password);
	
	/*
	@Transactional
	@Modifying
	@Query("update User set firstName=:firstName where id=:id")
	public int updateFirstName(@Param("firstName") String firstName, @Param("id") int id);
	
	@Transactional
	@Modifying
	@Query("update User set lastName=:lastName where id=:id")
	public int updateLastName(@Param("lastName") String lastName, @Param("id") int id);
	
	@Transactional
	@Modifying
	@Query("update User set email=:email where id=:id")
	public int updateEmail(@Param("email") String email, @Param("id") int id);
	*/
}
