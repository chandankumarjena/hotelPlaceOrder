package com.chandan.PlaceOrder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.chandan.PlaceOrder.entity.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Long>{

}
