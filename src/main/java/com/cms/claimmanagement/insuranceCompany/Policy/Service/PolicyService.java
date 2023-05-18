package com.cms.claimmanagement.insuranceCompany.Policy.Service;

import com.cms.claimmanagement.insuranceCompany.Policy.Controller.PolicyResponseData;
import com.cms.claimmanagement.insuranceCompany.Policy.Repository.PolicyEntity;
import com.cms.claimmanagement.insuranceCompany.Policy.Repository.PolicyRepository;
import com.cms.claimmanagement.insuranceCompany.Policy.Controller.PolicyRequestData;
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

    public List<PolicyResponseData> listPolicies(){
        return policyRepository.findAll().stream().map(PolicyResponseData::new).toList();
    }


    private String generatePolicyNo(String lastName, String vehicleNo){
        String firstTwoLetters = lastName.substring(0,2);
        String firstFourNumbers = vehicleNo.substring(0,4);
        DateFormat df = new SimpleDateFormat("yy");
        String twoDigitYear = df.format(Calendar.getInstance().getTime());

        return firstTwoLetters.toUpperCase()+firstFourNumbers+twoDigitYear;
    }

    public PolicyResponseData savePolicy(PolicyRequestData policyRe){
                    PolicyEntity policyRes;
            policyRes = new PolicyEntity();

                    policyRes.setPolicyNo(generatePolicyNo(policyRe.insuredLastName(), policyRe.vehicleNo()));
                    policyRes.setInsuredFirstName(policyRe.insuredFirstName());
                    policyRes.setInsuredLastName(policyRe.insuredLastName());
                    policyRes.setDateOfInsurance(policyRe.dateOfInsurance());
                    policyRes.setEmailId(policyRe.emailId());
                    policyRes.setVehicleNo(policyRe.vehicleNo());
                    policyRes.setStatus(policyRe.status());
                    policyRepository.save(policyRes);

                    PolicyResponseData response = new PolicyResponseData(policyRes.getPolicyNo(),policyRes.InsuredFirstName());

         return response;


        }
    }

