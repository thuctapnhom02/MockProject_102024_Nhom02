package vn.vpm.hotelM.domain;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "user_")
public class User {

    @Id
    @Column(name = "id_", length = 60)
    private String id;

    @Column(name = "name_", length = 255)
    private String name;

    @Column(name = "email_", length = 255)
    private String email;

    @Column(name = "phone_", length = 30)
    private String phone;

    @Column(name = "gender_", length = 10)
    private String gender;

    @Column(name = "ssn_", length = 9)
    private String ssn;

    @Column(name = "status_", length = 60)
    private String status;

    @Column(name = "password_", length = 255)
    private String password;

    @Column(name = "debt_")
    private BigDecimal debt;

    @Column(name = "total_payment_")
    private BigDecimal totalPayment;

    @OneToMany(mappedBy = "user")
    private List<Complaint> complaints;

    @OneToMany(mappedBy = "staff")
    private List<Complaint> staffComplaints;

    // Getters and Setters


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public BigDecimal getDebt() {
        return debt;
    }

    public void setDebt(BigDecimal debt) {
        this.debt = debt;
    }

    public BigDecimal getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(BigDecimal totalPayment) {
        this.totalPayment = totalPayment;
    }

    public List<Complaint> getComplaints() {
        return complaints;
    }

    public void setComplaints(List<Complaint> complaints) {
        this.complaints = complaints;
    }

    public List<Complaint> getStaffComplaints() {
        return staffComplaints;
    }

    public void setStaffComplaints(List<Complaint> staffComplaints) {
        this.staffComplaints = staffComplaints;
    }
}
