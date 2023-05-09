package com.cms.claimmanagement.service;


import com.cms.claimmanagement.repository.SurveyorRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class SurveyorService {
    @Autowired
    public SurveyorRepository surveyorRepository;

    public String getSurveyorById(String claimId) {

        Optional surveyorOpt = surveyorRepository.findById(claimId);
        boolean surveyorExists = surveyorOpt.isPresent();
        if (!surveyorExists) {
            return "surveyor does not exists";
        }

        return "There's a surveyor";
    }
}
