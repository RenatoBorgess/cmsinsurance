package com.cms.claimmanagement.insuranceCompany.Claim.Controller;

import com.cms.claimmanagement.insuranceCompany.Claim.Repository.ClaimDetails;

public record ClaimResponseData(String claimId) {
     public ClaimResponseData(ClaimDetails claim){
         this(claim.getClaimId());



     }


}
