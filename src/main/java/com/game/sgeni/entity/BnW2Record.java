package com.game.sgeni.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString	
public class BnW2Record {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer gameNum;
	
	// 방을 개별적으로 인식하게하는 아이디
	private String roomID;
	
	// 방이 보여지는 이름 
	private String roomName;
	
	// 선턴 유저
	@ManyToOne
	@Nullable
	private UserTable blueUser;
	
	// 후턴 유저
	@ManyToOne
	@Nullable
	private UserTable redUser;
	
	// 승리한 유저
	@ManyToOne
	@Nullable
	private UserTable winner;
	
	// 패배한 유저
	@ManyToOne
	@Nullable
	private UserTable loser;
	
}
