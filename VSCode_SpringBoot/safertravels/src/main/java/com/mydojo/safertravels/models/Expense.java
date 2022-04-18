package com.mydojo.safertravels.models;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="expenses")
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min = 5, max = 200, message="Title must be at least 5 characters.")
    private String item;
    @NotNull
    @Size(min = 1, max = 200, message="Vendor must be at least 1 characters.")
    private String vendor;
    @NotNull
    @DecimalMin(value = "0.0", inclusive = false, message="Must be more than 0")
    private BigDecimal cost;
    // This will not allow the createdAt column to be updated after creation
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    @OneToOne(mappedBy="expense", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    private VendorProfile vendorProfile;
    public Expense(String item, String vendor, BigDecimal cost, VendorProfile vendProf) {
        this.item = item;
        this.vendor = vendor;
        this.cost = cost;
        this.vendorProfile = vendProf;
    }

    public Expense() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public VendorProfile getVendorProfile() {
        return vendorProfile;
    }

    public void setVendorProfile(VendorProfile vendorProfile) {
        this.vendorProfile = vendorProfile;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }
    // other getters and setters removed for brevity
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }



}
