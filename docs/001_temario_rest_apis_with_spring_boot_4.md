# REST APIs with Spring Boot 4
---

## Sesión 01: Primer API REST con Spring Boot 4
* **Temas:**
  * Fundamentos REST: recursos, URIs, métodos HTTP y códigos de estado.
  * Novedades de Spring Boot 4 y Spring Framework 7 (Java 25, Jakarta EE 11).
  * Creación del proyecto con Spring Initializr (Maven) en IntelliJ IDEA / STS.
  * Primer servicio con `@RestController`: CRUD en memoria.
  * Pruebas del servicio con Postman y cURL.

---

## Sesión 02: Controladores y DTOs
* **Temas:**
  * Mapeos HTTP: `@GetMapping`, `@PostMapping`, `@PutMapping`, `@PatchMapping` y `@DeleteMapping`.
  * Parámetros: `@PathVariable`, `@RequestParam`, `@RequestHeader` y `@RequestBody`.
  * DTOs con Java records y serialización JSON con Jackson 3.
  * `ResponseEntity`, códigos de estado y cabeceras de respuesta.
  * Versionado de APIs con el soporte nativo de Spring Boot 4.

---

## Sesión 03: Persistencia con Spring Data JPA
* **Temas:**
  * Arquitectura en capas: Controller, Service y Repository.
  * Entidades JPA y mapeo con Hibernate 7.
  * Configuración del datasource con Oracle (PostgreSQL opcional).
  * `JpaRepository` y operaciones CRUD contra la base de datos.
  * Relaciones maestro-detalle (`@OneToMany` / `@ManyToOne`) y transacciones.

---

## Sesión 04: Consultas, paginación y ordenamiento
* **Temas:**
  * Query methods y consultas con `@Query` (JPQL y SQL nativo).
  * Servicios paginados con `Pageable` y `Page`.
  * Ordenamiento dinámico con `Sort` desde parámetros de la URL.
  * Proyecciones y mapeo entidad $\leftrightarrow$ DTO.
  * Filtros de búsqueda combinados.

---

## Sesión 05: Validación y manejo de errores
* **Temas:**
  * Bean Validation: `@NotNull`, `@Size`, `@Email`, `@Valid` y validaciones personalizadas.
  * Excepciones de negocio propias.
  * Manejo global de errores con `@RestControllerAdvice` y `@ExceptionHandler`.
  * Respuestas de error estándar con `ProblemDetail` (RFC 9457).
  * Buenas prácticas: mensajes claros y códigos HTTP correctos.