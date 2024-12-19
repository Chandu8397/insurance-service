package com.coforge.training.agribid.insurance.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Insurance {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  //p-key
	private Long policyId;
	
	@Column(nullable = false)
	private String season;
	
	@Column(nullable = false)
	private int year;
	
	@Column(nullable = false)
	private String cropName;
	
	@Column(nullable = false)
	private Double sumInsured;
	
	@Column(nullable = false)
	private Double area;
	
	@Column(nullable = false)
	private String insuranceCompany;
	
	
	private Double premiumAmount;
	
	private Double premiumRate;

	
	//generating Getters & Setters
	public Long getId() {
		return policyId;
	}

	public Double getPremiumRate() {
		return premiumRate;
	}

	public void setPremiumRate(Double premiumRate) {
		this.premiumRate = premiumRate;
	}

	public void setId(Long id) {
		this.policyId = id;
	}

	public String getSeason() {
		return season;
	}

	public void setSeason(String season) {
		this.season = season;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getCropName() {
		return cropName;
	}

	public void setCropName(String cropName) {
		this.cropName = cropName;
	}

	public Double getSumInsured() {
		return sumInsured;
	}

	public void setSumInsured(Double sumInsured) {
		this.sumInsured = sumInsured;
	}

	public Double getArea() {
		return area;
	}

	public void setArea(Double area) {
		this.area = area;
	}

	public String getInsuranceCompany() {
		return insuranceCompany;
	}

	public void setInsuranceCompany(String insuranceCompany) {
		this.insuranceCompany = insuranceCompany;
	}

	public Double getPremiumAmount() {
		return premiumAmount;
	}

	public void setPremiumAmount(Double premiumAmount) {
		this.premiumAmount = premiumAmount;
	}

	


		
	}
	

