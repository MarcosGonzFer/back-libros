package com.example.libro.controllers;

import com.example.libro.entities.Capitulo;
import com.example.libro.services.CapituloServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/capitulo")
public class CapituloController {

    @Autowired
    private CapituloServiceImp capituloServiceImp;

    @PostMapping
    public ResponseEntity<Capitulo> guardarCapitulo(@RequestBody Capitulo capitulo) {
        try {
            Capitulo nuevoCapitulo = capituloServiceImp.guardarCapitulo(capitulo);
            return new ResponseEntity<>(nuevoCapitulo, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Capitulo> actualizarCapitulo(@PathVariable Long id, @RequestBody Capitulo capitulo) {
        try {
            capitulo.setId(id);
            Capitulo updatedCapitulo = capituloServiceImp.actualizarCapitulo(capitulo);
            return new ResponseEntity<>(updatedCapitulo, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<List<Capitulo>> listarCapitulos() {
        return new ResponseEntity<>(capituloServiceImp.listarCapitulos(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Capitulo> buscarCapitulo(@PathVariable Long id) {
        Optional<Capitulo> capitulo = capituloServiceImp.buscarCapitulo(id);
        if (capitulo.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(capitulo.get(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCapitulo(@PathVariable Long id) {
        Optional<Capitulo> capitulo = capituloServiceImp.buscarCapitulo(id);
        if (capitulo.isPresent()) {
            capituloServiceImp.eliminarCapitulo(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
