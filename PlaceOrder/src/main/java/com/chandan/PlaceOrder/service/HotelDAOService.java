package com.chandan.PlaceOrder.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chandan.PlaceOrder.entity.Hotel;
import com.chandan.PlaceOrder.repository.HotelRepository;

@Service
public class HotelDAOService {

	@Autowired
	private HotelRepository hotelRepository;
	
	public Hotel saveOrder(Hotel hotel) {
		return hotelRepository.save(hotel);
	}
}
