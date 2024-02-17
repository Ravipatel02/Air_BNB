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

import com.example.demo.Entity.Property;
import com.example.demo.service.Impl.PropertyServiceImpl;

@RequestMapping("/api")
@RestController
public class PropertyController {
	
	@Autowired
	private PropertyServiceImpl service ;
	
	@PostMapping("/property")
	public ResponseEntity<Property> createProprty(@RequestBody Property property){
		Property createProperty = this.service.createProperty(property);
		ResponseEntity.ok(HttpStatus.CREATED);
		return ResponseEntity.ok(createProperty);
		
	}
	
	@PutMapping("/property/{id}")
	public ResponseEntity<Property> updateProperty(@RequestBody Property property ,@PathVariable Long id){
		Property updateProperty = this.service.updateProperty(property, id);
		return ResponseEntity.ok(updateProperty);
	}
	
	@GetMapping("/property/{id}")
	public ResponseEntity<Property> getPropertyById(@PathVariable Long id){
		Property proprtyById = this.service.getProprtyById(id);
		return ResponseEntity.ok(proprtyById);
	}
	
	@GetMapping("property/")
	public ResponseEntity<List<Property>> getAllProperty(){
		List<Property> allProperty = this.service.getAllProperty();
		return ResponseEntity.ok(allProperty);
		
	}
	
	@DeleteMapping("property/{id}")
	public ResponseEntity<?> deleteProperty(@PathVariable Long id){
		String deleteProperty = this.service.deleteProperty(id);
		return ResponseEntity.ok(deleteProperty);
	}

}

