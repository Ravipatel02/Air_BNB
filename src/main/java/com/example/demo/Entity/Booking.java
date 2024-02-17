package com.example.demo.Entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long booking_id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnoreProperties("property")
	private Property propertyId;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnoreProperties("booking")
	private Guest guestid;
	
	private Date checkInDate;
	
	private Date checkOutDate;
	
	private double price;

	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Booking(Long booking_id, Property propertyId, Guest guestid, Date checkInDate, Date checkOutDate,
			double price) {
		super();
		this.booking_id = booking_id;
		this.propertyId = propertyId;
		this.guestid = guestid;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.price = price;
	}

	public Long getBooking_id() {
		return booking_id;
	}

	public void setBooking_id(Long booking_id) {
		this.booking_id = booking_id;
	}

	public Property getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(Property propertyId) {
		this.propertyId = propertyId;
	}

	public Guest getGuestid() {
		return guestid;
	}

	public void setGuestid(Guest guestid) {
		this.guestid = guestid;
	}

	public Date getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(Date checkInDate) {
		this.checkInDate = checkInDate;
	}

	public Date getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(Date checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
	

}
