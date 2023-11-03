package com.integrationtests.demo.service;

import com.integrationtests.demo.exception.ProductNotFound;
import com.integrationtests.demo.exception.TechnicalDetailsNotFound;
import com.integrationtests.demo.model.Product;
import com.integrationtests.demo.model.TechnicalDetails;
import com.integrationtests.demo.repository.TechnicalDetailRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
@Component
public class TechnicalDetailService {

    private final TechnicalDetailRepository technicalDetailRepository;


    public List<TechnicalDetails> findAllTechnicalDetails() {
        return technicalDetailRepository.findAll();
    }

    public TechnicalDetails findById(long id){
        return technicalDetailRepository.findById(id).orElseThrow(()-> new TechnicalDetailsNotFound("TechnicalDetails: " + id + " not found"));
    }

    public List<TechnicalDetails> findTechnicalDetailsByProductId(Long id){
        return technicalDetailRepository.findByProductId(id);
    }
}
