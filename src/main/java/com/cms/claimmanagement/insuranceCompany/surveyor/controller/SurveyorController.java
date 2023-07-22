package com.cms.claimmanagement.insuranceCompany.surveyor.controller;


import com.cms.claimmanagement.insuranceCompany.surveyor.service.SurveyorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/v1/surveyors")
public class SurveyorController {
    @Autowired
    public SurveyorService surveyorService;


    @GetMapping(path = "/{estimatedLoss}")
    public List<SurveyorResponseDTO> getSurveyorsByEstimateLimit(Integer estimatedLoss) {
        return surveyorService.getAllSurveyorsBelowTheLimit(estimatedLoss);

    }

}



