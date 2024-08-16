package com.prueba_tecnica.libreria.domain.book;

import java.time.LocalDateTime;

public record UpdateBook(Long id, String title, LocalDateTime fecha, String author, Gender gender) {
}
