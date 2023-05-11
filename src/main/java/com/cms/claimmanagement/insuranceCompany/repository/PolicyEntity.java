package com.cms.claimmanagement.insuranceCompany.repository;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Table(name = "policy_entity")
@Entity(name = "Policy_Entity")
public class PolicyEntity {

    public PolicyEntity() {
    }

    @Column(name = "policy_no")
    @Id
    private String policyNo;
    @OneToMany(mappedBy = "policy")
    private List<ClaimDetails> claimDetails;
    @NotBlank
    @Size(min = 5)
    private String insuredFirstName;
    private String insuredLastName;
    @UpdateTimestamp
    private LocalDate dateOfInsurance;

    private String emailId;
    private String vehicleNo;
    private boolean status;

    public String getPolicyNo() {
        return policyNo;
    }

    public String getInsuredFirstName() {
        return insuredFirstName;
    }

    public PolicyEntity(PolicyEntity policyEntity) {

    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }

    public void setInsuredFirstName(String insuredFirstName) {
        this.insuredFirstName = insuredFirstName;
    }

    public void setInsuredLastName(String insuredLastName) {
        this.insuredLastName = insuredLastName;
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
        return policyNo;
    }

    public String InsuredFirstName() {
        return insuredFirstName;
    }

    public String InsuredLastName() {
        return insuredLastName;
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
        return Objects.equals(this.policyNo, that.policyNo) &&
                Objects.equals(this.insuredFirstName, that.insuredFirstName) &&
                Objects.equals(this.insuredLastName, that.insuredLastName) &&
                Objects.equals(this.dateOfInsurance, that.dateOfInsurance) &&
                Objects.equals(this.emailId, that.emailId) &&
                Objects.equals(this.vehicleNo, that.vehicleNo) &&
                this.status == that.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(policyNo, insuredFirstName, insuredLastName, dateOfInsurance, emailId, vehicleNo, status);
    }

    @Override
    public String toString() {
        return "PolicyData[" +
                "PolicyNo=" + policyNo + ", " +
                "InsuredFirstName=" + insuredFirstName + ", " +
                "InsuredLastName=" + insuredLastName + ", " +
                "dateOfInsurance=" + dateOfInsurance + ", " +
                "emailId=" + emailId + ", " +
                "vehicleNo=" + vehicleNo + ", " +
                "status=" + status + ']';
    }

}


