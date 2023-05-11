package com.cms.claimmanagement.insuranceCompany.repository;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record PolicyRequestData(

        String InsuredFirstName,
        String InsuredLastName,
        LocalDate dateOfInsurance,

        String emailId,
        @NotNull
        String vehicleNo,
        boolean status
) {
}
