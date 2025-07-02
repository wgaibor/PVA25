package com.teclemas.factura.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "info_factura_dato_adicional", schema = "facturador")
public class InfoFacturaDatoAdicionalModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDatoAdicional")
    private Integer idDatoAdicional;

    @Column(name = "facturaId", nullable = false)
    private Integer facturaId;

    @Column(name = "caracteristicaId", nullable = false)
    private Integer caracteristicaId;

    @Column(name = "valor", length = 255)
    private String valor;

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

    public Integer getIdDatoAdicional() {
        return idDatoAdicional;
    }

    public void setIdDatoAdicional(Integer idDatoAdicional) {
        this.idDatoAdicional = idDatoAdicional;
    }

    public Integer getFacturaId() {
        return facturaId;
    }

    public void setFacturaId(Integer facturaId) {
        this.facturaId = facturaId;
    }

    public Integer getCaracteristicaId() {
        return caracteristicaId;
    }

    public void setCaracteristicaId(Integer caracteristicaId) {
        this.caracteristicaId = caracteristicaId;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
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
