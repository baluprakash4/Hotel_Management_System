package com.hotelmanagement.Service;

import java.util.List;

import com.binding.RoomRequest;
import com.binding.RoomResponse;

public interface RoomService {

	public RoomResponse fetchRoomByNo(Integer roomId);
	
	public List<RoomResponse> fetchRoomByType(String roomType);
	
	public List<RoomResponse> fetchRoomByfloorNo(Integer floorNo);
	
	public boolean saveRoom(RoomRequest rr);
	
	public RoomResponse updateRoom(RoomRequest rr,Integer roomId);
	
	public Boolean deleteRoomById(Integer roomId );
	
	
	
	
}
