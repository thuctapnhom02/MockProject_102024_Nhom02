package vn.vpm.hotelM.domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "staff_")
public class Staff {

    @Id
    @Column(name = "id_", length = 60)
    private String id;

    @Column(name = "id_role_", length = 60)
    private String roleId;

    @Column(name = "name_", length = 255)
    private String name;

    @Column(name = "phone_", length = 30)
    private String phone;

    @Column(name = "gender_", length = 10)
    private String gender;

    @Column(name = "start_day_")
    private LocalDateTime startDay;

    @Column(name = "end_day_")
    private LocalDateTime endDay;

    @Column(name = "status_", length = 60)
    private String status;

    @Column(name = "password_", length = 255)
    private String password;

    @OneToMany(mappedBy = "staff")
    private List<ContractLease> contractLeases;

    // Getters and Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public LocalDateTime getStartDay() {
        return startDay;
    }

    public void setStartDay(LocalDateTime startDay) {
        this.startDay = startDay;
    }

    public LocalDateTime getEndDay() {
        return endDay;
    }

    public void setEndDay(LocalDateTime endDay) {
        this.endDay = endDay;
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

    public List<ContractLease> getContractLeases() {
        return contractLeases;
    }

    public void setContractLeases(List<ContractLease> contractLeases) {
        this.contractLeases = contractLeases;
    }
}
