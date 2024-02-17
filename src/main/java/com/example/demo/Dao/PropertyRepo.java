package com.example.demo.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Property;

@Repository
public interface PropertyRepo extends JpaRepository<Property, Long> {

}
