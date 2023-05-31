package com.cms.claimmanagement.insuranceCompany.policy.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PolicyRepository extends JpaRepository<PolicyEntity, Long> {



    Optional findByPolicyNo(String s);
}
