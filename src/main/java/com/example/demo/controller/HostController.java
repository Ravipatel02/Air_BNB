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

import com.example.demo.Entity.Host;
import com.example.demo.service.HostService;

@RestController
@RequestMapping("api/host")
public class HostController {
	@Autowired
	private HostService hostService;
	
	@PostMapping("/")
	public ResponseEntity<Host> saveHost(@RequestBody Host host){
		Host createHost = this.hostService.createHost(host);
		return ResponseEntity.status(HttpStatus.CREATED).body(createHost);
		
	}
	
	@GetMapping("/{postId}")
	public ResponseEntity<Host> getHost(@PathVariable Integer postId){
		Host hostById = this.hostService.getHostById(postId);
		return ResponseEntity.ok(hostById);
	}
	
	@PutMapping("/{hostid}")
	public ResponseEntity<Host> updateHost(@RequestBody Host host , Integer hostid){
		Host updateHost = this.hostService.UpdateHost(host, hostid);
		return ResponseEntity.status(HttpStatus.CREATED).body(updateHost);
	}
	@DeleteMapping("/{hostId}")
	public ResponseEntity<?> delete(@PathVariable Integer hostid){
		String deleteHost = this.hostService.DeleteHost(hostid);
		return ResponseEntity.ok(deleteHost);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Host>> allHost(){
		List<Host> allHost = this.hostService.getAllHost();
		return ResponseEntity.ok(allHost);
	}

}
