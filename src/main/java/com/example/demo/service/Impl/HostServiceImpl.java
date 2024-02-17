package com.example.demo.service.Impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Dao.HostRepo;
import com.example.demo.Entity.Host;
import com.example.demo.service.HostService;

@Service
public class HostServiceImpl implements HostService {
	@Autowired
	private HostRepo hostRepo;

	@Override
	public Host createHost(Host host) {
		Host save = this.hostRepo.save(host);
		return save;
	}

	@Override
	public String DeleteHost(Integer hostId) {
		this.hostRepo.deleteById(hostId);
		return "Delete Successfully !";
	}

	@Override
	public Host UpdateHost(Host host ,Integer hostId) {
		Optional<Host> findById = this.hostRepo.findById(hostId);
		if(findById.isPresent()) {
			Host host1 = findById.get();
			host1.setName(host.getName());
			host1.setAbout(host.getAbout());
			host1.setHosting_since(host.getHosting_since());
			host1.setLocation(host.getLocation());
			//host1.setProperty_type(host.getProperty_type());
			host1.setStatus(host.getStatus());
			
			Host save = this.hostRepo.save(host1);
			return save;
		}
		return null;
	}

	@Override
	public Host getHostById(Integer hostId) {
		Optional<Host> findById = this.hostRepo.findById(hostId);
		if(findById.isPresent()) {
			Host host = findById.get();
			return host;
		}else {
			return null;
		}
	}

	@Override
	public List<Host> getAllHost() {
		List<Host> findAll = this.hostRepo.findAll();
		return findAll;
	}

}
