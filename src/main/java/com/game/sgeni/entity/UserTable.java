package com.game.sgeni.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class UserTable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userNum;
	
	@Column(unique = true, nullable = false)
	private String username;
	
	@Column(unique = true, nullable = false)
	private String password;
	
	@Column(unique = true, nullable = false)
	private String nickname;
	
}
