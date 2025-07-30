CREATE TABLE rentaVehiculos.info_renta (
    id_renta INT PRIMARY KEY AUTO_INCREMENT,
    dni VARCHAR(15) NOT NULL,
    nombres VARCHAR(127) NOT NULL,
    modelo VARCHAR(63) NOT NULL,
    marca VARCHAR(63) NOT NULL,
    fe_nacimiento DATE NOT NULL,
    tiene_tc VARCHAR(3) NOT NULL,
    usr_creacion varchar(63),
    fe_creacion date,
    estado varchar(15),
    fecha_modificacion date,
    usr_modificacion varchar(63)
);
