package com.prueba_tecnica.libreria.infra.errors;

//excepcion para tratar libros con el mismo titulo
public class DuplicateBookException extends RuntimeException {
    public DuplicateBookException(String mensaje) {
        super(mensaje);
    }
}
