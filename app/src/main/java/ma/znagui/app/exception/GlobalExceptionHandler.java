package ma.znagui.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> handleValidationException(MethodArgumentNotValidException e){
        Map<String,String> errors = new HashMap<>();
        e.getBindingResult().getFieldErrors().forEach(fieldError -> {
            errors.put(fieldError.getField(),fieldError.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(ResourceNotFoundExeption.class)
    public ResponseEntity<String> handelResourceNotFoundExeption(ResourceNotFoundExeption e){
       return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(IncompatibleAreaExeption.class)
    public ResponseEntity<String> handleIncompatibleAreaExeption(IncompatibleAreaExeption e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(TreeCannotBePlantedException.class)
    public ResponseEntity<String> handleTreeCannotBePlantedException(TreeCannotBePlantedException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(HarverstSeasonAlreadyExistsException.class)
    public ResponseEntity<String> handleHarverstSeasonAlreadyExistsException(HarverstSeasonAlreadyExistsException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(DateInvalideForPnating.class)
    public ResponseEntity<String> handleDateInvalideForPnating(DateInvalideForPnating e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(UnproductiveTreeException.class)
    public ResponseEntity<String> handleUnproductiveTreeException(UnproductiveTreeException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(NonMatchingField.class)
    public ResponseEntity<String> handelNonMatchingField(NonMatchingField e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(InsuffisantSaleQuantityException.class)
    public ResponseEntity<String> handelInsuffisantSaleQuantityException(InsuffisantSaleQuantityException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<String> handleTypeMismatch(MethodArgumentTypeMismatchException ex) {
        String message = String.format("Le paramètre '%s' doit être de type '%s'. Valeur reçue : '%s'.",
                ex.getName(), ex.getRequiredType().getSimpleName(), ex.getValue());
        return ResponseEntity.badRequest().body(message);
    }


}
