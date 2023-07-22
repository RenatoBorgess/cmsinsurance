package com.cms.claimmanagement.insuranceCompany.surveyor.surveyReport.controller;

import com.cms.claimmanagement.insuranceCompany.surveyor.surveyReport.repository.SurveyReport;
import com.cms.claimmanagement.insuranceCompany.surveyor.surveyReport.SurveyReportDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SurveyReportService {
    private final ModelMapper mapper = new ModelMapper();
    private final SurveyReportRepository surveyReportRepository;
    @Autowired
    public SurveyReportService(SurveyReportRepository surveyReportRepository){
        this.surveyReportRepository = surveyReportRepository;
    }
    public String saveReport(SurveyReportDTO surveyReportDTO) throws IllegalArgumentException{
        SurveyReport newReport = mapper.map(surveyReportDTO, SurveyReport.class);

        SurveyReport savedReport = surveyReportRepository.save(newReport);

        return "Sucesso";
    }

    public ResponseEntity<SurveyReportDTO> getReportById(String claimId) {
        Optional<SurveyReport> surveyReportOptional = surveyReportRepository.findById(claimId);
        if(surveyReportOptional.isEmpty()){
            return ResponseEntity.notFound().build();
        } else {
           SurveyReport foundReport = surveyReportOptional.get();
           SurveyReportDTO surveyReportDTO = mapper.map(foundReport, SurveyReportDTO.class);
           return ResponseEntity.ok(surveyReportDTO);
        }
    }
}
