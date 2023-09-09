package com.cms.claimmanagement.insuranceCompany.policy.Controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PolicyResponseDTO {

    private String policyNo;
    private String insuredFirstName;

}
