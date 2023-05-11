package com.cms.claimmanagement.insuranceCompany.repository;

import com.cms.claimmanagement.surveyor.repository.Surveyor;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Entity
public class ClaimDetails {

    @Id
    @Size(min = 10, max = 10)
    private String claimId;

    public String getClaimId() {
        return claimId;
    }

    public void setClaimId(String claimId) {
        this.claimId = claimId;
    }

    public PolicyEntity getPolicy() {
        return policy;
    }

    public void setPolicy(PolicyEntity policy) {
        this.policy = policy;
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

    public void setDateOfAccident(LocalDate dateOfAccident) {
        this.dateOfAccident = dateOfAccident;
    }

    public boolean isClaimStatus() {
        return claimStatus;
    }

    public void setClaimStatus(boolean claimStatus) {
        this.claimStatus = claimStatus;
    }

    public Surveyor getSurveyor() {
        return surveyor;
    }

    public void setSurveyor(Surveyor surveyor) {
        this.surveyor = surveyor;
    }

    public Long getAmtApprovedBySurveyor() {
        return amtApprovedBySurveyor;
    }

    public void setAmtApprovedBySurveyor(Long amtApprovedBySurveyor) {
        this.amtApprovedBySurveyor = amtApprovedBySurveyor;
    }

    public boolean isInsuranceCompanyApproval() {
        return insuranceCompanyApproval;
    }

    public void setInsuranceCompanyApproval(boolean insuranceCompanyApproval) {
        this.insuranceCompanyApproval = insuranceCompanyApproval;
    }

    public boolean isWithdrawClaim() {
        return withdrawClaim;
    }

    public void setWithdrawClaim(boolean withdrawClaim) {
        this.withdrawClaim = withdrawClaim;
    }

    public Long getSurveyorFees() {
        return surveyorFees;
    }

    public void setSurveyorFees(Long surveyorFees) {
        this.surveyorFees = surveyorFees;
    }

    @ManyToOne
    @JoinColumn(name = "policy_no", nullable = false)
    private PolicyEntity policy;
    @Min(value = 0L, message = "The value must be positive")
    private Long estimatedLoss;
    @Past
    private LocalDate dateOfAccident;
    private boolean claimStatus;

    @ManyToOne
    @JoinColumn(name = "surveyor_id", nullable = false)
    private Surveyor surveyor;
    @Min(value = 0L, message = "The value must be positive")
    private Long amtApprovedBySurveyor;
    private boolean insuranceCompanyApproval = false;
    private boolean withdrawClaim = false;
    private Long surveyorFees;


}
