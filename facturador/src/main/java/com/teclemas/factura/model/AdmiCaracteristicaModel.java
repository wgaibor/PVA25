package com.teclemas.factura.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "admi_caracteristica", schema = "facturador")
public class AdmiCaracteristicaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCaracteristica")
    private Integer idCaracteristica;

    @Column(name = "nombreCaracteristica", length = 63)
    private String nombreCaracteristica;

    @Column(name = "estado", length = 15)
    private String estado;

    @Column(name = "feCreacion")
    private LocalDate feCreacion;

    @Column(name = "usrCreacion", length = 127)
    private String usrCreacion;

    @Column(name = "feUltModificacion")
    private LocalDate feUltModificacion;

    @Column(name = "usrUltModificacion", length = 15)
    private String usrUltModificacion;

    // Getters y setters

    public Integer getIdCaracteristica() {
        return idCaracteristica;
    }

    public void setIdCaracteristica(Integer idCaracteristica) {
        this.idCaracteristica = idCaracteristica;
    }

    public String getNombreCaracteristica() {
        return nombreCaracteristica;
    }

    public void setNombreCaracteristica(String nombreCaracteristica) {
        this.nombreCaracteristica = nombreCaracteristica;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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