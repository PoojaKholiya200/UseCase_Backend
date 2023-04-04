package com.inn.Adminwork.POJO;

import java.io.Serializable;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NamedQuery(name= "AdminUser.findByEmailId", query= "select u from AdminUser u where u.email =: email")
//@NamedQuery(name= "AdminUser.updateDetail" , query=" update AdminUser u set u.name=name where u.email=: email ")
 //will provide default zero to our constructor for our class,this getter and status for all the variable
@Getter
@Setter
@NoArgsConstructor
@Entity
@DynamicUpdate
@DynamicInsert
@Table(name="user")
public class AdminUser implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//automatically generate id one by one whenever added 
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="contactNumber")
	private String contactNumber;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	
	@Column(name="status")
	private String status;
	
	@Column(name="role")
	private String role;

	

	public AdminUser(Integer id, String name, String contactNumber, String email, String password, String status,
			String role) {
		super();
		this.id = id;
		this.name = name;
		this.contactNumber = contactNumber;
		this.email = email;
		this.password = password;
		this.status = status;
		this.role = role;
	}



	@Override
	public String toString() {
		return "AdminUser [id=" + id + ", name=" + name + ", contactNumber=" + contactNumber + ", email=" + email
				+ ", password=" + password + ", status=" + status + ", role=" + role + "]";
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getContactNumber() {
		return contactNumber;
	}



	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
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



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public String getRole() {
		return role;
	}



	public void setRole(String role) {
		this.role = role;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	public AdminUser() {
		super();
		// TODO Auto-generated constructor stub
	}

}


