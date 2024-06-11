
CREATE TABLE respuestas (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    mensaje TEXT NOT NULL,
    topico_id INT,
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    autor VARCHAR(100) NOT NULL,
    solucion VARCHAR(100),
    FOREIGN KEY (topico_id) REFERENCES topicos(id)
);