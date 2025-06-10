-- my_database.admi_pais definition

CREATE TABLE my_database.admi_pais (
	idPais INT auto_increment NOT NULL COMMENT 'ID DE LA TABLA ADMI_PAIS' PRIMARY KEY,
	pais varchar(63) NULL COMMENT 'Nombre del país',
	feCreacion DATE NULL COMMENT 'Fecha de creación',
	usrCreacion varchar(127) NULL COMMENT 'Usuario de creación',
	estado varchar(15) NULL COMMENT 'Estado de la tabla admi_pais',
	feUltModificacion DATE NULL COMMENT 'Fecha de última modificación',
	usrUltModificacion varchar(15) NULL COMMENT 'Usuario de última modificación'
)
ENGINE=InnoDB
DEFAULT CHARSET=latin1
COLLATE=latin1_swedish_ci;
DROP TABLE IF EXISTS my_database.admi_pais;