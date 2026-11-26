package dev.echoforge.rest.libros.repository;

import dev.echoforge.rest.libros.entity.LibroEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepository extends JpaRepository<LibroEntity, Integer> {

}
