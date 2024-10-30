package vn.vpm.hotelM.domain;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "utility_contract_")
public class UtilityContract {

    @Id
    @Column(name = "id_contract_", length = 255)
    private String idContract;

    @Column(name = "start_day_")
    private LocalDateTime startDay;

    @Column(name = "end_day_")
    private LocalDateTime endDay;

    @Column(name = "type_of_utility_", columnDefinition = "TEXT")
    private String typeOfUtility;

    @Column(name = "price_")
    private BigDecimal price;

    @Column(name = "status_", length = 60)
    private String status;

    @ManyToOne
    @JoinColumn(name = "id_user_", referencedColumnName = "id_")
    private User user;

    @ManyToOne
    @JoinColumn(name = "id_suppliers_", referencedColumnName = "id_")
    private Suppliers supplier;

    @ManyToOne
    @JoinColumn(name = "id_staff_", referencedColumnName = "id_")
    private Staff staff;

    // Getters and Setters

    public String getIdContract() {
        return idContract;
    }

    public void setIdContract(String idContract) {
        this.idContract = idContract;
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

    public String getTypeOfUtility() {
        return typeOfUtility;
    }

    public void setTypeOfUtility(String typeOfUtility) {
        this.typeOfUtility = typeOfUtility;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Suppliers getSupplier() {
        return supplier;
    }

    public void setSupplier(Suppliers supplier) {
        this.supplier = supplier;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }
}
