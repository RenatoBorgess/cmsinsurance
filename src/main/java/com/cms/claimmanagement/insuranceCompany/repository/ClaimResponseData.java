package com.cms.claimmanagement.insuranceCompany.repository;

import com.cms.claimmanagement.surveyor.repository.Surveyor;

import java.time.LocalDate;

public record ClaimResponseData(String claimId) {
     public ClaimResponseData(ClaimDetails claim){
         this(claim.getClaimId());


     }


}
