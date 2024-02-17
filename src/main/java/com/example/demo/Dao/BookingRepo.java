package com.example.demo.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Booking;

@Repository
public interface BookingRepo extends JpaRepository<Booking, Long> {

}
