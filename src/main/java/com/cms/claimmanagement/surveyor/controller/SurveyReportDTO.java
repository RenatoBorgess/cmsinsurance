package com.cms.claimmanagement.surveyor.controller;

public record SurveyReportDTO(String claimId, String policyNo,
                              Long labourCharges, Long partsCost, Long policyClass,
                              Long depreciationCost, Long totalAmount) {
}
