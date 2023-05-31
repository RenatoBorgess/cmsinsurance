package com.cms.claimmanagement.insuranceCompany.surveyor.repository;

import com.cms.claimmanagement.insuranceCompany.claim.repository.ClaimDetails;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;

import java.util.List;

@Entity
public class Surveyor {

    @Column(name = "surveyor_id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany(mappedBy = "surveyor")
    private List<ClaimDetails> claimDetails;
    private String firstName;
    private String lastName;
    @Min(value = 0L, message = "The value must be positive")
    Long estimateLimit;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<ClaimDetails> getClaimDetails() {
        return claimDetails;
    }

    public void setClaimDetails(List<ClaimDetails> claimDetails) {
        this.claimDetails = claimDetails;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getEstimateLimit() {
        return estimateLimit;
    }

    public void setEstimateLimit(Long estimateLimit) {
        this.estimateLimit = estimateLimit;
    }
}
