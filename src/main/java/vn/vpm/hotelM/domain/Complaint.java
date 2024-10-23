package vn.vpm.hotelM.domain;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "complaints_")
public class Complaint {

    @Id
    @Column(name = "id_", length = 60)
    private String id;

    @ManyToOne
    @JoinColumn(name = "id_apartment_", referencedColumnName = "id_")
    private Apartment apartment;

    @ManyToOne
    @JoinColumn(name = "id_user_", referencedColumnName = "id_")
    private User user;

    @Column(name = "complaint_date_")
    private LocalDateTime complaintDate;

    @Column(name = "expected_completion_date_")
    private LocalDateTime expectedCompletionDate;

    @Column(name = "content_of_complaint_", columnDefinition = "TEXT")
    private String contentOfComplaint;

    @Column(name = "proof_img_", columnDefinition = "TEXT")
    private String proofImg;

    @ManyToOne
    @JoinColumn(name = "id_staff_", referencedColumnName = "id_")
    private User staff;

    @Column(name = "note_", columnDefinition = "TEXT")
    private String note;

    @Column(name = "status_", length = 255)
    private String status;

    // Getters and Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Apartment getApartment() {
        return apartment;
    }

    public void setApartment(Apartment apartment) {
        this.apartment = apartment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getComplaintDate() {
        return complaintDate;
    }

    public void setComplaintDate(LocalDateTime complaintDate) {
        this.complaintDate = complaintDate;
    }

    public LocalDateTime getExpectedCompletionDate() {
        return expectedCompletionDate;
    }

    public void setExpectedCompletionDate(LocalDateTime expectedCompletionDate) {
        this.expectedCompletionDate = expectedCompletionDate;
    }

    public String getContentOfComplaint() {
        return contentOfComplaint;
    }

    public void setContentOfComplaint(String contentOfComplaint) {
        this.contentOfComplaint = contentOfComplaint;
    }

    public String getProofImg() {
        return proofImg;
    }

    public void setProofImg(String proofImg) {
        this.proofImg = proofImg;
    }

    public User getStaff() {
        return staff;
    }

    public void setStaff(User staff) {
        this.staff = staff;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
