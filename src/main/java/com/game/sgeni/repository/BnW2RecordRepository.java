package com.game.sgeni.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.game.sgeni.entity.BnW2Record;

public interface BnW2RecordRepository extends JpaRepository<BnW2Record, Integer>{

	BnW2Record findByroomID(String roomID);
	
}
