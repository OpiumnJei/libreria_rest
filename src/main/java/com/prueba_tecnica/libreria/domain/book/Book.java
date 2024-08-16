package com.prueba_tecnica.libreria.domain.book;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "books")
@Entity(name = "Book")
@Getter
@NoArgsConstructor
//@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String title;
    LocalDateTime fecha;
    String author;
    @Enumerated(EnumType.STRING)
    Gender gender;

//guardar libros
    public Book(SaveBooks saveBooks) {
        this.title = saveBooks.title();
        this.fecha = saveBooks.fecha();
        this.author = saveBooks.author();
        this.gender = saveBooks.gender();
    }
    
}
