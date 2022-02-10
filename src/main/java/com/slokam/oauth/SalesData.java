package com.slokam.oauth;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="salesData")
public class SalesData {

	@Id
	@GeneratedValue
	private Integer id;
	private String logo;
	private String countryName;
	private Double gpa;
	private Double Percentage;
	
	
	
	
	@Override
	public String toString() {
		return "SalesData [id=" + id + ", logo=" + logo + ", countryName=" + countryName + ", gpa=" + gpa
				+ ", Percentage=" + Percentage + "]";
	}

	public SalesData() {
		System.out.println("In Default Constructor");
	}
	
	public SalesData(Integer id, String logo, String countryName, Double gpa, Double percentage) {
		super();
		this.id = id;
		this.logo = logo;
		this.countryName = countryName;
		this.gpa = gpa;
		Percentage = percentage;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public Double getGpa() {
		return gpa;
	}
	public void setGpa(Double gpa) {
		this.gpa = gpa;
	}
	public Double getPercentage() {
		return Percentage;
	}
	public void setPercentage(Double percentage) {
		Percentage = percentage;
	}
	

}