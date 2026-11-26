package dev.echoforge.rest.libros.repository;

import dev.echoforge.rest.libros.entity.LibroEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface LibroRepository extends JpaRepository<LibroEntity, Integer> {

    List<LibroEntity> findByEstado(String estado);

    List<LibroEntity> findByTituloLikeIgnoreCaseAndEstado(String titulo, String estado);

    //JPQL (Java Persistence Query Language) - Recomendado (ORM)
    @Query(value = "SELECT l FROM LibroEntity l " +
            " WHERE upper(l.titulo) LIKE upper(:titulo) and l.estado = '1'")
    List<LibroEntity> findByTituloJPQL(@Param("titulo") String titulo);

    // SQL - Datos nativos de la base de datos
    @Query(value = "SELECT * FROM libros l " +
            "WHERE upper(l.titulo) LIKE upper(:titulo) and l.estado = '1'", nativeQuery = true)
    List<LibroEntity> findByLikeTituloSQL(@Param("titulo") String titulo);

    Optional<LibroEntity> findByIdAndEstado(Integer id, String estado);

    @Query(value = "SELECT l FROM LibroEntity l " +
            " WHERE l.estado = '1'")
    List<LibroEntity> findAllActivos();

    @Transactional
    @Modifying
    @Query(value = "UPDATE libros SET estado = '0' WHERE id = :id", nativeQuery = true)
    void deleteLogic(Integer id);
}
