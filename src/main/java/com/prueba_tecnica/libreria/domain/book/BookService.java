package com.prueba_tecnica.libreria.domain.book;

import com.prueba_tecnica.libreria.infra.errors.DuplicateBookException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService {

    //mensaje por default para el error 404
    private String messageEntityNotFound = "Libro no encontrado";
    @Autowired
    private BookRepository bookRepository;

    ///guarda libros
    public void guardarLibro(SaveBooks saveBooks){
        //se valida que no pueden existir dos libros con el mismo titulo
        var verificarLibro = bookRepository.existsByTitle(saveBooks.title());

        if(verificarLibro){
            throw new DuplicateBookException("Ya existe un libro con el mismo titulo");
        }
        bookRepository.save(new Book(saveBooks));
    }

    //listar libros
    public Page<Book> listarLibros(Pageable pageable){
       return bookRepository.findAll(pageable);
    }

    ///listar libro por id
    public ResponseBook listarLibroId(Long id){
       Book book = bookRepository.findById(id)
               .orElseThrow(() -> new EntityNotFoundException(messageEntityNotFound));

        return new ResponseBook(book.getId(), book.getTitle(),book.getFecha(),book.getAuthor(),book.getGender());
    }

    //actualizar un libro
    public Book actualizarLibro(Long id, UpdateBook updateBook){

        //busca el libro, sino lo encuentra retorna una exception
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(messageEntityNotFound));

        //actualizar
        if(updateBook.title() != null){
            book.title = updateBook.title();
        }
        if(updateBook.fecha() != null){
            book.fecha = updateBook.fecha();
        }
        if(updateBook.author() != null){
            book.author = updateBook.author();
        }
        if(updateBook.gender() != null){
            book.gender = updateBook.gender();
        }

        return bookRepository.save(book);
    }

    ///eliminar un libro
    public void eliminarLibro(Long id){
        var libroEncontrado = bookRepository.existsById(id);

        if (!libroEncontrado) {
            throw new EntityNotFoundException("Libro con id " + id + " no encontrado");
        }
        
        bookRepository.deleteById(id);
    }

}
