package com.example.demo.Entity;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Host")
public class Host {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Host_Id" )
	private Integer host_id;
	@Column(name="Host_Name")
	private String name;
//	@Column(name = "Proprty" )
//	private String property_type;
	@Column(name="About")
	private String about;
	@Column(name="Locaton" )
	private String location;
	@Column(name="Status")
	private Boolean status;
	@Column(name="Hosting_Since")
	private Date hosting_since;
	
	@OneToMany(mappedBy ="host" )
	//@JsonManagedReference
	@JsonIgnoreProperties("host")
	private List<Property> property;
	
	public Host() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Host(Integer host_id, String name,  String about, String location, Boolean status,
			Date hosting_since) {
		super();
		this.host_id = host_id;
		this.name = name;
		//this.property_type = property_type;
		this.about = about;
		this.location = location;
		this.status = status;
		this.hosting_since = hosting_since;
		
	}

	public Integer getHost_id() {
		return host_id;
	}
	public void setHost_id(Integer host_id) {
		this.host_id = host_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public Date getHosting_since() {
		return hosting_since;
	}
	public void setHosting_since(Date hosting_since) {
		this.hosting_since = hosting_since;
	}
	public List<Property> getProperty() {
		return property;
	}

	public void setProperty(List<Property> property) {
		this.property = property;
	}
	@Override
	public String toString() {
		return "Host {host_id=" + host_id + ", name=" + name + ", property_type=" + ", about=" + about
				+ ", location=" + location + ", status=" + status + ", hosting_since=" + hosting_since + "}";
	}
	
	

}
