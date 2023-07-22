package com.cms.claimmanagement.insuranceCompany.surveyor.surveyReport.controller;

import com.cms.claimmanagement.insuranceCompany.surveyor.surveyReport.repository.SurveyReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurveyReportRepository extends JpaRepository<SurveyReport, String> {
}
