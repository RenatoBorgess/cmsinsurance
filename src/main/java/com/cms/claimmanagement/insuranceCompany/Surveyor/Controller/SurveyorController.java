package com.cms.claimmanagement.insuranceCompany.Surveyor.Controller;


import com.cms.claimmanagement.insuranceCompany.Surveyor.Service.SurveyorService;
import com.cms.claimmanagement.insuranceCompany.Surveyor.SurveyReport.SurveyReportDTO;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


public class SurveyorController {

    public SurveyorService surveyorService;

    @PostMapping(path = "/new")
    public ResponseEntity createSurvey(SurveyReportDTO survey) {
        ResponseEntity responseEntity = new ResponseEntity(HttpStatusCode.valueOf(200));
        return responseEntity;
    }

    @GetMapping
    public String getSurveyorByClaimId(Long claimId) {
        return surveyorService.getSurveyorById(claimId);
    }
}


