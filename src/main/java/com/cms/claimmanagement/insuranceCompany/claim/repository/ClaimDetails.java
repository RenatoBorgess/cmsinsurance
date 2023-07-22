package com.cms.claimmanagement.insuranceCompany.claim.repository;

import com.cms.claimmanagement.insuranceCompany.policy.Repository.PolicyEntity;
import com.cms.claimmanagement.insuranceCompany.surveyor.repository.Surveyor;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.time.LocalDate;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ClaimDetails {

    @Id
    @Size(min = 10, max = 10)
    private String claimId;
    @ManyToOne
    @Cascade(CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "policy_no")
    private PolicyEntity policy;
    @Min(value = 0L, message = "The value must be positive")
    private Long estimatedLoss;
    @Past
    private LocalDate dateOfAccident;
    private boolean claimStatus;

    @ManyToOne
    @JoinColumn(name = "surveyor_id")
    private Surveyor surveyor;
    @Min(value = 0L, message = "The value must be positive")
    private Long amtApprovedBySurveyor;
    @Builder.Default
    private boolean insuranceCompanyApproval = false;
    @Builder.Default
    private boolean withdrawClaim = false;
    private Long surveyorFees;
}


