package com.chandan.PlaceOrder.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.chandan.PlaceOrder.repository.CustomerRepository;
import com.chandan.PlaceOrder.repository.HotelRepository;
import com.chandan.PlaceOrder.repository.RoomRepository;
import com.chandan.PlaceOrder.service.HotelDAOService;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PlaceOrderControllerTest {
	private MockMvc mockMvc;
	@InjectMocks
	private PlaceOrderController placeOrderControllerMock;	
	
	@Mock
	private HotelRepository hotelRepository;
	@Mock
	private CustomerRepository customerRepository;
	@Mock
	private RoomRepository roomRepository;
	@Mock
	private HotelDAOService hotelDAOService;
	
	
	@BeforeEach
	public void setUp() throws Exception{
		mockMvc = MockMvcBuilders.standaloneSetup(placeOrderControllerMock).build();
	}
	
	@Test
	public void testPlaceOrder_returnSuccess() throws Exception{
				
		String exampleHotelJson =
				"{\"hotelName\":\"puspak1\",\"checkInDate\":\"2020-08-31\",\"checkOutDate\":\"2020-09-07\",\"totalAmount\":12000,\"customers\":[{\"name\":\"chandan3\",\"email\":\"chandan3@gmail.com\",\"number\":\"9938161801\"}],\"rooms\":[{\"roomName\":\"sahid\",\"numberOfGuest\":4}]}";	
	
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/api/placeOrders")
				.accept(MediaType.APPLICATION_JSON).content(exampleHotelJson)
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();

		assertEquals(HttpStatus.CREATED.value(), response.getStatus());
		assertEquals("http://localhost/api/placeOrders",
				response.getHeader(HttpHeaders.LOCATION));
	}
	
	@Test
	public void testPlaceOrder_whenHotelNameIsNull_returnBadRequest() throws Exception{
		
		String exampleHotelJson =
				"{\"hotelName\":null,\"checkInDate\":\"2020-08-31\",\"checkOutDate\":\"2020-09-07\",\"totalAmount\":12000,\"customers\":[{\"name\":\"chandan3\",\"email\":\"chandan3@gmail.com\",\"number\":\"9938161801\"}],\"rooms\":[{\"roomName\":\"sahid\",\"numberOfGuest\":4}]}";	
	
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/api/placeOrders")
				.accept(MediaType.APPLICATION_JSON).content(exampleHotelJson)
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();

		assertEquals(HttpStatus.BAD_REQUEST.value(), response.getStatus());
	}
	
	@Test
	public void testPlaceOrder_whenCheckInDateIsPastDate_returnBadRequest() throws Exception{
		
		String exampleHotelJson =
				"{\"hotelName\":\"puspak1\",\"checkInDate\":\"2020-05-31\",\"checkOutDate\":\"2020-09-07\",\"totalAmount\":12000,\"customers\":[{\"name\":\"chandan3\",\"email\":\"chandan3@gmail.com\",\"number\":\"9938161801\"}],\"rooms\":[{\"roomName\":\"sahid\",\"numberOfGuest\":4}]}";
	
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/api/placeOrders")
				.accept(MediaType.APPLICATION_JSON).content(exampleHotelJson)
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();

		assertEquals(HttpStatus.BAD_REQUEST.value(), response.getStatus());
	}
}
