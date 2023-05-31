package com.cms.claimmanagement.insuranceCompany.claim.controller;

import java.time.LocalDate;

public class insuredClaimRequestData {
        private String policyNo;
        private Long estimatedLoss;
        private LocalDate dateOfAccident;

        public String getPolicyNo() {
                return policyNo;
        }
        public void setPolicyNo(){
                this.policyNo = policyNo;

        }

        public Long getEstimatedLoss() {
                return estimatedLoss;
        }

        public void setEstimatedLoss(Long estimatedLoss) {
                this.estimatedLoss = estimatedLoss;
        }

        public LocalDate getDateOfAccident() {
                return dateOfAccident;
        }
}
