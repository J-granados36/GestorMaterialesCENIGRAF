package com.CENIGRAF.GestorMateriales.ModelBD;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

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
    @OneToMany(mappedBy = "repoPeriModel",cascade = CascadeType.ALL)
    private Set<ElementoSolicitado> elementos;
    //METODOS
    private String area;
    private String nombreCoordinador;
    private String Cuentadante1;
    private String Cuentadante2;
    private String Cuentadante3;
    private String tipoCuentadante;
    private String cargo;
    private String firma;

    public Integer getTotal(){
        Integer total = 0;
        for (ElementoSolicitado elementoSolicitado:this.elementos){
            total += elementoSolicitado.getTotal();
        }
        return total;
    }

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

    public Set<ElementoSolicitado> getElementos() {
        return elementos;
    }

    public void setElementos(Set<ElementoSolicitado> elementos) {
        this.elementos = elementos;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getNombreCoordinador() {
        return nombreCoordinador;
    }

    public void setNombreCoordinador(String nombreCoordinador) {
        this.nombreCoordinador = nombreCoordinador;
    }

    public String getCuentadante1() {
        return Cuentadante1;
    }

    public void setCuentadante1(String cuentadante1) {
        Cuentadante1 = cuentadante1;
    }

    public String getCuentadante2() {
        return Cuentadante2;
    }

    public void setCuentadante2(String cuentadante2) {
        Cuentadante2 = cuentadante2;
    }

    public String getCuentadante3() {
        return Cuentadante3;
    }

    public void setCuentadante3(String cuentadante3) {
        Cuentadante3 = cuentadante3;
    }

    public String getTipoCuentadante() {
        return tipoCuentadante;
    }

    public void setTipoCuentadante(String tipoCuentadante) {
        this.tipoCuentadante = tipoCuentadante;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getFirma() {
        return firma;
    }

    public void setFirma(String firma) {
        this.firma = firma;
    }

    private static final long serialVersionUID = 1L;
}


