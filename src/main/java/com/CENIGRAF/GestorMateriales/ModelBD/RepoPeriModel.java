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

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "IdRepoPeri")
    private List<ItemReporte> items;



    public RepoPeriModel(){
        this.items = new ArrayList<ItemReporte>();
    }
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

    public personalCenigrafModel getInstructorModel() {
        return personalCenigrafModel;
    }

    public void setInstructorModel(personalCenigrafModel personalCenigrafModel) {
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

    public List<ItemReporte> getItems() {
        return items;
    }

    public void setItems(List<ItemReporte> items) {
        this.items = items;
    }
    public void addItemReporte(ItemReporte item){
        this.items.add(item);
    }
    //calcular elementos
    //mostrar calculo de los itemsReport suma++ al addItemReporte x idReporte
    public Integer getTotal(){
        Integer total = 0;

        int size = items.size();
        for (int i=0;i<size;i++){
            total+= items.get(i).calcularItem();
        }
        return total;
    }

    private static final long serialVersionUID = 1L;
}
