package com.example.libro.services;

import com.example.libro.entities.Capitulo;
import com.example.libro.repositories.CapituloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CapituloServiceImp implements CapituloService {

    @Autowired
    private CapituloRepository capituloRepository;

    @Override
    public Capitulo guardarCapitulo(Capitulo capitulo) {
        return capituloRepository.save(capitulo);
    }

    @Override
    public Capitulo actualizarCapitulo(Capitulo capitulo) {
        return capituloRepository.save(capitulo);
    }

    @Override
    public List<Capitulo> listarCapitulos() {
        return capituloRepository.findAll();
    }

    @Override
    public Optional<Capitulo> buscarCapitulo(Long id) {
        return capituloRepository.findById(id);
    }

    @Override
    public void eliminarCapitulo(Long id) {
        capituloRepository.deleteById(id);
    }

}
