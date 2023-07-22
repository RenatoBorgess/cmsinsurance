package com.cms.claimmanagement.insuranceCompany.surveyor.surveyReport.repository;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class SurveyReport {

    @Id
    private String claimId;
    private String policyNo;
    private Long labourCharges, partsCost, policyClass, depreciationCost, totalamount;
}
