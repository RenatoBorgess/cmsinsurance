package com.cms.claimmanagement.insuranceCompany.policy.Controller;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record PolicyRequestDTO(

        String insuredFirstName,
        String insuredLastName,
        LocalDate dateOfInsurance,

        String emailId,
        @NotNull
        String vehicleNo,
        boolean status
) {
}
