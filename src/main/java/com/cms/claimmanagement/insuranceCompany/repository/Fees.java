package com.cms.claimmanagement.insuranceCompany.repository;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;

@Entity
public class Fees {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long feeId;
    private Double estimateStartLimit;
    @Min(value = 0L, message = "The value must be positive")
    private Double estimateEndLimit;
    private Double fees;


}
