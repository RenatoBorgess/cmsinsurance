package com.cms.claimmanagement.insuranceCompany.policy.Service;

import com.cms.claimmanagement.insuranceCompany.policy.Controller.PolicyResponseDTO;
import com.cms.claimmanagement.insuranceCompany.policy.Repository.PolicyEntity;
import com.cms.claimmanagement.insuranceCompany.policy.Repository.PolicyRepository;
import com.cms.claimmanagement.insuranceCompany.policy.Controller.PolicyRequestDTO;
import org.modelmapper.ModelMapper;
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

    public List<PolicyResponseDTO> listPolicies(){
        List<PolicyResponseDTO> listedPolicies = policyRepository
                .findAll()
                .stream()
                .map(PolicyEntity::getPolicyNo)
                .map(policyResponse -> new PolicyResponseDTO())
                .toList();
    return listedPolicies;
    }


    private String generatePolicyNo(String lastName, String vehicleNo){
        String firstTwoLetters = lastName.substring(0,2);
        String firstFourNumbers = vehicleNo.substring(0,4);


        return firstTwoLetters.toUpperCase()+firstFourNumbers+formattedYear("yy");
    }
    public String formattedYear(String format){
        DateFormat df = new SimpleDateFormat(format);
        String formattedDigits = df.format(Calendar.getInstance().getTime());
        return formattedDigits;
    }

    public PolicyResponseDTO savePolicy(final PolicyRequestDTO policyRe){

        ModelMapper mapper = new ModelMapper();

        PolicyEntity policy = mapper.map(policyRe, PolicyEntity.class);

        PolicyEntity savedPolicy = policyRepository.save(policy);

        PolicyResponseDTO response = mapper.map(savedPolicy, PolicyResponseDTO.class);

         return response;


        }
    }

