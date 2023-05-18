package com.cms.claimmanagement.insuranceCompany.Claim.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClaimRepository extends JpaRepository<ClaimDetails, String> {
}
