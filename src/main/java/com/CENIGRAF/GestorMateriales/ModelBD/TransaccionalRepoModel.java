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
    @JoinColumn(name = "idInstructor")
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idElemento")
    private ElementoModel elementoModel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idInventario")
    private InventarioModel inventarioModel;



    /*public Integer calcularTotal(){
        Integer total = 0;
        int size = elementoModel.getCantidad();

        for (int i=0;i< size;i++)
            total+= elementoModel.getCantidad();

        return elementoModel.getCantidad()-getTotalSolicitud();
    }
         */

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


    public personalCenigrafModel getInstructorModel() {
        return personalCenigrafModel;
    }

    public void setInstructorModel(personalCenigrafModel personalCenigrafModel) {
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

    public void addRepoA(TransaccionalRepoModel transaccionalRepoModel) {
    }
}
