package com.hivesplaceteam.sbWebJpaRest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hivesplaceteam.sbWebJpaRest.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	@Query("select u from User u where u.username=?1")
	public Optional<User> findByUserName(String username);
	
}
