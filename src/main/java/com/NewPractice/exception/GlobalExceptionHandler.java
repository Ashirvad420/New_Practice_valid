package com.NewPractice.exception;

import com.NewPractice.payload.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(

            ResourceNotFoundException e,
            WebRequest webRequest
    )
    {
     ErrorDetails errorDetails = new ErrorDetails(e.getMessage(),new Date(),webRequest.getDescription(true));
             return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}



// ResponseEntityExceptionHandler :- it send the Response back to postman
// Catch Block banane ke liye @ContrllerAdvice ka use krte hai and ye exception bhi handle krta hai
// getDescription:- it takes the boolean value

