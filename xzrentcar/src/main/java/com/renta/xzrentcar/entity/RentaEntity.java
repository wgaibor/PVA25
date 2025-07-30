package com.renta.xzrentcar.entity;

import java.util.Date;

public class RentaEntity {

    private String dni;
    private String nombre;
    private String marca;
    private String modelo;
    private Date fechaNacimiento;
    private String tieneTarjetaCredito;

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTieneTarjetaCredito() {
        return tieneTarjetaCredito;
    }

    public void setTieneTarjetaCredito(String tieneTarjetaCredito) {
        this.tieneTarjetaCredito = tieneTarjetaCredito;
    }

}
