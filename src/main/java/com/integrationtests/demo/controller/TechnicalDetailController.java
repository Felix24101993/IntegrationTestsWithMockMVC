package com.integrationtests.demo.controller;

import com.integrationtests.demo.model.TechnicalDetails;
import com.integrationtests.demo.service.TechnicalDetailService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RequestMapping("/technical-details")
@RestController
public class TechnicalDetailController {



    private final TechnicalDetailService technicalDetailService;

    @GetMapping
    public List<TechnicalDetails> findAllTechnicalDetails(){
        return technicalDetailService.findAllTechnicalDetails();
    }

    @GetMapping("/{id}")
    public TechnicalDetails findById(@PathVariable long id){
        return technicalDetailService.findById(id);
    }

    @GetMapping("/products/{id}")
    public List<TechnicalDetails> findTechnicalDetailsByProductId(@PathVariable Long id){
        return technicalDetailService.findTechnicalDetailsByProductId(id);
    }
}
