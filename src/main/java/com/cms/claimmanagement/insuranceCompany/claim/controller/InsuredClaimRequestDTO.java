package com.cms.claimmanagement.insuranceCompany.claim.controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InsuredClaimRequestDTO {
        private String policyNo;
        private Long estimatedLoss;
        private LocalDate dateOfAccident;
}
