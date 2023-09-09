package com.cms.claimmanagement.insuranceCompany.claim.controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClaimUpdateDTO {

    private String claimId;
    private boolean isOpen;
    private boolean amountApproved;

}
