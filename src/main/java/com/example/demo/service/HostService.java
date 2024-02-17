package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Host;

public interface HostService {
	
	Host createHost (Host host);
	String DeleteHost(Integer hostId);
	Host UpdateHost(Host host,Integer hostId);
	Host getHostById(Integer hostId);
	List<Host> getAllHost();

}
