package com.cms.claimmanagement.insuranceCompany.surveyor.surveyReport.Repository;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class SurveyReport {

    @Id
    private String claimId;
    private String policyNo;
    private Long labourCharges, partsCost, policyClass, depreciationCost, totalamount;

    public String getClaimId() {
        return claimId;
    }

    public void setClaimId(String claimId) {
        this.claimId = claimId;
    }

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }

    public Long getLabourCharges() {
        return labourCharges;
    }

    public void setLabourCharges(Long labourCharges) {
        this.labourCharges = labourCharges;
    }

    public Long getPartsCost() {
        return partsCost;
    }

    public void setPartsCost(Long partsCost) {
        this.partsCost = partsCost;
    }

    public Long getPolicyClass() {
        return policyClass;
    }

    public void setPolicyClass(Long policyClass) {
        this.policyClass = policyClass;
    }

    public Long getDepreciationCost() {
        return depreciationCost;
    }

    public void setDepreciationCost(Long depreciationCost) {
        this.depreciationCost = depreciationCost;
    }

    public Long getTotalamount() {
        return totalamount;
    }

    public void setTotalamount(Long totalamount) {
        this.totalamount = totalamount;
    }
}
