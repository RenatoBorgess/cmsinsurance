package com.cms.claimmanagement.insuranceCompany.Policy.Controller;

import com.cms.claimmanagement.insuranceCompany.Policy.Repository.PolicyEntity;

public record PolicyResponseData(String policyNo, String insuredFirstName) {

    public PolicyResponseData(PolicyEntity policy) {
        this(policy.getPolicyNo(), policy.getInsuredFirstName());
    }
}
