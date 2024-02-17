package com.example.demo.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Host;
@Repository
public interface HostRepo extends JpaRepository<Host , Integer>{

}
