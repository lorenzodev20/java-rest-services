package dev.echoforge.rest.libros.controller;

import dev.echoforge.rest.libros.entity.LibroEntity;
import dev.echoforge.rest.libros.repository.LibroRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/libros")
public class LibroController {
    final private LibroRepository libroRepository;

    public LibroController(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    @GetMapping
    public LibroEntity getLibro() {
        return libroRepository.findById(1)
                .orElseThrow(() -> new RuntimeException("Libro no encontrado"));
    }

    @GetMapping("/listar")
    public List<LibroEntity> getLibros() {
        return libroRepository.findAll();
    }
}
