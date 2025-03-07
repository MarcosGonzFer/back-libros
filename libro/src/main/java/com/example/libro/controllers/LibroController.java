package com.example.libro.controllers;

import com.example.libro.entities.Libro;
import com.example.libro.services.LibroServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/libro")
public class LibroController {
    @Autowired
    LibroServiceImp libroServiceImp;

    @PostMapping
    public ResponseEntity<Libro> guardarLibro(@RequestBody Libro libro) {
        try {
            Libro saveLibro = libroServiceImp.guardarLibro(libro);
            return new ResponseEntity<>(saveLibro, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<Libro> actualizarLibro(@PathVariable Long id, @RequestBody Libro libro) {
        try {
            libro.setId(id);
            Libro saveLibro = libroServiceImp.actualizarLibro(libro);
            return new ResponseEntity<>(saveLibro, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping
    public ResponseEntity<List<Libro>> listarLibros() {
        return new ResponseEntity<>(libroServiceImp.listarLibros(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Libro> buscarLibro(@PathVariable Long id) {
        Optional<Libro> libro = libroServiceImp.buscarLibro(id);
        if (libro.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(libro.get(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Libro> eliminarLibro(@PathVariable Long id) {
        Optional<Libro> libro = libroServiceImp.buscarLibro(id);
        if (libro.isPresent()) {
            libroServiceImp.eliminarLibro(libro.get().getId());
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
