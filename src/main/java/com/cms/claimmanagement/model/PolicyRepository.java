package com.cms.claimmanagement.model;

import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface PolicyRepository extends JpaRepository<PolicyEntity, Long> {

}