package com.example.demo.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Dao.PropertyRepo;
import com.example.demo.Entity.Property;
import com.example.demo.service.Properteyservice;

@Service
public class PropertyServiceImpl implements Properteyservice {
	@Autowired
	private PropertyRepo property;

	@Override
	public Property createProperty(Property property) {
		Property save = this.property.save(property);
		return save;
	}

	@Override
	public Property updateProperty(Property property, Long id) {
		Optional<Property> findById = this.property.findById(id);
		if(findById.isPresent()) {
			Property property2 = findById.get();
			property2.setCreatedAt(property.getCreatedAt());
			property2.setDescription(property.getDescription());
			property2.setHost(property.getHost());
			property2.setName(property.getName());
			Property save = this.property.save(property2);
			return save;
		}else {
			return null;
		}
	}

	@Override
	public String deleteProperty(Long id) {
		Optional<Property> findById = this.property.findById(id);
		if(findById.isPresent()) {
			this.property.deleteById(id);
			return "Delete successfull !";
		}else {
			return "Property id Not Present !";
		}
		
	}

	@Override
	public Property getProprtyById(Long id) {
		Optional<Property> findById = this.property.findById(id);
		if(findById.isPresent()) {
			Property property2 = findById.get();
			return property2;
		}else {
			return null;
		}
	}

	@Override
	public List<Property> getAllProperty() {
		List<Property> findAll = this.property.findAll();
		return findAll;
	}

}
