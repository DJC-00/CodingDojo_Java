package com.myproject.projectmanager.models;

import java.util.Date;
import java.util.List;
import java.util.Set;

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
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message="First name is required!")
	@Size(min=3, max=30, message="First name must be between 3 and 30 characters")
    private String firstName;

	@NotEmpty(message="Last name is required!")
	@Size(min=3, max=128, message="Last name must be between 3 and 128 characters")
    private String lastName;
    
	@NotEmpty(message="Email is required!")
	@Email(message="Please enter a valid email!")
	private String email;
	
	@NotEmpty(message="Password is required!")
	@Size(min=8, max=128, message="Password must be between 3 and 128 characters")
	private String password;
	
	@Transient
	@NotEmpty(message="Confirm Password is required!")
	@Size(min=8, max=128, message="Confirm Password must be between 8 and 128 characters")
	private String confirm;
	
	// This will not allow the createdAt column to be updated after creation
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;

    @OneToMany(mappedBy="user", fetch = FetchType.LAZY)
    private List<Venture> ventures;

    @OneToMany(mappedBy = "users")
    Set<Team> teams;
	
	public User() {}
	
	public User(
        @NotEmpty(message = "First name is required.") @Size(min = 3, max = 30, message = "First name must be between 3 and 30 characters") String firstName,
		@NotEmpty(message = "Last name is required.") @Size(min = 3, max = 30, message = "Last name must be between 3 and 30 characters") String lastName,
		@NotEmpty(message = "Email is required!") @Email(message = "Please enter a valid email!") String email,
		@NotEmpty(message = "Password is required!") @Size(min = 8, max = 128, message = "Password must be between 8 and 128 characters") String password,
		@NotEmpty(message = "Confirm Password is required!") @Size(min = 8, max = 128, message = "Confirm Password must be between 8 and 128 characters") String confirm) {
		
		super();
        this.firstName = firstName;
        this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.confirm = confirm;
	}

	public User(Long id,
		@NotEmpty(message = "First name is required.") @Size(min = 3, max = 30, message = "First name must be between 3 and 30 characters") String firstName,
		@NotEmpty(message = "Last name is required.") @Size(min = 3, max = 30, message = "Last name must be between 3 and 30 characters") String lastName,
		@NotEmpty(message = "Email is required!") @Email(message = "Please enter a valid email!") String email,
		@NotEmpty(message = "Password is required!") @Size(min = 8, max = 128, message = "Password must be between 8 and 128 characters") String password,
		@NotEmpty(message = "Confirm Password is required!") @Size(min = 8, max = 128, message = "Confirm Password must be between 8 and 128 characters") String confirm,
		Date createdAt, Date updatedAt) {
		
		super();
		this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.confirm = confirm;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirm() {
		return confirm;
	}

	public void setConfirm(String confirm) {
		this.confirm = confirm;
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

    public List<Venture> getVentures() {
        return ventures;
    }

    public void setVentures(List<Venture> ventures) {
        this.ventures = ventures;
    } 

	@PrePersist
	protected void onCreate(){
		this.createdAt = new Date();
	}
	
	@PreUpdate
	protected void onUpdate(){
		this.updatedAt = new Date();
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

    public Set<Team> getTeams() {
        return teams;
    }

    public void setTeams(Set<Team> teams) {
        this.teams = teams;
    }
}