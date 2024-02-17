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

import com.example.demo.Entity.Booking;
import com.example.demo.service.Impl.BookingServiceImpl;
@RestController
@RequestMapping("api/booking")
public class BookingController {
	
	@Autowired
	private BookingServiceImpl service;
	
	@PostMapping("/")
	public ResponseEntity<Booking> createBooking(@RequestBody Booking booking){
		Booking createBooking = this.service.createBooking(booking);
		return ResponseEntity.ok(HttpStatus.CREATED).ok(createBooking);
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Booking> updateBooking(@RequestBody Booking booking , @PathVariable long id){
		Booking updateBooking = this.service.updateBooking(booking, id);
		return ResponseEntity.ok(updateBooking);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Booking> getByid(@PathVariable Long id){
		Booking bookingById = this.service.getBookingById(id);
		return ResponseEntity.ok(bookingById);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Booking>> getAllBooking(){
		List<Booking> allBooking = this.service.AllBooking();
		return ResponseEntity.ok(allBooking);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteBooking(@PathVariable Long id){
		String deleteBookingById = this.service.deleteBookingById(id);
		return ResponseEntity.ok(deleteBookingById);
		
	}

}
