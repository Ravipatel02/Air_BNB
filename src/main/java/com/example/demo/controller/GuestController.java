package com.example.demo.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.Entity.Guest;
import com.example.demo.service.Guestservice;
@RequestMapping("api/")
@RestController
public class GuestController {
	@Autowired
	private Guestservice guest;
	
	@PostMapping("guest/")
	public ResponseEntity<Guest> saveGuest(@RequestBody Guest guest){
		Guest createGuest = this.guest.createGuest(guest);
		ResponseEntity.ok(HttpStatus.CREATED);
		return ResponseEntity.ok(createGuest);
		
	}
	
	@GetMapping("guest/{guestId}")
	public ResponseEntity<Guest> getGuest(@PathVariable Integer postId){
		Guest guestGetById = this.guest.guestGetById(postId);
		return ResponseEntity.ok(guestGetById);	
	}
	
	@PutMapping("guest/{guestId}")
	public ResponseEntity<Guest> updateHost(@RequestBody Guest guest , Integer guestId){
		Guest updateGuest = this.guest.updateGuest(guest, guestId);
		return ResponseEntity.ok(updateGuest);
	}
	@DeleteMapping("guest/{guestId}")
	public ResponseEntity<?> delete(@PathVariable Integer gustId){
		ResponseEntity<?> delete = this.delete(gustId);
		return ResponseEntity.ok(delete);
	}
	
	@GetMapping("guest/")
	public ResponseEntity<List<Guest>> allHost(){
		List<Guest> allGuest = this.guest.getAllGuest();
		return ResponseEntity.ok(allGuest);
	}

}
