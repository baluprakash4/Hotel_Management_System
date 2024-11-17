package com.hotelmanagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.binding.RoomRequest;
import com.binding.RoomResponse;
import com.hotelmanagement.Service.RoomService;

@RestController
public class RoomController {
	
	@Autowired
	private RoomService roomService;
	
//public RoomResponse fetchRoomByNo(Integer roomId);
	@GetMapping("/room/roomId/{roomId}")
	public ResponseEntity<RoomResponse> fetchRoomByNo(@PathVariable Integer roomId){
		if(roomId!=null) {
			RoomResponse fetchRoomByNo = roomService.fetchRoomByNo(roomId);
			return new ResponseEntity<RoomResponse>(fetchRoomByNo,HttpStatus.OK);
		}
		else
			return new ResponseEntity<RoomResponse>(HttpStatus.BAD_REQUEST);
	}
	
//	public List<RoomResponse> fetchRoomByType(String roomType);
	@GetMapping("/room/roomType/{roomType}")
	public ResponseEntity<List<RoomResponse>> fetchRoomType(@PathVariable String roomType){
		if(roomType!=null) {
			return new ResponseEntity<List<RoomResponse>>(roomService.fetchRoomByType(roomType),HttpStatus.OK);
		}
		else 
			return new ResponseEntity<List<RoomResponse>>(HttpStatus.OK);
		
	}
	
//	
//	public List<RoomResponse> fetchRoomByFloor(Integer floorNo);
	@GetMapping("room/floorNo/{floorNo}")
	public ResponseEntity<List<RoomResponse>> fetchRoomByfloorNo(@PathVariable Integer floorNo){
		if(floorNo!=null) {
			return new ResponseEntity<List<RoomResponse>>(roomService.fetchRoomByfloorNo(floorNo),HttpStatus.OK);
		}
		return null;
	}
//	
//	public boolean saveRoom(RoomRequest rr);
	@PostMapping("/room")
	public ResponseEntity<String> saveRoom(@RequestBody RoomRequest roomRequest){
		
		 if (roomRequest == null) {
		        return new ResponseEntity<>("Invalid room request data", HttpStatus.BAD_REQUEST);
		    }
			boolean saveRoom = roomService.saveRoom(roomRequest);
			if(saveRoom  ) {
			    return new ResponseEntity<String>("Data Inserted Sucessfully ",HttpStatus.OK);
		    }
			else 
			{
				return new ResponseEntity<String>("Data Insertion failed",HttpStatus.INTERNAL_SERVER_ERROR);
			}
	}

//	public RoomResponse updateRoom(RoomRequest rr,Integer roomId);
	@PutMapping("/room/roomId/{roomId}")
	public ResponseEntity<RoomResponse> updateRoom(@RequestBody RoomRequest roomRequest, @PathVariable Integer roomId) {
	    if (roomId == null || roomRequest == null) {
	        return new ResponseEntity<>(HttpStatus.BAD_REQUEST); // Return 400 Bad Request for invalid input
	    }

	    RoomResponse updatedRoom = roomService.updateRoom(roomRequest, roomId);
	    
	    if (updatedRoom != null) {
	        return new ResponseEntity<>(updatedRoom, HttpStatus.OK); // Return the updated room details with 200 OK
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Return 404 Not Found if the room doesn't exist
	    }
	}
	
//	public Boolean deleteRoomById(Integer roomId );
	@DeleteMapping("/room/roomId/{roomId}")
	public ResponseEntity<String> deleteRoomById(@PathVariable Integer roomId){
		if(roomId==null) {
			return new ResponseEntity<String>("Invalid Room Id",HttpStatus.BAD_REQUEST);
		}
		Boolean deleteRoomById = roomService.deleteRoomById(roomId);
		if(deleteRoomById)
			return new ResponseEntity<String>("Room Deleted Sucessfully ",HttpStatus.OK);
		else
			return new ResponseEntity<String>("Room Not Found",HttpStatus.NOT_FOUND);
	}

}
