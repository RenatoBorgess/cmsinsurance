package com.cms.claimmanagement.insuranceCompany.surveyor.service;


import com.cms.claimmanagement.insuranceCompany.surveyor.controller.SurveyorResponseDTO;
import com.cms.claimmanagement.insuranceCompany.surveyor.repository.SurveyorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SurveyorService {

    private final SurveyorRepository surveyorRepository;
    @Autowired
    public SurveyorService(SurveyorRepository repository) {
        this.surveyorRepository = repository;

    }

    public List<SurveyorResponseDTO> getAllSurveyors() {

        return surveyorRepository
                .findAll()
                .stream()
                .map(surveyor -> new SurveyorResponseDTO(
                        surveyor.getId(),
                        surveyor.getFirstName(),
                        surveyor.getLastName(),
                        surveyor.getEstimateLimit()
                )).toList();
    }

    public List<SurveyorResponseDTO> getAllSurveyorsBelowTheLimit(Integer estimatedLoss) {

        return getAllSurveyors()
                .stream()
                .filter(surveyorResponseData -> surveyorResponseData.estimateLimit() > estimatedLoss)
                .toList();

    }
}

