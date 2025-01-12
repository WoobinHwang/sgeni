package com.game.sgeni.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.game.sgeni.bnw2.BnW2Room;
import com.game.sgeni.entity.BnW2Record;
import com.game.sgeni.entity.UserTable;
import com.game.sgeni.repository.BnW2RecordRepository;
import com.game.sgeni.repository.UserTableRepository;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BnW2Service {
	
	private Map<String, BnW2Room> bnW2Rooms;
	private final BnW2RecordRepository bnW2RecordRepository;
	private final UserTableRepository userTableRepository;
	
	@PostConstruct
	private void init() {
		bnW2Rooms = new LinkedHashMap<>();
	}
	
	// 모든 방 목록을 list로 반환
	public List<BnW2Record> findAbleToEnterBnW2Room() {
			
		// 현재 서버가 돌아가기 시작한 이후부터 생성된 오목 방들의 uuid를 가져오기
		Set<String> roomIDs = bnW2Rooms.keySet();
		
		List<BnW2Record> bnW2Records = new ArrayList<BnW2Record>();
		
		for (String roomID : roomIDs) {
			
			BnW2Record bnW2Record = bnW2RecordRepository.findByroomID(roomID);
			bnW2Records.add(bnW2Record);
			
		}
		
		return bnW2Records;
	}

	public BnW2Record createRoom(BnW2Record bnW2Record, String username) {
		// TODO Auto-generated method stub
		// uuid : 중복되지않는 고유한 문자열 생성
		String randomUUID = UUID.randomUUID().toString(); 
		System.out.println(randomUUID);
		
		UserTable user = userTableRepository.findByusername(username);
		
		// 방을 만든 사람이 선플레이어가 됩니다.
		bnW2Record.setRoomID(randomUUID);
		bnW2Record.setBlueUser(user);
		
		BnW2Room bnW2Room = BnW2Room.builder()
				.roomID(randomUUID)
				.roomName(bnW2Record.getRoomName())
				.build();
		bnW2Rooms.put(randomUUID, bnW2Room);
		
		bnW2RecordRepository.save(bnW2Record);
		return bnW2Record;
		
	}
	
}
