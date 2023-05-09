package com.cms.claimmanagement.repository;

public record PolicyDataResponse(String policyNo, String insuredFirstName) {

    public PolicyDataResponse(PolicyEntity policy) {
        this(policy.getPolicyNo(), policy.getInsuredFirstName());
    }
}
