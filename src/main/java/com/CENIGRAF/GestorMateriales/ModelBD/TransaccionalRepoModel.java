package com.CENIGRAF.GestorMateriales.ModelBD;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TransaccionalReporte")
public class TransaccionalRepoModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer idTransaccional;
    private Integer TotalSolicitud;

    public Integer getTotalSolicitud() {
        return TotalSolicitud;
    }

    public void setTotalSolicitud(Integer totalSolicitud) {
        TotalSolicitud = totalSolicitud;
    }

    public Integer getIdTransaccional() {
        return idTransaccional;
    }

    public void setIdTransaccional(Integer idTransaccional) {
        this.idTransaccional = idTransaccional;
    }
}
