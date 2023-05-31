package com.cms.claimmanagement.insuranceCompany.claim.service;

import com.cms.claimmanagement.insuranceCompany.claim.controller.insuredClaimRequestDTO;
import com.cms.claimmanagement.insuranceCompany.claim.controller.ClaimResponseData;
import com.cms.claimmanagement.insuranceCompany.claim.controller.ClaimUpdateData;
import com.cms.claimmanagement.insuranceCompany.claim.repository.ClaimDetails;
import com.cms.claimmanagement.insuranceCompany.claim.repository.ClaimRepository;
import com.cms.claimmanagement.insuranceCompany.policy.Repository.PolicyEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ClaimService {
    @Autowired
    ClaimRepository claimRepository;

    public String generateClaimId(String policyNo) {
        String fourPolicyNumbers = policyNo.substring(2, 6);
        DateFormat df = new SimpleDateFormat("yyyy");
        String fourDigitYear = df.format(Calendar.getInstance().getTime());

        return "CL" + fourPolicyNumbers + fourDigitYear;

    }

    public ClaimResponseData saveNewClaim(insuredClaimRequestDTO claimRequest) {
        ClaimDetails claim = new ClaimDetails();
        claim.setClaimId(generateClaimId(claimRequest.getPolicyNo()));

        PolicyEntity policy = new PolicyEntity();
        policy.setPolicyNo(claimRequest.getPolicyNo());

        claim.setPolicy(policy);


        claim.setDateOfAccident(claimRequest.getDateOfAccident());
        claim.setEstimatedLoss(claimRequest.getEstimatedLoss());

        ClaimDetails savedClaim = claimRepository.save(claim);
        ClaimResponseData claimId = new ClaimResponseData();
        claimId.setClaimId(savedClaim.getClaimId());


        return claimId;
    }

    public List<ClaimResponseData> getAllOpenClaims() {

        return claimRepository
                .findAll()
                .stream()
                .filter(ClaimDetails::isClaimStatus)
                .map(ClaimDetails::getClaimId)
                .map(claimResponse -> new ClaimResponseData())
                .toList();
    }

    public ClaimUpdateData updateClaim(ClaimUpdateData updateData) throws NoSuchElementException {
        ClaimDetails existingClaim = claimRepository.getReferenceById(updateData.claimId());
        existingClaim.setClaimStatus(updateData.claimStatus());
        existingClaim.setInsuranceCompanyApproval(updateData.insuranceCompanyApproval());

        ClaimDetails updatedClaim = claimRepository.save(existingClaim);

        ClaimUpdateData claimUpdateDataResponse = new ClaimUpdateData(
                updatedClaim.getClaimId(),
                updatedClaim.isClaimStatus(),
                updatedClaim.isInsuranceCompanyApproval());
        return claimUpdateDataResponse;
    }
}
