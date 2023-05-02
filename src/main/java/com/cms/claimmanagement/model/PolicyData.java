package com.cms.claimmanagement.model;

import java.time.LocalDate;

public record PolicyData(
        String PolicyNo,
        String InsuredFirstName,
        String InsuredLastName,
        LocalDate dateOfInsurance,
        String emailId,
        String vehicleNo,
        boolean status
) {
}
