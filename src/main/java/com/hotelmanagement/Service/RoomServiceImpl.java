package com.hotelmanagement.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.binding.RoomRequest;
import com.binding.RoomResponse;
import com.hotelmanagement.Dao.Room;
import com.hotelmanagement.Dao.RoomRepo;

@Service
public class RoomServiceImpl implements RoomService{

	@Autowired
	private RoomRepo roomRepo;
	
	@Override
	public RoomResponse fetchRoomByNo(Integer roomId) {
	
		Optional<Room> byId = roomRepo.findById(roomId);
		
		if(byId.isPresent()) {
			RoomResponse rr=new RoomResponse();
			Room room =byId.get();
			BeanUtils.copyProperties(room,rr);
			return rr;
		}
		return null;
		
  }

	
	
	@Override
	public List<RoomResponse> fetchRoomByType(String roomType) {
		
		
	    List<Room> rooms = roomRepo.findByRoomType(roomType); 
	    List<RoomResponse> roomResponses = new ArrayList<>();
	    
	    if (rooms != null && !rooms.isEmpty()) {
	        for (Room room : rooms) { 
	            RoomResponse roomResponse = new RoomResponse();
	            BeanUtils.copyProperties(room, roomResponse); 
	            roomResponses.add(roomResponse); 
	        }
	        return roomResponses; 
	    }
	    
	    return new ArrayList<>(); 
	}


	@Override
	public boolean saveRoom(RoomRequest rr) {
		
		if(rr!=null) {
			Room r=new Room();
			BeanUtils.copyProperties(rr, r);
			roomRepo.save(r);
			return true;
		}
		else 
			return false;
		
	}

	@Override
	public RoomResponse updateRoom(RoomRequest rr,Integer roomId) {
		
		Optional<Room> byId = roomRepo.findById(roomId);
		if(rr!=null && roomId!=null && byId.isPresent()) {
			Room room=byId.get();
			
			if(rr.getFloorNo()!=null) {
			   room.setFloorNo(rr.getFloorNo());
			}
			if(rr.getRoomNo()!=null) {
				room.setRoomNo(rr.getRoomNo());
			}
			if(rr.getRoomType()!=null) {
				room.setRoomType(rr.getRoomType());
			}
			
			RoomResponse roomResponse=new RoomResponse();
			
			BeanUtils.copyProperties(room, roomResponse);
			
			roomRepo.save(room);
			
			return roomResponse;
				
		}
		return null;
	}

	@Override
	public Boolean deleteRoomById(Integer roomId) {
		Optional<Room> byId = roomRepo.findById(roomId);
		if(byId.isPresent()) {
			roomRepo.deleteById(roomId);
			System.out.println("Room Id : "+roomId+" is deleted sucessfully");
			return true;
		}
		return false;
	}

	@Override
	public List<RoomResponse> fetchRoomByfloorNo(Integer floorNo) {
	    List<Room> rooms = roomRepo.findByFloorNo(floorNo); 
	    List<RoomResponse> roomResponses = new ArrayList<>();
	    if (rooms != null && !rooms.isEmpty()) {
	    	
	        for (Room room : rooms) {
	        	RoomResponse rr = new RoomResponse();
	            BeanUtils.copyProperties(room, rr);
	            roomResponses.add(rr);
	        }
	    }
	    return roomResponses;
	}


}
