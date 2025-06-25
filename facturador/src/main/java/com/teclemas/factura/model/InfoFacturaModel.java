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
@Table(name = "info_factura", schema = "facturador")
public class InfoFacturaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idFactura")
    private Integer idFactura;

    @Column(name = "uuid", nullable = false, length = 36)
    private String uuid;

    @Column(name = "subtotal", precision = 10, scale = 2)
    private BigDecimal subtotal;

    @Column(name = "iva", precision = 10, scale = 2)
    private BigDecimal iva;

    @Column(name = "total", precision = 10, scale = 2)
    private BigDecimal total;

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

    public Integer getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Integer idFactura) {
        this.idFactura = idFactura;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public BigDecimal getIva() {
        return iva;
    }

    public void setIva(BigDecimal iva) {
        this.iva = iva;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
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
