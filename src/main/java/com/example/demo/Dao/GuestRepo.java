package com.example.demo.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Guest;

@Repository
public interface GuestRepo extends JpaRepository<Guest, Integer> {

}
