package com.cms.claimmanagement.model;

import com.cms.claimmanagement.model.PolicyEntity;

public record PolicyDataResponse(String policyNo, String insuredFirstName) {

    public PolicyDataResponse(PolicyEntity policy) {
        this(policy.getPolicyNo(), policy.getInsuredFirstName());
    }
}
