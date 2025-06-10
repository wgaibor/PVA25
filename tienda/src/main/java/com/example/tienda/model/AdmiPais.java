package com.example.tienda.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "admi_pais")
public class AdmiPais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPais")
    private Integer idPais;

    @Column(name = "pais")
    private String pais;

    @Column(name = "feCreacion")
    @Temporal(TemporalType.DATE)
    private Date feCreacion;

    @Column(name = "usrCreacion")
    private String usrCreacion;

    @Column(name = "estado")
    private String estado;

    @Column(name = "feUltModificacion")
    @Temporal(TemporalType.DATE)
    private Date feUltModificacion;

    @Column(name = "usrUltModificacion")
    private String usrUltModificacion;

    public Integer getIdPais() {
        return idPais;
    }

    public void setIdPais(Integer idPais) {
        this.idPais = idPais;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Date getFeCreacion() {
        return feCreacion;
    }

    public void setFeCreacion(Date feCreacion) {
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

    public Date getFeUltModificacion() {
        return feUltModificacion;
    }

    public void setFeUltModificacion(Date feUltModificacion) {
        this.feUltModificacion = feUltModificacion;
    }

    public String getUsrUltModificacion() {
        return usrUltModificacion;
    }

    public void setUsrUltModificacion(String usrUltModificacion) {
        this.usrUltModificacion = usrUltModificacion;
    }

    @Override
    public String toString() {
        return this.pais;
    }

}
