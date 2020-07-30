package com.chandan.PlaceOrder.exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
public class ErrorDetails {
	private LocalDateTime exceptionDateTime;
	private String message;
	private String details;
}
