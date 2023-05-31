package com.cms.claimmanagement.insuranceCompany.surveyor.controller;


import com.cms.claimmanagement.insuranceCompany.surveyor.service.SurveyorService;
import com.cms.claimmanagement.insuranceCompany.surveyor.surveyReport.SurveyReportDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SurveyorController {
    @Autowired
    public SurveyorService surveyorService;

    @GetMapping(path = "/surveyors/{estimatedLoss}")
    public List<SurveyorResponseData> getSurveyorsByEstimateLimit(@PathVariable ("estimatedLoss") Integer estimatedLoss) {
        return surveyorService.getAllSurveyorsBelowTheLimit(estimatedLoss);

    }

    @PostMapping(path = "/new")
    public ResponseEntity createSurvey(SurveyReportDTO survey) {
        ResponseEntity responseEntity = new ResponseEntity(HttpStatusCode.valueOf(200));
        return responseEntity;
    }
}


