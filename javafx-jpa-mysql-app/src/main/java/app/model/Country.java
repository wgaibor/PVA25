package app.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "country")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPais")
    private Long idPais;

    @Column(name = "pais", nullable = false)
    private String pais;

    @Column(name = "feCreacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date feCreacion;

    @Column(name = "usrCreacion")
    private String usrCreacion;

    @Column(name = "estado")
    private Boolean estado;

    @Column(name = "feUltModificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date feUltModificacion;

    @Column(name = "usrUltModificacion")
    private String usrUltModificacion;

    public Long getIdPais() {
        return idPais;
    }

    public void setIdPais(Long idPais) {
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

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
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
}