package com.example.demo.service.Impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Dao.GuestRepo;
import com.example.demo.Entity.Guest;
import com.example.demo.service.Guestservice;

@Service
public class GuestServiceImpl implements Guestservice {
	@Autowired
	private GuestRepo guest;

	@Override
	public Guest createGuest(Guest guest) {
		Guest save = this.guest.save(guest);
		return save;
	}

	@Override
	public Guest updateGuest(Guest guest, Integer guestId) {
		Optional<Guest> findById = this.guest.findById(guestId);
		if(findById.isPresent()) {
			Guest guest2 = findById.get();
			guest2.setBio(guest.getBio());
			guest2.setDateOfBirth(guest.getDateOfBirth());
			guest2.setGender(guest.getGender());
			guest2.setName(guest.getName());
			
			Guest save = this.guest.save(guest2);
			return save;
		}else {
			return null;
		}
	}

	@Override
	public String deleteGuest(Integer guestId) {
		Optional<Guest> findById = this.guest.findById(guestId);
		if(findById.isPresent()) {
			this.guest.deleteById(guestId);
			return "Delete successfully !";
		}else {
			return "Id is not Prsent !";
		}
	}

	@Override
	public Guest guestGetById(Integer guestId) {
		Optional<Guest> findById = this.guest.findById(guestId);
		if(findById.isPresent()) {
			Guest guest2 = findById.get();
			return guest2;
		}else {
			return null;
		}
	}

	@Override
	public List<Guest> getAllGuest() {
		List<Guest> findAll = this.guest.findAll();
		return findAll;
	}
	
	

}
