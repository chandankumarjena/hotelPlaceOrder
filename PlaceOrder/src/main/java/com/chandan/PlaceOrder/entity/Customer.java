package com.chandan.PlaceOrder.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Customer {
	@Id
	@GeneratedValue
	private long id;
	@NotNull(message="Customer Name is blank!!")
	private String name;
	
	@Email(message="Invalid Email!!")
	private String email;
	
	@Pattern(regexp="(^$|[0-9]{10})", message="Invalid contact number")
	private String number;
}