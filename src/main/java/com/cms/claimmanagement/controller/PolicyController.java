package com.cms.claimmanagement.controller;

import com.cms.claimmanagement.model.PolicyData;
import com.cms.claimmanagement.model.PolicyEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/policy")
public class PolicyController {

    @PostMapping
    public boolean createPolicy(@RequestBody PolicyEntity policy){
        System.out.println(policy);
return true;
    }
}
