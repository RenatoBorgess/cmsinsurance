package com.cms.claimmanagement.insuranceCompany.Claim.Controller;

import java.time.LocalDate;

public record ClaimRequestData(
        String policyNo,
        Long estimatedLoss,
        LocalDate dateOfAccident,
        boolean claimStatus,
        Long surveyorId,
        Long amtApprovedBySurveyor,
        boolean insuranceCompanyApproval,
        boolean withdrawClaim,
        Long surveyorFees) {
}
