package com.cms.claimmanagement.insuranceCompany.fees;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
public class Fees {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long feeId;
    @NotNull
    private Double estimateStartLimit;
    @Min(value = 0L, message = "The value must be positive")
    private Double estimateEndLimit;
    private Double fees;

    public Long getFeeId() {
        return feeId;
    }

    public void setFeeId(Long feeId) {
        this.feeId = feeId;
    }

    public Double getEstimateStartLimit() {
        return estimateStartLimit;
    }

    public void setEstimateStartLimit(Double estimateStartLimit) {
        this.estimateStartLimit = estimateStartLimit;
    }

    public Double getEstimateEndLimit() {
        return estimateEndLimit;
    }

    public void setEstimateEndLimit(Double estimateEndLimit) {
        this.estimateEndLimit = estimateEndLimit;
    }

    public Double getFees() {
        return fees;
    }

    public void setFees(Double fees) {
        this.fees = fees;
    }
}
