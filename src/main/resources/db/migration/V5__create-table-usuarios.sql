
CREATE TABLE IF NOT EXISTS usuarios (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    correo_electronico VARCHAR(100) NOT NULL,
    contrasena VARCHAR(100) NOT NULL,
    perfil_id INT,
    FOREIGN KEY (perfil_id) REFERENCES perfiles(id)
);