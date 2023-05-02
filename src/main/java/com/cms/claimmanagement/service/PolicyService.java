package com.cms.claimmanagement.service;

import com.cms.claimmanagement.controller.PolicyController;
import com.cms.claimmanagement.model.PolicyData;
import com.cms.claimmanagement.model.PolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.security.Policy;


public class PolicyService {

    @Autowired
    public PolicyController policyController;
    @Autowired
    public PolicyRepository policyRepository;

    public PolicyData savePolicy(PolicyData policyRe
