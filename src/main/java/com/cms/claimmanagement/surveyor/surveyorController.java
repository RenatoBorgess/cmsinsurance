package com.cms.claimmanagement.surveyor;


import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController("api/surveyor")
public class surveyorController {

    public SurveyorService surveyorService;

    @PostMapping(path = "/new")
    public ResponseEntity createSurvey(SurveyReportDTO survey) {
        ResponseEntity responseEntity = new ResponseEntity(HttpStatusCode.valueOf(200));
        return responseEntity;
    }

    @GetMapping
    public String getSurveyorByClaimId(String claimId) {
        return surveyorService.getSurveyorById(claimId);
    }
}


