package com.CENIGRAF.GestorMateriales.ModelBD;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "report_peri")
public class RepoPeriModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer IdRepoPeri;
    @Temporal(TemporalType.DATE)
    private Date FechaSolicitud;
    @ManyToOne(fetch = FetchType.LAZY)
    private personalCenigrafModel personalCenigrafModel;
    @ManyToOne(fetch = FetchType.LAZY)
    private FichaModel fichaModel;
    @ManyToOne(fetch = FetchType.LAZY)
    private ProgramaModel programaModel;






    //METODOS

    public Integer getIdRepoPeri() {
        return IdRepoPeri;
    }

    public void setIdRepoPeri(Integer idRepoPeri) {
        IdRepoPeri = idRepoPeri;
    }

    public Date getFechaSolicitud() {
        return FechaSolicitud;
    }

    public void setFechaSolicitud(Date fechaSolicitud) {
        FechaSolicitud = fechaSolicitud;
    }

    public com.CENIGRAF.GestorMateriales.ModelBD.personalCenigrafModel getPersonalCenigrafModel() {
        return personalCenigrafModel;
    }

    public void setPersonalCenigrafModel(com.CENIGRAF.GestorMateriales.ModelBD.personalCenigrafModel personalCenigrafModel) {
        this.personalCenigrafModel = personalCenigrafModel;
    }

    public FichaModel getFichaModel() {
        return fichaModel;
    }

    public void setFichaModel(FichaModel fichaModel) {
        this.fichaModel = fichaModel;
    }

    public ProgramaModel getProgramaModel() {
        return programaModel;
    }

    public void setProgramaModel(ProgramaModel programaModel) {
        this.programaModel = programaModel;
    }



    private static final long serialVersionUID = 1L;
}
