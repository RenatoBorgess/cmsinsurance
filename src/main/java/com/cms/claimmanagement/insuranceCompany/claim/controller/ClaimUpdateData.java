package com.cms.claimmanagement.insuranceCompany.claim.controller;

public record ClaimUpdateData(String claimId, boolean claimStatus, boolean insuranceCompanyApproval) {

}
