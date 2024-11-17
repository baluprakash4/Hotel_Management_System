package com.hotelmanagement.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.binding.RoomRequest;
import com.binding.RoomResponse;

public interface RoomRepo extends JpaRepository <Room,Integer>{

	public List<Room> findByRoomType(String roomType);
	
	public List<Room> findByFloorNo(Integer floorNo);

	
	
}
