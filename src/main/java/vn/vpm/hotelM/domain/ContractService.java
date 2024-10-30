package vn.vpm.hotelM.domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "contract_service_")
public class ContractService {

    @Id
    @Column(name = "id_contract_", length = 255)
    private String idContract;

    @ManyToOne
    @JoinColumn(name = "id_user_", referencedColumnName = "id_")
    private User user;

    @ManyToOne
    @JoinColumn(name = "id_staff_", referencedColumnName = "id_")
    private Staff staff;

    @Column(name = "start_contract_")
    private LocalDateTime startContract;

    @Column(name = "end_contract_")
    private LocalDateTime endContract;

    @Column(name = "scope_of_the_contract_", columnDefinition = "TEXT")
    private String scopeOfTheContract;

    @Column(name = "quality_standards_", columnDefinition = "TEXT")
    private String qualityStandards;

    @ManyToOne
    @JoinColumn(name = "id_suppliers_", referencedColumnName = "id_")
    private Suppliers supplier;

    @Column(name = "status_", length = 60)
    private String status;

    // Getters and Setters
    public String getIdContract() {
        return idContract;
    }

    public void setIdContract(String idContract) {
        this.idContract = idContract;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public LocalDateTime getStartContract() {
        return startContract;
    }

    public void setStartContract(LocalDateTime startContract) {
        this.startContract = startContract;
    }

    public LocalDateTime getEndContract() {
        return endContract;
    }

    public void setEndContract(LocalDateTime endContract) {
        this.endContract = endContract;
    }

    public String getScopeOfTheContract() {
        return scopeOfTheContract;
    }

    public void setScopeOfTheContract(String scopeOfTheContract) {
        this.scopeOfTheContract = scopeOfTheContract;
    }

    public String getQualityStandards() {
        return qualityStandards;
    }

    public void setQualityStandards(String qualityStandards) {
        this.qualityStandards = qualityStandards;
    }

    public Suppliers getSupplier() {
        return supplier;
    }

    public void setSupplier(Suppliers supplier) {
        this.supplier = supplier;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
