package vn.vpm.hotelM.domain;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "apartment_")
public class Apartment {

    @Id
    @Column(name = "id_", length = 60)
    private String id;

    @Column(name = "flor_")
    private int flor;

    @Column(name = "status_", length = 60)
    private String status;

    @Column(name = "num_apartment_", length = 255)
    private String numApartment;

    @Column(name = "num_bedroom_")
    private int numBedroom;

    @Column(name = "square_")
    private BigDecimal square;

    @Column(name = "rent_price_")
    private BigDecimal rentPrice;

    @Column(name = "address_", length = 255)
    private String address;

    @OneToMany(mappedBy = "apartment")
    private List<Complaint> complaints;

    // Getters and Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getFlor() {
        return flor;
    }

    public void setFlor(int flor) {
        this.flor = flor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNumApartment() {
        return numApartment;
    }

    public void setNumApartment(String numApartment) {
        this.numApartment = numApartment;
    }

    public int getNumBedroom() {
        return numBedroom;
    }

    public void setNumBedroom(int numBedroom) {
        this.numBedroom = numBedroom;
    }

    public BigDecimal getSquare() {
        return square;
    }

    public void setSquare(BigDecimal square) {
        this.square = square;
    }

    public BigDecimal getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(BigDecimal rentPrice) {
        this.rentPrice = rentPrice;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Complaint> getComplaints() {
        return complaints;
    }

    public void setComplaints(List<Complaint> complaints) {
        this.complaints = complaints;
    }
}
