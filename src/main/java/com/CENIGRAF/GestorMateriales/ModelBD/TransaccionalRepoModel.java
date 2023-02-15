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

    //muchos

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idPer")
    private personalCenigrafModel personalCenigrafModel;


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


    public com.CENIGRAF.GestorMateriales.ModelBD.personalCenigrafModel getPersonalCenigrafModel() {
        return personalCenigrafModel;
    }

    public void setPersonalCenigrafModel(com.CENIGRAF.GestorMateriales.ModelBD.personalCenigrafModel personalCenigrafModel) {
        this.personalCenigrafModel = personalCenigrafModel;
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

    public void addRepoA(TransaccionalRepoModel transaccionalRepoModel) {
    }
}
