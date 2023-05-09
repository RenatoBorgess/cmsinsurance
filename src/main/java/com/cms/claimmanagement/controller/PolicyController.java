package com.cms.claimmanagement.controller;

import com.cms.claimmanagement.repository.PolicyData;
import com.cms.claimmanagement.repository.PolicyDataResponse;
import com.cms.claimmanagement.repository.PolicyEntity;
import com.cms.claimmanagement.service.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PolicyController {
    @Autowired
    PolicyService policyService;

    @PostMapping(path = "/new", consumes = {"application/json"})
    public PolicyEntity createPolicy(@RequestBody PolicyData policyReq) {
        return policyService.savePolicy(policyReq);
    }

    @GetMapping(path = "/all")
    public List<PolicyDataResponse> listPolicies() {
        return policyService.listPolicies();
    }
}

