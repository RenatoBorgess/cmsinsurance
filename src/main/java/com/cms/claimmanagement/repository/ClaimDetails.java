package com.cms.claimmanagement.repository;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Entity
public class ClaimDetails {
    @Id
    @Size(min = 10, max = 10)
    private Long claimId;
    //many-to-one
    private String policyNo;
    @Min(value = 0L, message = "The value must be positive")
    private Long estimatedLoss;
    @Past
    private LocalDate dateOfAccident;
    private boolean claimStatus;
    //relation many-to-one
    private Long SurveyorId;
    @Min(value = 0L, message = "The value must be positive")
    private Long amtApprovedBySurveyor;
    private boolean insuranceCompanyApproval = false;
    private boolean withdrawClaim = false;
    private Long surveyorFees;


}
