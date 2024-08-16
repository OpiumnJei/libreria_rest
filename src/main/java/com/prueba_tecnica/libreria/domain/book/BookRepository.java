package com.prueba_tecnica.libreria.domain.book;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {
    Boolean existsByTitle(String title);
}
