package grupo7.proyectoIntegrador.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ApplicationHandlerException extends ResponseEntityExceptionHandler {


    /**
     * handleMethodArgumentNotValid (Argumentos en el RequestDto no validos) - (Spring-Validation)
     */
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {

        Map<String, String> errorsMap = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errorsMap.put(fieldName, errorMessage);
        });

        ExceptionResponse er = ExceptionResponse.builder()
                .fecha(LocalDateTime.now())
                .mensaje(errorsMap.toString())
                .detalle(request.getDescription(false))
                .build();

        return new ResponseEntity<Object>(er, HttpStatus.BAD_REQUEST);
    }

    /**
     * CategoryNotFoundException.class
     *
     * @param e
     * @return
     */
    @ExceptionHandler(ElementNotFoundException.class)
    public ResponseEntity<?> categoriaNoEncontrada(Exception e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(e.getMessage());
    }

    /**
     * ExistingCategoryException.class
     *
     * @param e
     * @return
     */
    @ExceptionHandler(ExistingException.class)
    public ResponseEntity<?> categoriaExistenteEnBd(Exception e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(e.getMessage());
    }

    public final ResponseEntity<ExceptionResponse> manejarTodasExcepciones(Exception ex, WebRequest request) {

        ExceptionResponse er = ExceptionResponse.builder()
                .fecha(LocalDateTime.now())
                .mensaje(ex.getMessage().toString())
                .detalle(request.getDescription(false))
                .build();

        return new ResponseEntity<ExceptionResponse>(er, HttpStatus.INTERNAL_SERVER_ERROR);

    }

}
