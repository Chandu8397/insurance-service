package com.coforge.training.agribid.insurance.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.coforge.training.agribid.insurance.exception.InsuranceNotFoundException;
import com.coforge.training.agribid.insurance.model.Insurance;
import com.coforge.training.agribid.insurance.repository.InsuranceRepository;

@Service
public class InsuranceService {

    @Autowired
    private InsuranceRepository irepo;
    
    public Insurance applyInsurance(Insurance i) {
    	return irepo.save(i);
    }
    
    public Optional<Insurance> getInsuranceById(Long id) {
        return irepo.findById(id);
    }
    
//    public Insurance getInsuranceDetails(Long id) {
//        CrudRepository<Insurance, Long> insuranceRepository = null;
//		Optional<Insurance> insuranceOptional = insuranceRepository.findById(id);
//        if (insuranceOptional.isPresent()) {
//            return insuranceOptional.get();
//        } else {
//            throw new InsuranceNotFoundException("Insurance with ID " + id + " not found");
//        }
//    }

  
}

    
    
   
   
    

