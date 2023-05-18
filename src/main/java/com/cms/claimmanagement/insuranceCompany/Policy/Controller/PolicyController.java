package com.cms.claimmanagement.insuranceCompany.Policy.Controller;


import com.cms.claimmanagement.insuranceCompany.Policy.Service.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/policy")
public class PolicyController {
    @Autowired
    PolicyService policyService;

    @PostMapping(path = "/new", consumes = {"application/json"})
    public PolicyResponseData createPolicy(@RequestBody PolicyRequestData policyReq) {
        return policyService.savePolicy(policyReq);
    }

    @GetMapping(path = "/all")
    public List<PolicyResponseData> listPolicies() {

        return policyService.listPolicies();
    }
}

