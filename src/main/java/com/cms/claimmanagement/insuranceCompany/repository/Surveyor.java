package com.cms.claimmanagement.insuranceCompany.repository;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;

@Entity
public class Surveyor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long surveyorId;

    String firstName;
    String lastName;
    @Min(value = 0L, message = "The value must be positive")
    Long estimateLimit;
}
