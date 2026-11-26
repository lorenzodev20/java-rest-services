package dev.echoforge.rest.libros.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "libros")
@Entity
public class LibroEntity {
    @Id
    private int id;
    private String titulo;
    private String resumen;
    private int nroPaginas;
    private String estado;

    public LibroEntity() {
    }

    public LibroEntity(String titulo, String resumen, int nroPaginas, String estado) {
        this.titulo = titulo;
        this.resumen = resumen;
        this.nroPaginas = nroPaginas;
        this.estado = estado;
    }


    public LibroEntity(int id, String titulo, String resumen, int nroPaginas, String estado) {
        this.id = id;
        this.titulo = titulo;
        this.resumen = resumen;
        this.nroPaginas = nroPaginas;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
