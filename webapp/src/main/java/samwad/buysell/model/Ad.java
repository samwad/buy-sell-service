package samwad.buysell.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "AD", catalog = "buy_sell_db", uniqueConstraints = { @UniqueConstraint(columnNames = "ID") })
public class Ad {
    @Id
    @GeneratedValue
    @Column(name = "ID", unique = true, nullable = false)
    private int id;
    @Column(name = "PRICE", nullable = false)
    private int price;
    @Column(name = "DESCRIPTION", nullable = false)
    private String description;
    @Column(name = "TIMEOFEXPIRY", nullable = true)
    private Timestamp timeOfExpiry = null;
    @Column(name = "TIMEOFSUBMISSION", nullable = false, updatable = false, columnDefinition = "TIMESTAMP default CURRENT_TIMESTAMP")
    private Timestamp timeOfSubmission = new Timestamp(System.currentTimeMillis());

    @Column(name = "CREATED_BY", nullable = false)
    private String createdBy;
    @Column(name = "LOCATION", nullable = false)
    private String location;
    @Column(name = "CONTACT", nullable = false)
    private String contact;
    @Column(name = "ADTYPE", nullable = false)
    private AdType adType = AdType.SELL;

    public enum AdType {
        BUY, SELL, RENTAL
    }

    public Ad() {
    }

    public Ad(int price, String description, Timestamp timeOfExpiry, String createdBy,
            String location, String contact, AdType adType) {
        this.price = price;
        this.description = description;
        this.timeOfExpiry = timeOfExpiry;
        this.createdBy = createdBy;
        this.location = location;
        this.contact = contact;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getTimeOfExpiry() {
        return timeOfExpiry;
    }

    public void setTimeOfExpiry(Timestamp timeOfExpiry) {
        this.timeOfExpiry = timeOfExpiry;
    }

    public Timestamp getTimeOfSubmission() {
        return timeOfSubmission;
    }

    public void setTimeOfSubmission(Timestamp timeOfSubmission) {
        this.timeOfSubmission = timeOfSubmission;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public AdType getAdType() {
        return adType;
    }

    public void setAdType(AdType adType) {
        this.adType = adType;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "Ad [id=" + id + ", price=" + price + ", description=" + description
                + ", timeOfExpiry=" + timeOfExpiry + ", timeOfSubmission=" + timeOfSubmission
                + ", createdBy=" + createdBy + ", location=" + location + ", contact=" + contact
                + "]";
    }
}
