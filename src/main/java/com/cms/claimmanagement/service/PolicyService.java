package com.cms.claimmanagement.service;

import com.cms.claimmanagement.controller.PolicyController;
import com.cms.claimmanagement.controller.PolicyDataResponse;
import com.cms.claimmanagement.model.PolicyData;
import com.cms.claimmanagement.model.PolicyEntity;
import com.cms.claimmanagement.model.PolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

public class PolicyService {


    @Autowired
    public PolicyRepository policyRepository;

    public List<PolicyDataResponse> listPolicies(){
        return policyRepository.findAll().stream().map(PolicyDataResponse::new).toList();
        }


    public PolicyEntity savePolicy(PolicyData policyRe){
                    PolicyEntity policyRes;
            policyRes = new PolicyEntity();
                    policyRes.setPolicyNo(policyRe.PolicyNo());
                    policyRes.setInsuredFirstName(policyRe.InsuredFirstName());
                    policyRes.setInsuredLastName(policyRe.InsuredLastName());
                    policyRes.setDateOfInsurance(policyRe.dateOfInsurance());
                    policyRes.setEmailId(policyRe.emailId());
                    policyRes.setVehicleNo(policyRe.vehicleNo());
                    policyRes.setStatus(policyRe.status());
                    policyRepository.save(policyRes);

         return policyRes;


        }
    }

