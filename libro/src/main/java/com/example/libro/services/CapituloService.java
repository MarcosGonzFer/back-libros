package com.example.libro.services;

import com.example.libro.entities.Capitulo;

import java.util.List;
import java.util.Optional;

public interface CapituloService {
    Capitulo guardarCapitulo(Capitulo capitulo);
    Capitulo actualizarCapitulo(Capitulo capitulo);
    List<Capitulo> listarCapitulos();
    Optional<Capitulo> buscarCapitulo(Long id);
    void eliminarCapitulo(Long id);
}
