package com.teclemas.factura.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "info_items", schema = "facturador")
public class InfoItemModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idItems")
    private Integer idItems;

    @Column(name = "uuid", nullable = false, length = 36)
    private String uuid;

    @Column(name = "nombreProducto", length = 63)
    private String nombreProducto;

    @Column(name = "cantidad")
    private Integer cantidad;

    @Column(name = "precio", precision = 10, scale = 2)
    private BigDecimal precio;

    @Column(name = "feCreacion")
    private LocalDate feCreacion;

    @Column(name = "usrCreacion", length = 127)
    private String usrCreacion;

    @Column(name = "estado", length = 15)
    private String estado;

    @Column(name = "feUltModificacion")
    private LocalDate feUltModificacion;

    @Column(name = "usrUltModificacion", length = 15)
    private String usrUltModificacion;

    // Getters y setters

    public Integer getIdItems() {
        return idItems;
    }

    public void setIdItems(Integer idItems) {
        this.idItems = idItems;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public LocalDate getFeCreacion() {
        return feCreacion;
    }

    public void setFeCreacion(LocalDate feCreacion) {
        this.feCreacion = feCreacion;
    }

    public String getUsrCreacion() {
        return usrCreacion;
    }

    public void setUsrCreacion(String usrCreacion) {
        this.usrCreacion = usrCreacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDate getFeUltModificacion() {
        return feUltModificacion;
    }

    public void setFeUltModificacion(LocalDate feUltModificacion) {
        this.feUltModificacion = feUltModificacion;
    }

    public String getUsrUltModificacion() {
        return usrUltModificacion;
    }

    public void setUsrUltModificacion(String usrUltModificacion) {
        this.usrUltModificacion = usrUltModificacion;
    }

}
