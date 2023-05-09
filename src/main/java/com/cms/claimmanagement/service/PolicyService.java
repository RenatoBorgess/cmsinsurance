package com.cms.claimmanagement.service;

import com.cms.claimmanagement.repository.PolicyDataResponse;
import com.cms.claimmanagement.repository.PolicyData;
import com.cms.claimmanagement.repository.PolicyEntity;
import com.cms.claimmanagement.repository.PolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

@Service

public class PolicyService {


    @Autowired
    public PolicyRepository policyRepository;

    public List<PolicyDataResponse> listPolicies(){
        return policyRepository.findAll().stream().map(PolicyDataResponse::new).toList();
    }


    private String generatePolicyNo(String lastName, String vehicleNo){
        String firstTwoLetters = lastName.substring(0,2);
        String firstFourNumbers = vehicleNo.substring(0,4);
        DateFormat df = new SimpleDateFormat("yy");
        String twoDigitYear = df.format(Calendar.getInstance().getTime());

        return firstTwoLetters.toUpperCase()+firstFourNumbers+twoDigitYear;
    }

    public PolicyEntity savePolicy(PolicyData policyRe){
                    PolicyEntity policyRes;
            policyRes = new PolicyEntity();

                    policyRes.setPolicyNo(generatePolicyNo(policyRe.InsuredLastName(), policyRe.vehicleNo()));
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

