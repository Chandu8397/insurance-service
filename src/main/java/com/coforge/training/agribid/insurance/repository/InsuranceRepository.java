package com.coforge.training.agribid.insurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coforge.training.agribid.insurance.model.Insurance;

public interface InsuranceRepository extends JpaRepository<Insurance, Long> {
	
	

}
