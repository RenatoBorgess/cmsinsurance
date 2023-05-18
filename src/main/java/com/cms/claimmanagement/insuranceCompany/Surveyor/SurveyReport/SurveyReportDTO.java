package com.cms.claimmanagement.insuranceCompany.Surveyor.SurveyReport;

public record SurveyReportDTO(String claimId, String policyNo,
                              Long labourCharges, Long partsCost, Long policyClass,
                              Long depreciationCost, Long totalAmount) {
}
