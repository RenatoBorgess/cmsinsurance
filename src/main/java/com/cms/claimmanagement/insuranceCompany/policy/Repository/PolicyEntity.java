package com.cms.claimmanagement.insuranceCompany.policy.Repository;

import com.cms.claimmanagement.insuranceCompany.claim.repository.ClaimDetails;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "policy_entity")
@Entity(name = "Policy_Entity")
public class PolicyEntity {


    @Column(name = "policy_no")
    @Id
    private String policyNo;
    @OneToMany(mappedBy = "policy", cascade = CascadeType.ALL)
    private List<ClaimDetails> claimDetails;

    @Size(min = 5)
    private String insuredFirstName;
    private String insuredLastName;
    @UpdateTimestamp
    private LocalDate dateOfInsurance;

    private String emailId;
    private String vehicleNo;
    private boolean status;
}


