## Prueba tecnica: Libreria

<img src="imagen.png">

Este proyecto es una API REST desarrollada en Java con Spring Boot para gestionar libros. Permite realizar operaciones CRUD (Crear, Leer, Actualizar y Eliminar) sobre una colección de libros en una base de datos.

### Características

- **Crear** nuevos libros con título, autor, fecha de publicación, y género.
- **Listar** todos los libros con soporte para paginación.
- **Consultar** un libro por su ID.
- **Actualizar** la información de un libro.
- **Eliminar** un libro por su ID.
- Manejo de **errores** comunes como la creación de duplicados o la consulta de entidades no existentes.

### Requisitos Previos

- Java 17+
- Maven
- MySQL 8.0+

## Uso:

### Endpoints 

1. **Crear un Libro**
   - URL: `/books`
   - Método:` POST`
   

   Body:
````
{
    "title": "Título del Libro",
    "author": "Nombre del Autor",
    "fecha": "2024-08-14",
    "gender": "Género"
}
```` 
- **Respuesta:**

  - `201 Created` si el libro se ha creado exitosamente.
  - `409 Conflict` si el libro ya existe.
  
2. **Listar Todos los Libros**
   - URL: `/books`
   - Método: `GET`

- **Parámetros opcionales:**
  - page: Número de la página (por defecto 0).
  - size: Tamaño de la página (por defecto 10).
  
- **Respuesta:**
  - 200 OK con un objeto Page que contiene los libros.
  
3. **Consultar un Libro por ID**
   - URL: `/books/{id}`
   - Método: `GET`
- **Respuesta:**
   - `200 OK` con los detalles del libro.
   - `404 Not Found` si el libro no existe.
4. **Actualizar un Libro**
   - URL: `/books/{id}`
   - Método: `PUT`

Body:
````
{
   "title": "Nuevo Título del Libro",
   "author": "Nuevo Nombre del Autor",
   "fecha": "2024-08-14",
   "gender": "Nuevo Género"
}
 ````
- **Respuesta:**
  - `200 OK` si el libro se ha actualizado correctamente.
  - `404 Not Found` si el libro no existe.

5. **Eliminar un Libro**
   - URL: `/books/{id}`
   - Método: `DELETE`
- **Respuesta:**
  - `204 No Content` si el libro se ha eliminado exitosamente.
  - `404 Not Found` si el libro no existe.
