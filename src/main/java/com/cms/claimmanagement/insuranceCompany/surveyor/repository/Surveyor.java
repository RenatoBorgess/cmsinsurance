package com.cms.claimmanagement.insuranceCompany.surveyor.repository;

import com.cms.claimmanagement.insuranceCompany.claim.repository.ClaimDetails;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
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

}