package com.eas.custom_exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiExceptionPayload> handleResourceNotFoundException(ResourceNotFoundException e) {
		HttpStatus badRequest = HttpStatus.NOT_FOUND;
		ApiExceptionPayload apiExceptionPayload = new ApiExceptionPayload(
				e.getMessage(),
				badRequest,
				badRequest.value(),
				getCurrentLocalDateTime());
		return new ResponseEntity<>(apiExceptionPayload, badRequest);
	}
	
	@ExceptionHandler(InternalServerError.class)
	public ResponseEntity<ApiExceptionPayload> handleInternalServerException(InternalServerError e) {
		HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
		ApiExceptionPayload apiExceptionPayload = new ApiExceptionPayload(
				e.getMessage(),
				status,
				status.value(),
				getCurrentLocalDateTime());
		return new ResponseEntity<>(apiExceptionPayload, status);
	}
	
	@ExceptionHandler(BadRequest.class)
	public ResponseEntity<ApiExceptionPayload> badRequestException(BadRequest e) {
		HttpStatus badRequest = HttpStatus.BAD_REQUEST;
		ApiExceptionPayload apiExceptionPayload = new ApiExceptionPayload(
				e.getMessage(),
				badRequest,
				badRequest.value(),
				getCurrentLocalDateTime());
		return new ResponseEntity<>(apiExceptionPayload, badRequest);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ApiExceptionPayload> handleUserNotFoundException(UserNotFoundException ex) {
		HttpStatus notFound = HttpStatus.NOT_FOUND;
		ApiExceptionPayload error = new ApiExceptionPayload(
				ex.getMessage(),
				notFound,
				notFound.value(),
				getCurrentLocalDateTime());
        return new ResponseEntity<>(error, notFound);
    }

    @ExceptionHandler(PasswordMismatchException.class)
    public ResponseEntity<ApiExceptionPayload> handlePasswordMismatchException(PasswordMismatchException ex) {
    	HttpStatus unAuthorized = HttpStatus.UNAUTHORIZED;
    	ApiExceptionPayload error = new ApiExceptionPayload(
    			ex.getMessage(),
    			unAuthorized,
    			unAuthorized.value(),
    			getCurrentLocalDateTime());
        return new ResponseEntity<>(error, unAuthorized);
    }
    
    
    
    @ExceptionHandler(UserRoleNotFound.class)
    public ResponseEntity<ApiExceptionPayload> handleUserRoleNotFoundException(UserRoleNotFound ex) {
    	HttpStatus notFound = HttpStatus.NOT_FOUND;
		ApiExceptionPayload error = new ApiExceptionPayload(
				ex.getMessage(),
				notFound,
				notFound.value(),
				getCurrentLocalDateTime());
        return new ResponseEntity<>(error, notFound);
    }
    
    @ExceptionHandler(AccountValidationException.class)
    public ResponseEntity<ApiExceptionPayload> handleUserRoleNotFoundException(AccountValidationException ex) {
    	HttpStatus notFound = HttpStatus.BAD_REQUEST;
		ApiExceptionPayload error = new ApiExceptionPayload(
				ex.getMessage(),
				notFound,
				notFound.value(),
				getCurrentLocalDateTime());
        return new ResponseEntity<>(error, notFound);
    }
    
    
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ApiExceptionPayload> handleValidationException(MethodArgumentNotValidException ex) {
      String errorMessage = ex.getBindingResult().getFieldErrors().get(0).getDefaultMessage();
      
      HttpStatus notFound = HttpStatus.BAD_REQUEST;
		ApiExceptionPayload error = new ApiExceptionPayload(
				errorMessage,
				notFound,
				notFound.value(),
				getCurrentLocalDateTime());
      return new ResponseEntity<>(error, notFound);
  }
  
  
//  @ExceptionHandler(AccessDeniedException.class)
//  public ResponseEntity<ApiExceptionPayload> handleAccessDeniedException(AccessDeniedException ex) {
//      //return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Access denied: " + ex.getMessage());
//      System.out.println("log->> "+ex.getMessage());
//      HttpStatus forbidden = HttpStatus.FORBIDDEN;
//		ApiExceptionPayload error = new ApiExceptionPayload(
//				ex.getMessage(),
//				forbidden,
//				forbidden.value(),
//				getCurrentLocalDateTime());
//    return new ResponseEntity<>(error, forbidden);
//      
//  }
  
//  @ExceptionHandler(ConstraintViolationException.class)
//  public ResponseEntity<ApiExceptionPayload> handleAccessDeniedException(ConstraintViolationException ex) {
//      HttpStatus forbidden = HttpStatus.BAD_REQUEST;
//		ApiExceptionPayload error = new ApiExceptionPayload(
//				ex.getMessage(),
//				forbidden,
//				forbidden.value(),
//				getCurrentLocalDateTime());
//    return new ResponseEntity<>(error, forbidden);
//      
//  }
  

    
    
    
    
    
    private LocalDateTime getCurrentLocalDateTime() {
    	return LocalDateTime.now();
    }
	
	
}
