package vn.vpm.hotelM.domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "contract_lease_")
public class ContractLease {

    @Id
    @Column(name = "id_", length = 60)
    private String id;

    @ManyToOne
    @JoinColumn(name = "id_user_")
    private User user;

    @ManyToOne
    @JoinColumn(name = "id_staff_")
    private Staff staff;

    @Column(name = "status_", length = 60)
    private String status;

    @Column(name = "contact_info_", length = 255)
    private String contactInfo;

    @Column(name = "rental_fee_")
    private String rentalFee; // Có thể thay đổi thành BigDecimal nếu cần

    @Column(name = "payment_period_")
    private LocalDateTime paymentPeriod;

    @Column(name = "lease_start_date_")
    private LocalDateTime leaseStartDate;

    @Column(name = "lease_end_date_")
    private LocalDateTime leaseEndDate;

    @ManyToOne
    @JoinColumn(name = "id_suppliers_")
    private Suppliers suppliers;

    @ManyToOne
    @JoinColumn(name = "id_apartment_")
    private Apartment apartment;

    // Getters and Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public String getRentalFee() {
        return rentalFee;
    }

    public void setRentalFee(String rentalFee) {
        this.rentalFee = rentalFee;
    }

    public LocalDateTime getPaymentPeriod() {
        return paymentPeriod;
    }

    public void setPaymentPeriod(LocalDateTime paymentPeriod) {
        this.paymentPeriod = paymentPeriod;
    }

    public LocalDateTime getLeaseStartDate() {
        return leaseStartDate;
    }

    public void setLeaseStartDate(LocalDateTime leaseStartDate) {
        this.leaseStartDate = leaseStartDate;
    }

    public LocalDateTime getLeaseEndDate() {
        return leaseEndDate;
    }

    public void setLeaseEndDate(LocalDateTime leaseEndDate) {
        this.leaseEndDate = leaseEndDate;
    }

    public Suppliers getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(Suppliers suppliers) {
        this.suppliers = suppliers;
    }

    public Apartment getApartment() {
        return apartment;
    }

    public void setApartment(Apartment apartment) {
        this.apartment = apartment;
    }
}
