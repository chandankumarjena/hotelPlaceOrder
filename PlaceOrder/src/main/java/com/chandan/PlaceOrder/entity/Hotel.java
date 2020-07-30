package com.chandan.PlaceOrder.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Hotel {
	@Id
	@GeneratedValue
	private long hotelId;
	
	@NotNull(message="Hotel Name Can't be Null!!")
	@Column(name ="hotel_name")
	private String hotelName;
	
	@FutureOrPresent(message="CheckInDate shouldn't be PastDate")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate checkInDate;
	
	@FutureOrPresent(message="CheckOutDate shouldn't be PastDate")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate checkOutDate;
	@Column(name="total_amount")
	
	@Positive(message="totalAmount Can't be negative!!")
	private double totalAmount;
	
	@OneToMany(targetEntity = Customer.class,cascade = CascadeType.ALL)
    @JoinColumn(name ="hc_fk",referencedColumnName = "hotelId")
	@Valid
    private List<Customer> customers;
	
	@OneToMany(targetEntity = Room.class,cascade = CascadeType.ALL)
    @JoinColumn(name ="hr_fk",referencedColumnName = "hotelId")
	@Valid
    private List<Room> rooms;
}
