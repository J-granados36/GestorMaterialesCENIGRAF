package com.CENIGRAF.GestorMateriales.ModelBD.dto;

import com.CENIGRAF.GestorMateriales.ModelBD.ElementoModel;
import com.CENIGRAF.GestorMateriales.ModelBD.FichaModel;
import com.CENIGRAF.GestorMateriales.ModelBD.InstructorModel;
import com.CENIGRAF.GestorMateriales.ModelBD.ProgramaModel;

import java.io.Serializable;
import java.util.List;

public class informeAnual implements Serializable {

    private List<InstructorModel> instructorModelList;
    private List<ProgramaModel> programaModelList;
    private List<ElementoModel> elementoModelList;
    private List<FichaModel> fichaModelList;

    public informeAnual(List<InstructorModel> instructorModelList, List<ProgramaModel> programaModelList, List<ElementoModel> elementoModelList, List<FichaModel> fichaModelList) {
        this.instructorModelList = instructorModelList;
        this.programaModelList = programaModelList;
        this.elementoModelList = elementoModelList;
        this.fichaModelList = fichaModelList;
    }

    public List<InstructorModel> getInstructorModelList() {
        return instructorModelList;
    }

    public void setInstructorModelList(List<InstructorModel> instructorModelList) {
        this.instructorModelList = instructorModelList;
    }

    public List<ProgramaModel> getProgramaModelList() {
        return programaModelList;
    }

    public void setProgramaModelList(List<ProgramaModel> programaModelList) {
        this.programaModelList = programaModelList;
    }

    public List<ElementoModel> getElementoModelList() {
        return elementoModelList;
    }

    public void setElementoModelList(List<ElementoModel> elementoModelList) {
        this.elementoModelList = elementoModelList;
    }

    public List<FichaModel> getFichaModelList() {
        return fichaModelList;
    }

    public void setFichaModelList(List<FichaModel> fichaModelList) {
        this.fichaModelList = fichaModelList;
    }
}
