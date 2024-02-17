package com.example.demo.service;

import java.util.List;

import com.example.demo.Entity.Booking;

public interface BookingService {
	
	Booking createBooking(Booking booking);
	
	Booking updateBooking(Booking booking , Long id);
	
	Booking getBookingById(Long id);
	
	List<Booking> AllBooking();
	
	String deleteBookingById(Long id);

}
