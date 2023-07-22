package com.cms.claimmanagement.insuranceCompany.claim.controller;

import com.cms.claimmanagement.insuranceCompany.claim.service.ClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/claims")
public class ClaimController {
    @Autowired
    ClaimService claimService;

    @GetMapping
    public ResponseEntity<List<ClaimResponseDTO>> getOpenClaims(){
        List<ClaimResponseDTO> listOfOpenClaims = claimService.getAllOpenClaims();
       return ResponseEntity.ok().body(listOfOpenClaims);

    }

    @PostMapping( consumes = {"application/json"})
    public ResponseEntity<ClaimResponseDTO> createNewClaim(@RequestBody InsuredClaimRequestDTO claimRequest){
         ClaimResponseDTO savedClaim = claimService.saveNewClaim(claimRequest);
         return ResponseEntity.ok().body(savedClaim);
    }
    @PutMapping( consumes = {"application/json"})
    public ResponseEntity<ClaimUpdateDTO> updateClaim(@RequestParam String claimId, @RequestBody ClaimUpdateDTO updateData){
        ClaimUpdateDTO updatedClaim = claimService.updateClaim(updateData);
        return ResponseEntity.ok().body(updatedClaim);
    }


}
