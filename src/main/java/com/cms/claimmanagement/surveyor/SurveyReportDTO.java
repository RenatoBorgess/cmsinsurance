package com.cms.claimmanagement.surveyor;

public record SurveyReportDTO(String claimId, String policyNo,
                              Long labourCharges, Long partsCost, Long policyClass,
                              Long depreciationCost, Long totalAmount) {
}
