package com.cms.claimmanagement.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;

public record PolicyData(
        @Pattern(regexp = "")
        String PolicyNo,
        String InsuredFirstName,
        String InsuredLastName,
        LocalDate dateOfInsurance,
        @Email
        String emailId,
        @NotNull
        String vehicleNo,
        boolean status
) {
}
