package vn.vpm.hotelM.domain;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "apartment_")
public class Apartment {

    @Id
    @Column(name = "id_", length = 60)
    private String id;

    @Column(name = "location_", length = 255)
    private String location;

    @Column(name = "area_")
    private String area; // Có thể thay đổi thành BigDecimal nếu cần

    @Column(name = "price_")
    private String price; // Có thể thay đổi thành BigDecimal nếu cần

    @Column(name = "status_", length = 60)
    private String status;

    @OneToMany(mappedBy = "apartment")
    private List<ContractLease> contractLeases;

    // Getters and Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ContractLease> getContractLeases() {
        return contractLeases;
    }

    public void setContractLeases(List<ContractLease> contractLeases) {
        this.contractLeases = contractLeases;
    }
}
