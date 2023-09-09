package com.cms.claimmanagement.insuranceCompany.claim.service;

import com.cms.claimmanagement.insuranceCompany.claim.controller.ClaimResponseDTO;
import com.cms.claimmanagement.insuranceCompany.claim.controller.ClaimUpdateDTO;
import com.cms.claimmanagement.insuranceCompany.claim.controller.InsuredClaimRequestDTO;
import com.cms.claimmanagement.insuranceCompany.claim.repository.ClaimDetails;
import com.cms.claimmanagement.insuranceCompany.claim.repository.ClaimRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ClaimService {
    private final String claimPrefix = "CL";
    public final ModelMapper modelMapper = new ModelMapper();

    @Autowired
    ClaimRepository claimRepository;

    public String generateClaimId(String policyNo) {
        String fourPolicyNumbers = policyNo.substring(2, 6);
        DateFormat df = new SimpleDateFormat("yyyy");
        String fourDigitYear = df.format(Calendar.getInstance().getTime());

        return claimPrefix + fourPolicyNumbers + fourDigitYear;

    }

    public ClaimResponseDTO saveNewClaim(InsuredClaimRequestDTO claimRequest) {

        ClaimDetails claim = modelMapper.map(claimRequest, ClaimDetails.class);

        ClaimDetails savedClaim = claimRepository.save(claim);
        ClaimResponseDTO claimId = modelMapper.map(savedClaim, ClaimResponseDTO.class);


        return claimId;
    }

    public List<ClaimResponseDTO> getAllOpenClaims() {

        return claimRepository
                .findAll()
                .stream()
                .filter(ClaimDetails::isClaimStatus)
                .map(ClaimDetails::getClaimId)
                .map(claimResponse -> new ClaimResponseDTO())
                .toList();
    }

    public ClaimUpdateDTO updateClaim(final ClaimUpdateDTO updateData) throws NoSuchElementException {

        ClaimDetails existingClaim = claimRepository.getReferenceById(updateData.getClaimId());
        existingClaim.setClaimStatus(updateData.isOpen());
        existingClaim.setInsuranceCompanyApproval(updateData.isAmountApproved());

        ClaimDetails updatedClaim = claimRepository.save(existingClaim);


        ClaimUpdateDTO claimUpdateDataResponse = modelMapper.map(updatedClaim, ClaimUpdateDTO.class);

        return claimUpdateDataResponse;
    }
}
