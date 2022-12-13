package com.CENIGRAF.GestorMateriales.ModelBD;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "MtCorrectivo")
public class MtCorrectivoModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer idMtCorrectivo;
    private String nombreMtCorr;
    private String descripcion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idMaquina")
    private MaquinaModel maquinaModel;

    public Integer getIdMtCorrectivo() {
        return idMtCorrectivo;
    }

    public void setIdMtCorrectivo(Integer idMtCorrectivo) {
        this.idMtCorrectivo = idMtCorrectivo;
    }

    public String getNombreMtCorr() {
        return nombreMtCorr;
    }

    public void setNombreMtCorr(String nombreMtCorr) {
        this.nombreMtCorr = nombreMtCorr;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}