package com.myproject.projectmanager.models;



import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="teams")
public class Team {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(updatable=false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdAt;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updatedAt;
    
    @OneToMany(mappedBy="team", fetch = FetchType.LAZY)
    private List<Task> tasks;

    // Temp code for many to many, revisit later

    @ManyToOne
    @JoinColumn(name = "user_id")
    User users;

    // @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "venture_id")
    Venture ventures ;
    
    public Team() {}

    public List<Task> getTasks() {
        return tasks;
    }

    public User getUsers() {
        return users;
    }

    public void setUsers(User users) {
        this.users = users;
    }

    public Venture getVentures() {
        return ventures;
    }

    public void setVentures(Venture ventures) {
        this.ventures = ventures;
    }

    public Long getId() {
        return id;
    }

    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
}

