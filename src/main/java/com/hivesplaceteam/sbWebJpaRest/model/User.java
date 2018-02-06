package com.hivesplaceteam.sbWebJpaRest.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

@Entity
@Table(name="users")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	public User() {}
	
	public User(String username, String password, int status) {
		this.username = username;
		this.password = password;
		this.status = status;
	}
	
	public User(int id, String username, String password, int status) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.status = status;
	}

	/*Hibernate Validator*/
	/* @AssertFalse
	 * @AssertTrue
	 * @CreditCardNumber
	 * @DecimalMax
	 * @DecimalMin
	 * @Digits
	 * @EAN
	 * @Email
	 * @Future [check if the date is in the future]
	 * @Length(min=, max=)
	 * @Max(value=)
	 * @Min(value=)
	 * @NotEmpty
	 * @NotNull
	 * @Null
	 * @Past [check if the date is in the past]
	 * @Pattern(regexp="",flag="", message="") or
	 *     @Pattern.List({@Pattern(regexp="",flag="",message=""),@Pattern...})
	 * @Range(min=,max=)
	 * @Size(min=,max=)
	 * @Valid
	 * */
	//@Pattern(regexp="[0-9]+", message="Id must contains only digit")
	@Id @GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id;
	@Email
	@Column(name="username", unique=true)
	private String username;
	@NotNull(message="password cannot be null")
	@Length(min=0, max=32, message="password length cannot exceed 32 characters")
	@Column(name="password")
	private String password;
	@NotNull(message="password cannot be null")
	@Range(min=0, max=255, message="status value cannot less than 0 or exceed 255")
	@Column(name="status")
	private int status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", status=" + status + "]";
	}

}
