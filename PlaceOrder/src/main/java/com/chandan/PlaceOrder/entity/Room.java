package com.chandan.PlaceOrder.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Room {
	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull(message="Room Name is blank!!")
	@Column(name="room_name")
	private String roomName;
	
	@Column(name="number_of_guest")
	private int numberOfGuest;

}
