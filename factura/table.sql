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

CREATE TABLE my_database.info_items (
	idItems INT auto_increment NOT NULL COMMENT 'ID DE LA TABLA INFO_ITEMS' PRIMARY KEY,
	uuid VARCHAR(36) NOT NULL COMMENT 'UUID del items',
	nombreProducto varchar(63) NULL COMMENT 'Nombre del items',
	cantidad INT NULL COMMENT 'Cantidad del items',
	precio DECIMAL(10,2) NULL COMMENT 'Precio del items',
	feCreacion DATE NULL COMMENT 'Fecha de creación',
	usrCreacion varchar(127) NULL COMMENT 'Usuario de creación',
	estado varchar(15) NULL COMMENT 'Estado de la tabla admi_pais',
	feUltModificacion DATE NULL COMMENT 'Fecha de última modificación',
	usrUltModificacion varchar(15) NULL COMMENT 'Usuario de última modificación'
);

CREATE TABLE my_database.info_factura (
	idFactura INT auto_increment NOT NULL COMMENT 'ID DE LA TABLA INFO_FACTURA' PRIMARY KEY,
	uuid VARCHAR(36) NOT NULL COMMENT 'UUID de la factura',
	subtotal DECIMAL(10,2) NULL COMMENT 'Subtotal de la factura',
	iva DECIMAL(10,2) NULL COMMENT 'IVA de la factura',
	total DECIMAL(10,2) NULL COMMENT 'Total de la factura',
	feCreacion DATE NULL COMMENT 'Fecha de creación',
	usrCreacion varchar(127) NULL COMMENT 'Usuario de creación',
	estado varchar(15) NULL COMMENT 'Estado de la tabla admi_pais',
	feUltModificacion DATE NULL COMMENT 'Fecha de última modificación',
	usrUltModificacion varchar(15) NULL COMMENT 'Usuario de última modificación'
);