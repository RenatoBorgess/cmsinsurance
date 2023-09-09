package com.cms.claimmanagement.insuranceCompany.policy.Controller;


import com.cms.claimmanagement.insuranceCompany.policy.Service.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/policies")
public class PolicyController {
    @Autowired
    PolicyService policyService;

    @PostMapping
    public PolicyResponseDTO createPolicy(@RequestBody PolicyRequestDTO policyReq) {
        return policyService.savePolicy(policyReq);
    }

    @GetMapping
    public List<PolicyResponseDTO> listPolicies() {

        return policyService.listPolicies();
    }
}

