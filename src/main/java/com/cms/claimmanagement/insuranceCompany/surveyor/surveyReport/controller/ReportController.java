package com.cms.claimmanagement.insuranceCompany.surveyor.surveyReport.controller;

import com.cms.claimmanagement.insuranceCompany.surveyor.surveyReport.SurveyReportDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/surveyReports")
public class ReportController {

    private final SurveyReportService surveyReportService;
    @Autowired
    public ReportController(SurveyReportService surveyReportService) {
        this.surveyReportService = surveyReportService;
    }
    @PostMapping( consumes = {"application/json"})
    public String saveReport(final @RequestBody SurveyReportDTO surveyReportDTO){
        return surveyReportService.saveReport(surveyReportDTO);
    }
    @GetMapping(path = "/{claimId}")
    public ResponseEntity<SurveyReportDTO> getReportById(@PathVariable String claimId){

        return surveyReportService.getReportById(claimId);
    }


}


