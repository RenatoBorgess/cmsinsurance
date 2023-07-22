package com.cms.claimmanagement.insuranceCompany.claim.service;

import com.cms.claimmanagement.insuranceCompany.claim.controller.ClaimResponseDTO;
import com.cms.claimmanagement.insuranceCompany.claim.repository.ClaimDetails;
import com.cms.claimmanagement.insuranceCompany.claim.repository.ClaimRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ClaimServiceTest {

    @Mock
    private ClaimRepository claimRepository;

    @InjectMocks
    private ClaimService claimService;

    @Test
    void shouldGenerateClaimIdStartingWithCL(){
        //given
        String policyNo = "fdazsdfasdfasd";
        //when
        String claimId = claimService.generateClaimId(policyNo);

        //shouldGenerateClaimIdStartingWithCL
        Assertions.assertThat(claimId).startsWith("CL");

    }

    @Test
    void shouldHaveVehicleNumberAfterDefaultPrefix(){
        //given
        String policyNo = "TE999923";
        //when
        String claimId = claimService.generateClaimId(policyNo);

        //shouldHaveVehicleNumberAfterDefaultPrefix
        Assertions.assertThat(claimId.substring(2, 6)).isEqualTo("9999");

    }

    @Test
    void shoudlHaveCurrentYearAsSuffix(){
        //given
        String policyNo = "axwexfwexfwexfwexfwefxwefxwe";
        //when
        String claimId = claimService.generateClaimId(policyNo);

        //shoudlHaveCurrentYearAsSuffix
        DateFormat df = new SimpleDateFormat("yyyy");
        String fourDigitYear = df.format(Calendar.getInstance().getTime());

        Assertions.assertThat(claimId.substring(6, 10)).isEqualTo(fourDigitYear);

    }

    @Test
    void shouldGetAllOpenClaims(){
        //given
        ClaimDetails claimDetails1 = new ClaimDetails();
        claimDetails1.setClaimStatus(true);

        ClaimDetails claimDetails2 = new ClaimDetails();
        claimDetails2.setClaimStatus(false);

        Mockito.when(claimRepository.findAll()).thenReturn(List.of(claimDetails1, claimDetails2));

        //when
        List<ClaimResponseDTO> claimResponseDataList = claimService.getAllOpenClaims();

        //then
        Assertions.assertThat(claimResponseDataList).isNotEmpty();
        Assertions.assertThat(claimResponseDataList.size()).isEqualTo(1);

    }
    @Test
    void shouldSaveClaim(){
        //given
        //ClaimRequestData claimRequestData = new ClaimRequestData(fksjdfjdk);
        //when
        //ClaimResponseData claimResponseData = claimService.saveNewClaim();
        //then
    }

}
