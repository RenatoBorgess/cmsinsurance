package com.cms.claimmanagement.insuranceCompany.Claim.Service;

import com.cms.claimmanagement.insuranceCompany.Claim.Controller.ClaimRequestData;
import com.cms.claimmanagement.insuranceCompany.Claim.Controller.ClaimResponseData;
import com.cms.claimmanagement.insuranceCompany.Claim.Repository.ClaimDetails;
import com.cms.claimmanagement.insuranceCompany.Claim.Repository.ClaimRepository;
import com.cms.claimmanagement.insuranceCompany.ClaimRepository.*;
import com.cms.claimmanagement.insuranceCompany.Policy.Repository.PolicyEntity;
import com.cms.claimmanagement.insuranceCompany.Surveyor.Repository.Surveyor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

@Service
public class ClaimService {
    @Autowired
    ClaimRepository claimRepository;

    public String generateClaimId(String policyNo){
        String fourPolicyNumbers = policyNo.substring(2,6);
        DateFormat df = new SimpleDateFormat("yyyy");
        String fourDigitYear = df.format(Calendar.getInstance().getTime());

        return "CL"+fourPolicyNumbers+fourDigitYear;

    }
    public ClaimResponseData saveNewClaim(ClaimRequestData claimRequest) {
        ClaimDetails claim = new ClaimDetails();
        claim.setClaimId(generateClaimId(claimRequest.policyNo()));

        PolicyEntity policy = new PolicyEntity();
       policy.setPolicyNo(claimRequest.policyNo());
       claim.setPolicy(policy);

        Surveyor surveyor = new Surveyor();
        surveyor.setId(claimRequest.surveyorId());
        claim.setSurveyor(surveyor);


        claim.setDateOfAccident(claimRequest.dateOfAccident());
        claim.setAmtApprovedBySurveyor(claimRequest.amtApprovedBySurveyor());
        claim.setSurveyorFees(claimRequest.surveyorFees());
        claim.setEstimatedLoss(claimRequest.estimatedLoss());
        claim.setClaimStatus(claimRequest.claimStatus());
        claim.setWithdrawClaim(claimRequest.withdrawClaim());
        claimRepository.save(claim);
        ClaimResponseData claimId = new ClaimResponseData(claim.getClaimId());


        return claimId;
    }

    public List<ClaimResponseData> getAllClaims() {
        return claimRepository.findAll().stream().map((ClaimDetails claimId) -> new ClaimResponseData(claimId)).toList();
    }
}