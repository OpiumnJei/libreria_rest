package com.prueba_tecnica.libreria.infra.errors;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

///se usa para capturar excepciones personalizadas y enviar los Http Status code correctos
@RestControllerAdvice
public class TratarExcepciones {

    //tratar el error 409, titulos duplicados
    @ExceptionHandler(DuplicateBookException.class)
    public ResponseEntity tratarError409(Exception e){
        //se escoge el status code, y se pasa el mensaje colocado en la exception
        return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
    }

    //error 400 quiere decir que hay un error en el lado del cliente a la hora de llenar los campos
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity tratarError400(MethodArgumentNotValidException e){
        var errores = e.getFieldErrors()
                .stream()
                .map(DatosErrorValidacion::new).toList();

        return ResponseEntity.badRequest().body(errores);
    }

    //tratar el error 404, entidad no encontrada
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity tratarError404(Exception e){
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }


    //record para mapear errores, usado para tratar el error 400
    private record DatosErrorValidacion(String campo, String error){
        public DatosErrorValidacion(FieldError error) {
            this(error.getField(), error.getDefaultMessage());
        }
    }

}
