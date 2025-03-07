package com.example.libro.services;

import com.example.libro.entities.Libro;

import java.util.List;
import java.util.Optional;

public interface LibroService {
    Libro guardarLibro(Libro libro);
    Libro actualizarLibro(Libro libro);
    List<Libro> listarLibros();
    Optional<Libro> buscarLibro(Long id);
    void eliminarLibro(Long id);
}
