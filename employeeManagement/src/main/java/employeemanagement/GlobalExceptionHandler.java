package employeemanagement;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.Map;
import java.util.LinkedHashMap;


@RestControllerAdvice // Tells spring to handle exceptions Globally across all REST controllers.
public class GlobalExceptionHandler {
    
    @ExceptionHandler (MethodArgumentNotValidException.class) // Tells Spring to immediately execute
    // the method below whenever MethodArgumentNotValidException occurs.

    public ResponseEntity<ErrorResponse> handleValidationExceptions(MethodArgumentNotValidException ex){
        Map<String,String> errors = new LinkedHashMap<>();

        ex.getBindingResult().getAllErrors().forEach((error) -> {
// getBindingResult() - gets info associated with failed request.
// getAllErrors() - gets all validation errors.     
// FieldError is a class that lets you access field details       
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        ErrorResponse errorResponse = new ErrorResponse(
            HttpStatus.BAD_REQUEST.value(),
            "Bad Request",
            "Validation failed for one or more fields.",
            errors
          );

          return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }



}
