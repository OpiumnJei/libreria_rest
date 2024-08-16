package com.prueba_tecnica.libreria.domain.book;

import java.time.LocalDateTime;

public record ListBooks(Long id, String title, LocalDateTime fecha, String author, Gender gender) {
    public ListBooks(Book book){
        this(book.id, book.title,book.fecha,book.author,book.gender);
    }
}
