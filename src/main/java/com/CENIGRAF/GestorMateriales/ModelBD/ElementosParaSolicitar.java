package com.CENIGRAF.GestorMateriales.ModelBD;

public class ElementosParaSolicitar extends ElementosConsumiblesModel{

    private Integer cantidad;

    public ElementosParaSolicitar(Integer idEc, Integer codigoSena, String decripcionBien, String unidadMedida, Integer existenciaAlmacen, Integer cantidadSolicitada, Integer observaciones, Integer cantidad) {
        super(idEc, codigoSena, decripcionBien, unidadMedida, existenciaAlmacen, cantidadSolicitada, observaciones);
        this.cantidad = cantidad;
    }

    public ElementosParaSolicitar(Integer codigoSena, String decripcionBien, String unidadMedida, Integer existenciaAlmacen, Integer cantidadSolicitada, Integer observaciones, Integer cantidad) {
        super(codigoSena, decripcionBien, unidadMedida, existenciaAlmacen, cantidadSolicitada, observaciones);
        this.cantidad = cantidad;
    }

    public void aumentarCantidad(){
        this.cantidad++;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public Integer getTotal(){
        return this.getCantidadSolicitada() * this.cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
}
