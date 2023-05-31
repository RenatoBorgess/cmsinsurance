package com.cms.claimmanagement.insuranceCompany.policy.Controller;

import com.cms.claimmanagement.insuranceCompany.policy.Repository.PolicyEntity;

public record PolicyResponseData(String policyNo, String insuredFirstName) {

    public PolicyResponseData(PolicyEntity policy) {
        this(policy.getPolicyNo(), policy.getInsuredFirstName());
    }
}
