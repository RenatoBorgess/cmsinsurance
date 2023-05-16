package com.cms.claimmanagement.insuranceCompany.repository;

import com.cms.claimmanagement.surveyor.repository.Surveyor;

import java.time.LocalDate;

public record ClaimResponseData(PolicyEntity policy,
                                Long estimatedLoss,
                                LocalDate dateOfAccident,
                                boolean claimStatus,
                                Surveyor surveyor,
                                Long amtApprovedBySurveyor,
                                boolean insuranceCompanyApproval,
                                boolean withdrawClaim,
                                Long surveyorFees) {
     public ClaimResponseData(ClaimDetails claim){
         this(
                 claim.getPolicy(),
                 claim.getEstimatedLoss(),
                 claim.getDateOfAccident(),
                 claim.isClaimStatus(),
                 claim.getSurveyor(),
                 claim.getAmtApprovedBySurveyor(),
                 claim.isInsuranceCompanyApproval(),
                 claim.isWithdrawClaim(),
                 claim.getSurveyorFees());



     }


}
