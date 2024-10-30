package vn.vpm.hotelM.domain;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "employment_contract_")
public class EmploymentContract {

    @Id
    @Column(name = "id_", length = 60)
    private String id;

    @Column(name = "status_", length = 60)
    private String status;

    @Column(name = "name_", length = 255)
    private String name;

    @Column(name = "phone_", length = 30)
    private String phone;

    @Column(name = "email_", length = 255)
    private String email;

    @ManyToOne
    @JoinColumn(name = "id_user_", referencedColumnName = "id_")
    private User user; // Liên kết với model User

    @ManyToOne
    @JoinColumn(name = "id_staff_", referencedColumnName = "id_")
    private User staff; // Liên kết với model User (nhân viên)

    @Column(name = "id_suppliers_", length = 60)
    private String idSuppliers;

    // Getters và Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getStaff() {
        return staff;
    }

    public void setStaff(User staff) {
        this.staff = staff;
    }

    public String getIdSuppliers() {
        return idSuppliers;
    }

    public void setIdSuppliers(String idSuppliers) {
        this.idSuppliers = idSuppliers;
    }

    // Equals và hashCode cho việc so sánh đối tượng

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmploymentContract that = (EmploymentContract) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
