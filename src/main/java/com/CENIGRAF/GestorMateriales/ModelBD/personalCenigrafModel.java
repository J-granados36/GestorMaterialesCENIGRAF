package com.CENIGRAF.GestorMateriales.ModelBD;



import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "personal_cenigraf")
public class personalCenigrafModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer idInstructor;
    private String nombreInstructor;
    private Integer cedula;

    private String celular;

    private String correo;

    @OneToMany(mappedBy = "personalCenigrafModel",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<RepoPeriModel> repoPeriModels;

    @OneToMany(mappedBy = "personalCenigrafModel",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<TransaccionalRepoModel> transaccionalRepoModels;

    public personalCenigrafModel() {
        repoPeriModels=new ArrayList<RepoPeriModel>();
    }

    public Integer getIdInstructor() {
        return idInstructor;
    }

    public void setIdInstructor(Integer idInstructor) {
        this.idInstructor = idInstructor;
    }

    public String getNombreInstructor() {
        return nombreInstructor;
    }

    public void setNombreInstructor(String nombreInstructor) {
        this.nombreInstructor = nombreInstructor;
    }

    public Integer getCedula() {
        return cedula;
    }

    public void setCedula(Integer cedula) {
        this.cedula = cedula;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public List<TransaccionalRepoModel> getTransaccionalRepoModels() {
        return transaccionalRepoModels;
    }

    public void setTransaccionalRepoModels(List<TransaccionalRepoModel> transaccionalRepoModels) {
        this.transaccionalRepoModels = transaccionalRepoModels;
    }

    public List<RepoPeriModel> getRepoPeriModels() {
        return repoPeriModels;
    }

    public void setRepoPeriModels(List<RepoPeriModel> repoPeriModels) {
        this.repoPeriModels = repoPeriModels;
    }

    public void addReportPeri(RepoPeriModel repoPeriModel){
        repoPeriModels.add(repoPeriModel);
    }

    private static final long serialVersionUID = 1L;
}
