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

    private Integer idPer;
    private String nombrePersonal;
    private Integer documento;
    private String cargo;



    @OneToMany(mappedBy = "personalCenigrafModel",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<RepoPeriModel> repoPeriModels;

    @OneToMany(mappedBy = "personalCenigrafModel",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<TransaccionalRepoModel> transaccionalRepoModels;

    public personalCenigrafModel() {
        repoPeriModels=new ArrayList<RepoPeriModel>();
    }

    public Integer getIdPer() {
        return idPer;
    }

    public void setIdPer(Integer idPer) {
        this.idPer = idPer;
    }

    public String getNombrePersonal() {
        return nombrePersonal;
    }

    public void setNombrePersonal(String nombrePersonal) {
        this.nombrePersonal = nombrePersonal;
    }

    public Integer getDocumento() {
        return documento;
    }

    public void setDocumento(Integer documento) {
        this.documento = documento;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
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
