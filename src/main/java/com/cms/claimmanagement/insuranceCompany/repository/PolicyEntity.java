package com.cms.claimmanagement.insuranceCompany.repository;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import jakarta.validation.constraints.Size;

import org.hibernate.annotations.UpdateTimestamp;


import java.time.LocalDate;
import java.util.Objects;

@Table(name = "policy_entity")
@Entity(name = "Policy_Entity")
public class PolicyEntity {

    public PolicyEntity() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String PolicyNo;
    @NotBlank
    @Size(min = 5)
    private String InsuredFirstName;
    private String InsuredLastName;
    @UpdateTimestamp
    private LocalDate dateOfInsurance;

    private String emailId;
    private String vehicleNo;
    private boolean status;

    public String getPolicyNo() {
        return PolicyNo;
    }

    public String getInsuredFirstName() {
        return InsuredFirstName;
    }

    public PolicyEntity(PolicyEntity policyEntity) {

    }

    public void setPolicyNo(String policyNo) {
        PolicyNo = policyNo;
    }

    public void setInsuredFirstName(String insuredFirstName) {
        InsuredFirstName = insuredFirstName;
    }

    public void setInsuredLastName(String insuredLastName) {
        InsuredLastName = insuredLastName;
    }

    public void setDateOfInsurance(LocalDate dateOfInsurance) {
        this.dateOfInsurance = dateOfInsurance;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String PolicyNo() {
        return PolicyNo;
    }

    public String InsuredFirstName() {
        return InsuredFirstName;
    }

    public String InsuredLastName() {
        return InsuredLastName;
    }

    public LocalDate dateOfInsurance() {
        return dateOfInsurance;
    }

    public String emailId() {
        return emailId;
    }

    public String vehicleNo() {
        return vehicleNo;
    }

    public boolean status() {
        return status;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (PolicyEntity) obj;
        return Objects.equals(this.PolicyNo, that.PolicyNo) &&
                Objects.equals(this.InsuredFirstName, that.InsuredFirstName) &&
                Objects.equals(this.InsuredLastName, that.InsuredLastName) &&
                Objects.equals(this.dateOfInsurance, that.dateOfInsurance) &&
                Objects.equals(this.emailId, that.emailId) &&
                Objects.equals(this.vehicleNo, that.vehicleNo) &&
                this.status == that.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(PolicyNo, InsuredFirstName, InsuredLastName, dateOfInsurance, emailId, vehicleNo, status);
    }

    @Override
    public String toString() {
        return "PolicyData[" +
                "PolicyNo=" + PolicyNo + ", " +
                "InsuredFirstName=" + InsuredFirstName + ", " +
                "InsuredLastName=" + InsuredLastName + ", " +
                "dateOfInsurance=" + dateOfInsurance + ", " +
                "emailId=" + emailId + ", " +
                "vehicleNo=" + vehicleNo + ", " +
                "status=" + status + ']';
    }

}


