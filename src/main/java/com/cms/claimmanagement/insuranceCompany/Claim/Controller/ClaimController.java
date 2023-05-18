package com.cms.claimmanagement.insuranceCompany.Claim.Controller;

import com.cms.claimmanagement.insuranceCompany.Claim.Service.ClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/claims")
public class ClaimController {
    @Autowired
    ClaimService claimService;

    @GetMapping
    public List<ClaimResponseData> getAllClaims(){
       return claimService.getAllClaims();

    }

    @PostMapping(path = "/new")
    public ClaimResponseData createNewClaim(@RequestBody ClaimRequestData claimRequest){


        return claimService.saveNewClaim(claimRequest) ;
    }
}
