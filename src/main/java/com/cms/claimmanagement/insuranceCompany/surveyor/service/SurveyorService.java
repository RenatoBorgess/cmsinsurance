package com.cms.claimmanagement.insuranceCompany.surveyor.service;


import com.cms.claimmanagement.insuranceCompany.surveyor.controller.SurveyorResponseData;
import com.cms.claimmanagement.insuranceCompany.surveyor.repository.SurveyorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SurveyorService {
    @Autowired
    public SurveyorRepository surveyorRepository;

    public List<SurveyorResponseData> getAllSurveyorsBelowTheLimit(Integer estimatedLoss) {


        return surveyorRepository
                .findAll()
                .stream()
                .filter(surveyor -> surveyor.getEstimateLimit() < estimatedLoss)
                .map(surveyor -> new SurveyorResponseData(
                        surveyor.getId(),
                        surveyor.getFirstName(),
                        surveyor.getLastName(),
                        surveyor.getEstimateLimit())).toList();

    }
}

