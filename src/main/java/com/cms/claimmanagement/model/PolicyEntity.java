package com.cms.claimmanagement.model;

import jakarta.persistence.*;
import jdk.jfr.Timestamp;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.CurrentTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.repository.Temporal;

import java.time.LocalDate;
import java.util.Objects;
@Table (name = "policy_entity")
@Entity(name = "PolicyEntity")
public class PolicyEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private  Long id;
        private final String PolicyNo;
        private final String InsuredFirstName;
        private final String InsuredLastName;
        @UpdateTimestamp
        private final LocalDate dateOfInsurance;
        private final String emailId;
        private final String vehicleNo;
        private final boolean status;

        public PolicyEntity(
                String PolicyNo,
                String InsuredFirstName,
                String InsuredLastName,
                LocalDate dateOfInsurance,
                String emailId,
                String vehicleNo,
                boolean status
        ) {
            this.PolicyNo = PolicyNo;
            this.InsuredFirstName = InsuredFirstName;
            this.InsuredLastName = InsuredLastName;
            this.dateOfInsurance = dateOfInsurance;
            this.emailId = emailId;
            this.vehicleNo = vehicleNo;
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
            var that = (com.cms.claimmanagement.model.PolicyEntity) obj;
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


