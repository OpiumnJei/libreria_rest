package com.prueba_tecnica.libreria.domain.book;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record SaveBooks(

        Long id,
        @NotBlank
        String title,
        @NotNull
        LocalDateTime fecha,
        @NotBlank
        String author,
        @NotNull
        Gender gender
) {
}
