package com.cms.claimmanagement.insuranceCompany.controller;

import com.cms.claimmanagement.insuranceCompany.repository.ClaimDetails;
import com.cms.claimmanagement.insuranceCompany.repository.ClaimRepository;
import com.cms.claimmanagement.insuranceCompany.repository.ClaimResponseData;
import com.cms.claimmanagement.insuranceCompany.service.ClaimService;
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
    public String createNewClaim(@RequestBody ClaimRequestData claimRequest){


        return claimService.saveNewClaim(claimRequest) ;
    }
}
