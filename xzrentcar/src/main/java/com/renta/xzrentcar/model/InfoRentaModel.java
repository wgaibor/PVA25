package com.renta.xzrentcar.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "info_renta", schema = "rentaVehiculos")
public class InfoRentaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_renta")
    private Integer idRenta;

    @Column(name = "dni", length = 15, nullable = false)
    private String dni;

    @Column(name = "nombres", length = 127, nullable = false)
    private String nombres;

    @Column(name = "modelo", length = 63, nullable = false)
    private String modelo;

    @Column(name = "marca", length = 63, nullable = false)
    private String marca;

    @Column(name = "fe_nacimiento")
    private LocalDate feNacimiento;

    @Column(name = "tiene_tc", length = 3, nullable = false)
    private String tieneTc;

    @Column(name = "usr_creacion", length = 63, nullable = false)
    private String usrCreacion;

    @Column(name = "fe_creacion")
    private LocalDate feCreacion;

    @Column(name = "estado", length = 15)
    private String estado;

    @Column(name = "fecha_modificacion")
    private LocalDate fechaModificacion;

    @Column(name = "usr_modificacion", length = 63)
    private String usrModificacion;

    public Integer getIdRenta() {
        return idRenta;
    }

    public void setIdRenta(Integer idRenta) {
        this.idRenta = idRenta;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public LocalDate getFeNacimiento() {
        return feNacimiento;
    }

    public void setFeNacimiento(LocalDate feNacimiento) {
        this.feNacimiento = feNacimiento;
    }

    public String getTieneTc() {
        return tieneTc;
    }

    public void setTieneTc(String tieneTc) {
        this.tieneTc = tieneTc;
    }

    public String getUsrCreacion() {
        return usrCreacion;
    }

    public void setUsrCreacion(String usrCreacion) {
        this.usrCreacion = usrCreacion;
    }

    public LocalDate getFeCreacion() {
        return feCreacion;
    }

    public void setFeCreacion(LocalDate feCreacion) {
        this.feCreacion = feCreacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDate getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(LocalDate fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public String getUsrModificacion() {
        return usrModificacion;
    }

    public void setUsrModificacion(String usrModificacion) {
        this.usrModificacion = usrModificacion;
    }

}
