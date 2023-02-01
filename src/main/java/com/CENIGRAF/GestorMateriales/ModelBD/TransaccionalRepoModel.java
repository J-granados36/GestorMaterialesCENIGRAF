package com.CENIGRAF.GestorMateriales.ModelBD;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "TransaccionalReporte")
public class TransaccionalRepoModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer idTransaccional;
    private Integer TotalSolicitud;

    //muchos

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idInstructor")
    private InstructorModel instructorModel;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idPrograma")
    private ProgramaModel programaModel;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idFicha")
    private FichaModel fichaModel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idAmbiente")
    private AmbienteModel ambienteModel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idMaquina")
    private MaquinaModel maquinaModel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idElemento")
    private ElementoModel elementoModel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idInventario")
    private InventarioModel inventarioModel;



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


    public InstructorModel getInstructorModel() {
        return instructorModel;
    }

    public void setInstructorModel(InstructorModel instructorModel) {
        this.instructorModel = instructorModel;
    }

    public ProgramaModel getProgramaModel() {
        return programaModel;
    }

    public void setProgramaModel(ProgramaModel programaModel) {
        this.programaModel = programaModel;
    }

    public FichaModel getFichaModel() {
        return fichaModel;
    }

    public void setFichaModel(FichaModel fichaModel) {
        this.fichaModel = fichaModel;
    }

    public AmbienteModel getAmbienteModel() {
        return ambienteModel;
    }

    public void setAmbienteModel(AmbienteModel ambienteModel) {
        this.ambienteModel = ambienteModel;
    }

    public MaquinaModel getMaquinaModel() {
        return maquinaModel;
    }

    public void setMaquinaModel(MaquinaModel maquinaModel) {
        this.maquinaModel = maquinaModel;
    }

    public ElementoModel getElementoModel() {
        return elementoModel;
    }

    public void setElementoModel(ElementoModel elementoModel) {
        this.elementoModel = elementoModel;
    }

    public InventarioModel getInventarioModel() {
        return inventarioModel;
    }

    public void setInventarioModel(InventarioModel inventarioModel) {
        this.inventarioModel = inventarioModel;
    }
}
