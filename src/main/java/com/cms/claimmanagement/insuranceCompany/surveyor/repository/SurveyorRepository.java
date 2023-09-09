package com.cms.claimmanagement.insuranceCompany.surveyor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SurveyorRepository extends JpaRepository<Surveyor, Long> {
    List<Surveyor> findAllByOrderByEstimateLimitAsc();
}
