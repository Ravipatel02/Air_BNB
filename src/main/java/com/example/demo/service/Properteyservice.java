package com.example.demo.service;

import java.util.List;

import com.example.demo.Entity.Property;

public interface Properteyservice {
	
	Property createProperty(Property property);
	
	Property updateProperty(Property property , Long id);
	
	String deleteProperty(Long id);
	
	Property getProprtyById(Long id);
	
	List<Property> getAllProperty();

}
