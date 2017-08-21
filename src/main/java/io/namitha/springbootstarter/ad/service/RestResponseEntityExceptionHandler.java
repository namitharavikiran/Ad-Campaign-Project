package io.namitha.springbootstarter.ad.service;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


import io.namitha.springbootstarter.ad.model.CustomException;
import io.namitha.springbootstarter.ad.model.ExceptionResponse;

@ControllerAdvice
public class RestResponseEntityExceptionHandler
{
	@ExceptionHandler(value =Exception.class)
    public ResponseEntity<ExceptionResponse> generalException(Exception ex) throws Exception
	{
		ExceptionResponse er = new ExceptionResponse();
		er.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		er.setDescription(ex.getMessage());
        return new ResponseEntity<ExceptionResponse>(er, HttpStatus.INTERNAL_SERVER_ERROR);
    } 
	
	@ExceptionHandler(value =CustomException.class)
    public ResponseEntity<ExceptionResponse> handleNoActiveCampaignsException(CustomException ex) throws Exception
	{
		ExceptionResponse er = new ExceptionResponse();
		er.setCode(HttpStatus.BAD_REQUEST.value());
		er.setDescription("No Active Campigns for this partner");
        return new ResponseEntity<ExceptionResponse>(er, HttpStatus.BAD_REQUEST);
    } 
}
