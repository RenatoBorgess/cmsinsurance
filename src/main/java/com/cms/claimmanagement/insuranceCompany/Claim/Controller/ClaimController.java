package com.cms.claimmanagement.insuranceCompany.Claim.Controller;

import com.cms.claimmanagement.insuranceCompany.Claim.Service.ClaimService;
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
    public ResponseEntity<List<ClaimResponseData>> getOpenClaims(){
        List<ClaimResponseData> listOfOpenClaims = claimService.getAllOpenClaims();
       return ResponseEntity.ok().body(listOfOpenClaims);

    }

    @PostMapping(path = "/new")
    public ResponseEntity<ClaimResponseData> createNewClaim(@RequestBody ClaimRequestData claimRequest){
         ClaimResponseData savedClaim = claimService.saveNewClaim(claimRequest);
         return ResponseEntity.ok().body(savedClaim);
    }
    @PutMapping(path = "/{claimId}/update")
    public ResponseEntity<ClaimUpdateData> updateClaim(@PathVariable("claimId") String claimId, @RequestBody ClaimUpdateData updateData){
        ClaimUpdateData updatedClaim = claimService.updatedClaim(updateData);
        return ResponseEntity.ok().body(updatedClaim);
    }


}
