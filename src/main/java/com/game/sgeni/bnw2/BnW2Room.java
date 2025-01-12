package com.game.sgeni.bnw2;

import java.util.HashSet;
import java.util.Set;

import org.springframework.web.socket.WebSocketSession;

import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BnW2Room {

	// 방 번호
	private String roomID;
	
	// 방이 보여지는 이름
	private String roomName;
	
	// 세션으로 구분할 방 Set
	private Set<WebSocketSession> sessions = new HashSet<>();
	
	@Builder
	public BnW2Room(String roomID, String roomName) {
		this.roomID = roomID;
		this.roomName = roomName;
	}
	
}
