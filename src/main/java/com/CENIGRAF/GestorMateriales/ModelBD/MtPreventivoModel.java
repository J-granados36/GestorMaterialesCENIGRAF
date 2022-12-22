package com.CENIGRAF.GestorMateriales.ModelBD;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "MtPreventivo")
public class MtPreventivoModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer idMtPreventivo;
    private String nombreMtPrev;
    private String descripcion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idMaquina")
    private MaquinaModel maquinaModel;

    public Integer getIdMtPreventivo() {
        return idMtPreventivo;
    }

    public void setIdMtPreventivo(Integer idMtPreventivo) {
        this.idMtPreventivo = idMtPreventivo;
    }

    public String getNombreMtPrev() {
        return nombreMtPrev;
    }

    public void setNombreMtPrev(String nombreMtPrev) {
        this.nombreMtPrev = nombreMtPrev;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
