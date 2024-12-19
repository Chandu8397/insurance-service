package com.coforge.training.agribid.insurance.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coforge.training.agribid.insurance.model.Insurance;
import com.coforge.training.agribid.insurance.service.InsuranceService;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/insurance-service/api")
public class InsuranceController {

	@Autowired
	private InsuranceService insuranceService;


	
	
	@PostMapping("/apply")
    public ResponseEntity<Insurance> applyInsurance(@RequestBody Insurance insurance) {
        double premiumRate;
        if ("Kharif".equalsIgnoreCase(insurance.getSeason())) {
            premiumRate = 0.02;
        } else if ("Rabi".equalsIgnoreCase(insurance.getSeason())) {
            premiumRate = 0.015;
        } else {
            premiumRate = 0.05;
        }
        insurance.setPremiumRate(premiumRate);
        insurance.setPremiumAmount(insurance.getSumInsured() * premiumRate);
        Insurance savedInsurance = insuranceService.applyInsurance(insurance);
        return ResponseEntity.ok(savedInsurance);
    }

	
	
	@GetMapping("/insurance/{id}")
	public ResponseEntity<?> getInsurance(@PathVariable Long id) {
	    try {
	        Optional<Insurance> insurance = insuranceService.getInsuranceById(id);
	        if (insurance != null) {
	            return ResponseEntity.ok(insurance);
	        } else {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Insurance not found.");
	        }
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while fetching the insurance.");
	    }
	}
	
//	@GetMapping("/details/{id}")
//	public ResponseEntity<?> getInsuranceDetails(@PathVariable Long id) {
//	    try {
//	        Insurance insurance = insuranceService.getInsuranceDetails(id);
//	        return ResponseEntity.ok(insurance);
//	    } catch (Exception e) {
//	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while fetching the insurance details.");
//	    }
//	}
	
//	@PostMapping("/save")
//	public ResponseEntity<?> applyInsurance(@RequestBody Insurance insurance) {
//		try {
//			Insurance applyInsurance = insuranceService.applyInsurance(insurance);
//			return ResponseEntity.ok(applyInsurance);
//		} catch (Exception e) {
//			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while saving the insurance.");
//		}
//	}
//	
//  
	
}



