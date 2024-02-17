package com.example.demo.service;

import java.util.List;

import com.example.demo.Entity.Guest;

public interface Guestservice {
	
	Guest createGuest(Guest guest);
	Guest updateGuest (Guest guest , Integer guestId);
	String deleteGuest(Integer guestId);
	Guest guestGetById(Integer guestId);
	List<Guest> getAllGuest();

}
