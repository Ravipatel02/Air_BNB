package com.example.demo.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Dao.BookingRepo;
import com.example.demo.Entity.Booking;
import com.example.demo.service.BookingService;

@Service
public class BookingServiceImpl implements BookingService {
	@Autowired
	private BookingRepo service;
   
	// create booking
	@Override
	public Booking createBooking(Booking booking) {
		Booking save = this.service.save(booking);
		return save;
	}

	@Override
	public Booking updateBooking(Booking booking, Long id) {
		Optional<Booking> findById = this.service.findById(id);
		if(findById.isPresent()) {
			Booking booking2 = findById.get();
			booking2.setCheckInDate(booking.getCheckInDate());
			booking2.setCheckOutDate(booking.getCheckOutDate());
			booking2.setPrice(booking.getPrice());
			
			Booking save = this.service.save(booking2);
			return save;
		}else {
			return null;
		}
	}

	@Override
	public Booking getBookingById(Long id) {
		Optional<Booking> findById = this.service.findById(id);
		if(findById.isPresent()) {
			Booking booking = findById.get();
			return booking;
		}
		return null;
	}

	@Override
	public List<Booking> AllBooking() {
		List<Booking> findAll = this.service.findAll();
		return findAll;
	}

	@Override
	public String deleteBookingById(Long id) {
		Optional<Booking> findById = this.service.findById(id);
		if(findById.isPresent()) {
			this.service.deleteById(id);
			return "Susses full";
		}
		return "Id is not Present !";
	}

}
