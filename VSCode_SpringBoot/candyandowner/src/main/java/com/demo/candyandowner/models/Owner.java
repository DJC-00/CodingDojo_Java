package com.demo.candyandowner.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="owners")
public class Owner {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
	
		@NotNull
	    @Size(min = 3, max = 30, message="The first name must be no less then 3, and not over 30!")
		private String firstName;
	
		@NotNull
	    @Size(min = 3, max = 30, message="The last name must be no less then 3, and not over 30!")
		private String lastName;
		
		
		// Creating One to Many relationship with Candy Class
		@OneToMany(mappedBy="owner", fetch = FetchType.LAZY)
	    private List<Candy> candys;

		
	    
	public Owner() {
			super();
		}


	public Owner(
				@NotNull @Size(min = 3, max = 30, message = "The first name must be no less then 3, and not over 30!") String firstName,
				@NotNull @Size(min = 3, max = 30, message = "The last name must be no less then 3, and not over 30!") String lastName) {
			super();
			this.firstName = firstName;
			this.lastName = lastName;
		}


	public Owner(Long id,
				@NotNull @Size(min = 3, max = 30, message = "The first name must be no less then 3, and not over 30!") String firstName,
				@NotNull @Size(min = 3, max = 30, message = "The last name must be no less then 3, and not over 30!") String lastName,
				List<Candy> candys, Date createdAt, Date updatedAt) {
			super();
			this.id = id;
			this.firstName = firstName;
			this.lastName = lastName;
			this.candys = candys;
			this.createdAt = createdAt;
			this.updatedAt = updatedAt;
		}


	public Long getId() {
			return id;
		}


		public void setId(Long id) {
			this.id = id;
		}


		public String getFirstName() {
			return firstName;
		}


		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}


		public String getLastName() {
			return lastName;
		}


		public void setLastName(String lastName) {
			this.lastName = lastName;
		}


		public List<Candy> getCandys() {
			return candys;
		}


		public void setCandys(List<Candy> candys) {
			this.candys = candys;
		}


		public Date getCreatedAt() {
			return createdAt;
		}


		public void setCreatedAt(Date createdAt) {
			this.createdAt = createdAt;
		}


		public Date getUpdatedAt() {
			return updatedAt;
		}


		public void setUpdatedAt(Date updatedAt) {
			this.updatedAt = updatedAt;
		}


		// This will not allow the createdAt column to be updated after creation
		@Column(updatable=false)
	    @DateTimeFormat(pattern="yyyy-MM-dd")
	    private Date createdAt;
	    
	    
	    @DateTimeFormat(pattern="yyyy-MM-dd")
	    private Date updatedAt;
	    
	    
	    
	    
	    
	    
	    
	    @PrePersist
	    protected void onCreate(){
	        this.createdAt = new Date();
	    }
		
		
		@PreUpdate
	    protected void onUpdate(){
	        this.updatedAt = new Date();
	    } 
	
}