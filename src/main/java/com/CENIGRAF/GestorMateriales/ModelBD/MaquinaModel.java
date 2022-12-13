package com.CENIGRAF.GestorMateriales.ModelBD;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "Maquina")
public class MaquinaModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer idMaquina;
    private String nombreMaquina;
    private Integer placa;
    private Date adquisicion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idAmbiente",nullable = false)
    private AmbienteModel ambienteModel;

    @OneToMany(mappedBy = "maquinaModel",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<MtPreventivoModel> mtPreventivoModels;

    @OneToMany(mappedBy = "maquinaModel",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<MtCorrectivoModel> mtCorrectivoModels;
    public Integer getIdMaquina() {
        return idMaquina;
    }

    public void setIdMaquina(Integer idMaquina) {
        this.idMaquina = idMaquina;
    }

    public String getNombreMaquina() {
        return nombreMaquina;
    }

    public void setNombreMaquina(String nombreMaquina) {
        this.nombreMaquina = nombreMaquina;
    }

    public Integer getPlaca() {
        return placa;
    }

    public void setPlaca(Integer placa) {
        this.placa = placa;
    }

    public Date getAdquisicion() {
        return adquisicion;
    }

    public void setAdquisicion(Date adquisicion) {
        this.adquisicion = adquisicion;
    }

}
