package com.chandan.PlaceOrder.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.chandan.PlaceOrder.entity.Customer;
import com.chandan.PlaceOrder.entity.Hotel;
import com.chandan.PlaceOrder.entity.Room;
import com.chandan.PlaceOrder.repository.CustomerRepository;
import com.chandan.PlaceOrder.repository.HotelRepository;
import com.chandan.PlaceOrder.repository.RoomRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class HotelDAOServiceTest {
	@Mock
	private HotelRepository hotelRepository;
	@Mock
	private CustomerRepository customerRepository;
	@Mock
	private RoomRepository roomRepository;
	@Autowired
	private HotelDAOService hotelDAOService;
	
	@Test
	public void testSaveOrder_returnSuccess() {
		
		Room room = new Room();
		room.setNumberOfGuest(2);
		room.setRoomName("first");
		List<Room> listOfRooms = Stream.of(room).collect(Collectors.toList());
		
		Customer customer = new Customer();
		customer.setName("chandan");
		customer.setEmail("chandan@gmail.com");
		customer.setNumber("8095541037");
		List<Customer> listOfCustomers = Stream.of(customer).collect(Collectors.toList());
		
		Hotel hotel = new Hotel();
		hotel.setHotelName("Trupti");
		hotel.setCheckInDate(LocalDate.of(2020, 8, 3));
		hotel.setCheckOutDate(LocalDate.of(2020, 8, 4));
		hotel.setCustomers(listOfCustomers);
		hotel.setRooms(listOfRooms);
		hotel.setTotalAmount(12000);
		
		when(hotelRepository.save(hotel)).thenReturn(hotel);
		
		assertEquals(hotel, hotelDAOService.saveOrder(hotel));
 		
	}
}







