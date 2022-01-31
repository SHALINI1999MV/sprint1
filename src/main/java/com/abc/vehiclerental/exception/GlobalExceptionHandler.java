package com.abc.vehiclerental.exception;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.abc.vehiclerental.payload.ErrorResponse;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = AuthenticationFailureException.class)
	public ResponseEntity<ErrorResponse> handleAuthenticationFailureException(Exception e) {
		ErrorResponse errorResp = new ErrorResponse();
		errorResp.setError(e.getMessage());
		errorResp.setStatus(HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<>(errorResp, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = ResourceNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleResourceNotFoundException(Exception e) {
		ErrorResponse errorResp = new ErrorResponse();
		errorResp.setError(e.getMessage());
		errorResp.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<>(errorResp, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = ResourceAlreadyExistingException.class)
	public ResponseEntity<ErrorResponse> handleResourceAlreadyExistingException(Exception e) {
		ErrorResponse errorResp = new ErrorResponse();
		errorResp.setError(e.getMessage());
		errorResp.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		return new ResponseEntity<>(errorResp, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	// bean validation exceptions are handled here
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		Map<String, Object> body = new LinkedHashMap<>();

		body.put("status", status.value());

		// Gets all errors
		List<String> errors = ex.getBindingResult().getFieldErrors().stream().map(x -> x.getDefaultMessage())
				.collect(Collectors.toList());

		body.put("errors", errors);

		return new ResponseEntity<>(body, headers, status);
	}
}
