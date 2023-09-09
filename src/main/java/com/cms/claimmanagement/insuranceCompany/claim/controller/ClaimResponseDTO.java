package com.cms.claimmanagement.insuranceCompany.claim.controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class ClaimResponseDTO {
   private String claimId;
}
