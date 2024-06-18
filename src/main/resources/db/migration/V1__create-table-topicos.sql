
CREATE TABLE IF NOT EXISTS topico (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    mensaje TEXT,
    fecha_creacion DATE,
    status TINYINT DEFAULT 1,
    autor VARCHAR(100),
    curso_id BIGINT,
    respuestas_id BIGINT,
    FOREIGN KEY (curso_id) REFERENCES curso(id),
    FOREIGN KEY (respuestas_id) REFERENCES respuesta(id)
);