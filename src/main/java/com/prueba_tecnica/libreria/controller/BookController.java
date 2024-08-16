package com.prueba_tecnica.libreria.controller;

import com.prueba_tecnica.libreria.domain.book.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService service;

    @PostMapping
    public ResponseEntity saveBook(@RequestBody @Valid SaveBooks saveBooks){
        service.guardarLibro(saveBooks);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Page<ListBooks>> listBook(Pageable pageable){

        return ResponseEntity.ok( service.listarLibros(pageable).map(ListBooks::new));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseBook> listBookById(@PathVariable Long id){
       var dataBook = service.listarLibroId(id);

        return ResponseEntity.ok(dataBook);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity updateBook(@PathVariable Long id, @RequestBody UpdateBook  updateBook){

        return ResponseEntity.ok(service.actualizarLibro(id, updateBook));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteBook(@PathVariable Long id){
        service.eliminarLibro(id);

        return ResponseEntity.noContent().build();
    }

}
