package com.chandan.PlaceOrder.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.chandan.PlaceOrder.entity.Hotel;
import com.chandan.PlaceOrder.service.HotelDAOService;

@RestController
public class PlaceOrderController {

	@Autowired
	private HotelDAOService hotelDAOService;
	
	@PostMapping("/api/placeOrders")
	public ResponseEntity<Hotel> placeOrder(@Valid @RequestBody Hotel hotel) {
		hotelDAOService.saveOrder(hotel);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.buildAndExpand(hotel.getHotelId()).toUri();
		return ResponseEntity.created(location).build();
	}
}
