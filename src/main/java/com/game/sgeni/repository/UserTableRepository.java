package com.game.sgeni.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.game.sgeni.entity.UserTable;

public interface UserTableRepository extends JpaRepository<UserTable, Integer>{
	
	UserTable findByusername(String username);
    

	
	
}
