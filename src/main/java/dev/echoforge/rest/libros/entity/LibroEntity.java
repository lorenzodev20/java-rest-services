package dev.echoforge.rest.libros.entity;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;

@JsonPropertyOrder({"id", "titulo", "resumen", "nroPaginas", "estado"})
@Table(name = "libros") // SQL
@Entity(name = "LibroEntity")// JPQL - Java Persistency Query Language - Recomendado
public class LibroEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String titulo;
    private String resumen;
    private int nroPaginas;
    private String estado;

    public LibroEntity() {
    }

    public LibroEntity(String titulo, String resumen, Integer nroPaginas, String estado) {
        this.titulo = titulo;
        this.resumen = resumen;
        this.nroPaginas = nroPaginas;
        this.estado = estado;
    }


    public LibroEntity(Integer id, String titulo, String resumen, Integer nroPaginas, String estado) {
        this.id = id;
        this.titulo = titulo;
        this.resumen = resumen;
        this.nroPaginas = nroPaginas;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getResumen() {
        return resumen;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    public int getNroPaginas() {
        return nroPaginas;
    }

    public void setNroPaginas(int nroPaginas) {
        this.nroPaginas = nroPaginas;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", resumen='" + resumen + '\'' +
                ", nroPaginas=" + nroPaginas +
                ", estado='" + estado + '\'' +
                '}';
    }
}
