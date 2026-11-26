package dev.echoforge.rest.libros.controller;

import dev.echoforge.rest.libros.entity.LibroEntity;
import dev.echoforge.rest.libros.repository.LibroRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/libros")
public class LibroController {
    final private LibroRepository libroRepository;

    public LibroController(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    @GetMapping
    public List<LibroEntity> findAll() {
        return libroRepository.findAllActivos();
    }

    @GetMapping("/{id}")
    public LibroEntity findById(@PathVariable("id") Integer id) {
        return libroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Libro no encontrado"));
    }

    @GetMapping("/{id}/{estado}")
    public LibroEntity findById(@PathVariable("id") Integer id, @PathVariable("estado") String estado) {
        return libroRepository.findByIdAndEstado(id, estado).orElse(null);
    }

    @GetMapping("/by-estado")
    public List<LibroEntity> findByEstado(@RequestParam("estado") String estado) {
        return libroRepository.findByEstado(estado);
    }

    @GetMapping("/by-titulo")
    public List<LibroEntity> findByTitulo(@RequestParam("titulo") String titulo) {
        return libroRepository.findByTituloLikeIgnoreCaseAndEstado("%" + titulo + "%", "1");
    }

    @GetMapping("/v2/by-titulo")
    public List<LibroEntity> findByTituloJpql(@RequestParam("titulo") String titulo) {
        return libroRepository.findByTituloJPQL("%" + titulo + "%");
    }

    @GetMapping("/v3/by-titulo")
    public List<LibroEntity> findByTituloSql(@RequestParam("titulo") String titulo) {
        return libroRepository.findByLikeTituloSQL("%"+titulo+"%");
    }

    @GetMapping("/by-titulo-estado")
    public List<LibroEntity> findByTituloEstado(@RequestParam("titulo") String titulo,
                                                @RequestParam(value = "estado", defaultValue = "1") String estado) {
        //return libroRepository.findByTituloLikeIgnoreCaseAndEstado("%" + titulo + "%", estado);
        return libroRepository.findByTituloJPQL("%" + titulo + "%");
        //return libroRepository.findByLikeTituloSQL("%"+titulo+"%");
    }

    @PostMapping
    public LibroEntity save(@RequestBody LibroEntity libroEntity) {
        return libroRepository.save(libroEntity);
    }

    @PutMapping("/{id}")
    public LibroEntity update(@PathVariable("id") Integer id,
                              @RequestBody LibroEntity libroEntity) {
        if (!libroRepository.existsById(id)) {
            throw new RuntimeException("Libro no encontrado");
        }
        libroEntity.setId(id);
        return libroRepository.save(libroEntity);
    }

    @PatchMapping("/{id}")
    public LibroEntity updateNroPaginas(@PathVariable("id") Integer id,
                                        @RequestParam("nroPaginas") int nroPaginas) {
        LibroEntity libroEntity = libroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Libro no encontrado"));
        libroEntity.setNroPaginas(nroPaginas);
        return libroRepository.save(libroEntity);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        // Metodo para eliminar un libro de manera física (eliminación real de la base de datos)
        /*
        if (!libroRepository.existsById(id)) {
            throw new RuntimeException("Libro no encontrado");
        }
        libroRepository.deleteById(id); // Fisico
        */
        // Metodo para eliminar un libro de manera lógica (cambiar el estado del libro a "0" o "inactivo")
        /*
        LibroEntity libroEntity = libroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Libro no encontrado"));
        libroEntity.setEstado("0");
        libroRepository.save(libroEntity);
         */
        // Metodo para eliminar un libro de manera lógica (cambiar el estado del libro a "0" o "inactivo") usando una consulta nativa
        if (!libroRepository.existsById(id)) {
            throw new RuntimeException("Libro no encontrado");
        }
        libroRepository.deleteLogic(id);
    }

    @PatchMapping("/activate/{id}")
    public void activate(@PathVariable("id") Integer id) {
        LibroEntity libroEntity = libroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Libro no encontrado"));
        libroEntity.setEstado("1");
        libroRepository.save(libroEntity);
    }
}
