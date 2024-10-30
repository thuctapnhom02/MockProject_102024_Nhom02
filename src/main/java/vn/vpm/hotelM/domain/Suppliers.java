package vn.vpm.hotelM.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "suppliers_")
public class Suppliers {

    @Id
    @Column(name = "id_", length = 60)
    private String id;

    @Column(name = "name_", length = 255)
    private String name;

    @Column(name = "phone_", length = 30)
    private String phone;

    @Column(name = "email_", length = 255)
    private String email;

    @Column(name = "status_", length = 60)
    private String status;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
