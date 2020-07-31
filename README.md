# hotelPlaceOrder
This applicartion is a rest api service used to book the hotel.
Objective of application:-To Book a Hotel with hotel, customer and rooms details.
STEPS TO RUN:-
   required software/technology - Eclipse, Spring Boot, Java8, mysql, postman
   steps:- 1. configure all the above software and technology
   	   2. download the project from the GITHUB and configure in the local machine.
	   3. create a database and configure the username and password.
	   4. start in local machine using eclipse and try to make request of rest POST call using POSTMAN
	   5. check according to the below json format.
POST URI:- localhost:8080/api/placeOrders
JSON SRUCTURE:-
Case 1:- for successfully placing orders return 201
{
		"hotelName":"Pearl Bridge",
		"checkInDate":"2020-08-31",
		"checkOutDate":"2020-09-07",
		"totalAmount": 15000,
		"customers":[
			{
				"name":"chandan",
				"email":"chandanjena706@gmail.com",
				"number":"9938161870"
			}
		],
		"rooms":[
			{
				"roomName":"PB00100",
				"numberOfGuest":4
			}
		]
}

Case 2:- validation when hotelName is null return 400

{
		"hotelName": null,
		"checkInDate":"2020-08-31",
		"checkOutDate":"2020-09-07",
		"totalAmount": 15000,
		"customers":[
			{
				"name":"chandan",
				"email":"chandanjena706@gmail.com",
				"number":"9938161870"
			}
		],
		"rooms":[
			{
				"roomName":"PB00100",
				"numberOfGuest":4
			}
		]
}


Case 3:- validation when email is invalid return 400

{
		"hotelName": null,
		"checkInDate":"2020-08-31",
		"checkOutDate":"2020-09-07",
		"totalAmount": 15000,
		"customers":[
			{
				"name":"chandan",
				"email":"chandanjenacom",
				"number":"9938161870"
			}
		],
		"rooms":[
			{
				"roomName":"PB00100",
				"numberOfGuest":4
			}
		]
}

Case 4:- validation when roomName is null return 400

{
		"hotelName": null,
		"checkInDate":"2020-08-31",
		"checkOutDate":"2020-09-07",
		"totalAmount": 15000,
		"customers":[
			{
				"name":"chandan",
				"email":"chandanjena@gmail.com",
				"number":"9938161870"
			}
		],
		"rooms":[
			{
				"roomName": null,
				"numberOfGuest":4
			}
		]
}
Reverse Engineering:-
https://drive.google.com/file/d/14wksE_4UrjqRCdVynkSrse7FtjYOK9aY/view?usp=sharing



Note :- In this branch v1 I have added a new test file for service class.
