INSERT INTO libros (id, titulo, resumen, nro_paginas, estado)
VALUES (1, 'Clean Code', 'Guía práctica para escribir código legible, mantenible y limpio en software.', 464, '1'),
       (2, 'Domain-Driven Design', 'Enfoque para modelar sistemas complejos alineando el código con el dominio del negocio.', 560, '0'),
       (3, 'Effective Java', 'Buenas prácticas esenciales y patrones idiomáticos para programar en Java.', 416, '1'),
       (4, 'Designing Data-Intensive Applications', 'Fundamentos de sistemas distribuidos, almacenamiento, replicación y procesamiento de datos.', 616, '1'),
       (5, 'Refactoring', 'Técnicas sistemáticas para mejorar el diseño de código existente sin alterar su comportamiento.', 448, '0'),
       (6, 'The Pragmatic Programmer', 'Principios y hábitos prácticos para el desarrollo profesional de software.', 352, '1'),
       (7, 'Spring in Action', 'Introducción y guía práctica al ecosistema Spring y desarrollo de aplicaciones empresariales.', 520, '0'),
       (8, 'Database Internals', 'Arquitectura interna de motores de almacenamiento, índices, transacciones y consenso.', 376, '1'),
       (9, 'Head First Design Patterns', 'Explicación visual y práctica de los patrones de diseño orientados a objetos.', 694, '0'),
       (10, 'Microservices Patterns', 'Patrones arquitectónicos para diseñar, desplegar y mantener arquitecturas de microservicios.', 520, '1');

ALTER TABLE libros ALTER COLUMN id RESTART WITH 11;