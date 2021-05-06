package int221.shoes.int221backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class ApiHandleException {

    @ExceptionHandler(value = {ApiRequestException.class})
    public ResponseEntity<Object> handleApiRequestException(ApiRequestException e){
        System.out.println("Exception Check");
//        1. Create payload containing exception details
        HttpStatus badRequest = HttpStatus.NOT_FOUND;
        ApiException apiException = new ApiException(
                e.getMessage(),
                badRequest,
                ZonedDateTime.now(ZoneId.of("Z"))
        );
//        2. Return response entity
        return  new ResponseEntity<>(apiException, HttpStatus.BAD_REQUEST);
    }
}