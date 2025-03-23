package mg.app.crm.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler 
{
    @ExceptionHandler(ApiErrorException.class)
    public ResponseEntity<String> handleApiErrorException(ApiErrorException ex) 
    {
        switch (ex.getErrorResult().getCode()) {
            case 400:
                return new ResponseEntity<>(ex.getErrorResult().getMessage(), HttpStatus.BAD_REQUEST);
            case 401:
                return new ResponseEntity<>(ex.getErrorResult().getMessage(), HttpStatus.UNAUTHORIZED);
            case 403:
                return new ResponseEntity<>(ex.getErrorResult().getMessage(), HttpStatus.FORBIDDEN);
            case 404:
                return new ResponseEntity<>(ex.getErrorResult().getMessage(), HttpStatus.NOT_FOUND);
            case 409:
                return new ResponseEntity<>(ex.getErrorResult().getMessage(), HttpStatus.CONFLICT);
            case 500:
                return new ResponseEntity<>(ex.getErrorResult().getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            default:
                return new ResponseEntity<>(ex.getErrorResult().getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGenericException(Exception ex) 
    {
        ex.printStackTrace();
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}