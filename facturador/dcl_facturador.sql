CREATE TABLE facturador.info_items (
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

CREATE TABLE facturador.info_factura (
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

CREATE TABLE facturador.admi_caracteristica (
	idCaracteristica INT auto_increment NOT NULL COMMENT 'ID DE LA TABLA ADMI_CARACTERISTICA' PRIMARY KEY,
	nombreCaracteristica varchar(63) NULL COMMENT 'Nombre de la característica',
	estado varchar(15) NULL COMMENT 'Estado de la característica',
	feCreacion DATE NULL COMMENT 'Fecha de creación',
	usrCreacion varchar(127) NULL COMMENT 'Usuario de creación',
	feUltModificacion DATE NULL COMMENT 'Fecha de última modificación',
	usrUltModificacion varchar(15) NULL COMMENT 'Usuario de última modificación'
);

CREATE TABLE facturador.info_factura_dato_adicional (
	idDatoAdicional INT auto_increment NOT NULL COMMENT 'ID DE LA TABLA INFO_FACTURA_DATO_ADICIONAL' PRIMARY KEY,
	facturaId INT NOT NULL COMMENT 'ID de la factura asociada',
	caracteristicaId INT NOT NULL COMMENT 'ID de la característica asociada',
	valor varchar(255) NULL COMMENT 'Valor del dato adicional',
	feCreacion DATE NULL COMMENT 'Fecha de creación',
	usrCreacion varchar(127) NULL COMMENT 'Usuario de creación',
	estado varchar(15) NULL COMMENT 'Estado del dato adicional',
	feUltModificacion DATE NULL COMMENT 'Fecha de última modificación',
	usrUltModificacion varchar(15) NULL COMMENT 'Usuario de última modificación'
);

ALTER TABLE facturador.info_factura_dato_adicional
ADD CONSTRAINT fk_info_factura_dato_adicional_caracteristica
FOREIGN KEY (caracteristicaId)
REFERENCES facturador.admi_caracteristica(idCaracteristica);

ALTER TABLE facturador.info_factura_dato_adicional
ADD CONSTRAINT fk_info_factura_dato_adicional_factura
FOREIGN KEY (facturaId)
REFERENCES facturador.info_factura(idFactura);