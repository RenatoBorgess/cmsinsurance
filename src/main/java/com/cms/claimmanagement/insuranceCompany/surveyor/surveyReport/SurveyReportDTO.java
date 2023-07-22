package com.cms.claimmanagement.insuranceCompany.surveyor.surveyReport;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SurveyReportDTO {
    private String claimId;
    private String policyNo;
    private Long labourCharges, partsCost, policyClass, depreciationCost, totalamount;
}