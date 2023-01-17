var contador2p=2;
$(document).ready(function(){
    $(document).on("click","#sumitem", function () {
        $.ajax({
            type: "GET",
            url: "http://localhost:8080/api/Inventario/all",
            dataType: "JSON",
            success: function (response) {
                var myItems= response;
                var valor = '';
                for (i = 0; i < myItems.length; i++) {
                    valor +=
                    '<option value"'+myItems[i].idInventario+'">'+ myItems[i].nombreElemento+'</option>'
                }
                $('<tr>'+
                    '<td><input class="form-control" type="number" value="'+contador2p+'" readonly></td>'+
                    '<td><select class="js-example-basic-single"><option hidden default>Seleccionar</option>'+valor+'</select></td>'+
                    '<td><input type="number" class="form-control"></td>'+
                    '<td><select class="form-control"><option default hidden></option><option>Unidad</option><option>Pliego</option><option>1/2 Pliego</option><option>Caja</option><option>Kilo</option><option>Rollo</option><option>Lamina</option><option>Galón</option><option>Paquete</option><option>Metros</option></select></td>'+
                    '<td><textarea style="height: 40px;" class="form-control"></textarea></td>'+
                '</tr>').appendTo("#tb_elementop");
                contador2p++;
            }
        });    
    });
});
$.ajax({
    type: "GET",
    url: "http://localhost:8080/api/InsModel/all",
    dataType: "JSON",
    success: function (response) {
        var myItems= response;
        var valor = '';
        for (i = 0; i < myItems.length; i++) {
            valor +='<option hidden default>Seleccionar</option>'+
            '<option value="'+myItems[i].idInstructor+'">'+ myItems[i].nombreInstructor+'</option>'
        }
        $("#ins_per").html(valor);
    }
});
$.ajax({
    type: "GET",
    url: "http://localhost:8080/api/FichaModel/all",
    dataType: "JSON",
    success: function (response) {
        var myItems= response;
        var valor = '';
        for (i = 0; i < myItems.length; i++) {
            valor +='<option hidden default>Seleccionar</option>'+
            '<option value="'+myItems[i].numeroFicha+'">'+ myItems[i].numeroFicha+'</option>'
        }
        $("#fic_per").html(valor);
    }
});
$.ajax({
    type: "GET",
    url: "http://localhost:8080/api/ProgramaModel/all",
    dataType: "JSON",
    success: function (response) {
        var myItems= response;
        var valor = '';
        for (i = 0; i < myItems.length; i++) {
            valor +='<option hidden default>Seleccionar</option>'+
            '<option value="'+myItems[i].idPrograma+'">'+ myItems[i].nombrePrograma+'</option>'
        }
        $("#pro_per").html(valor);
    }
});
$.ajax({
    type: "GET",
    url: "http://localhost:8080/api/Inventario/all",
    dataType: "JSON",
    success: function (response) {
        var myItems= response;
        var valor = '';
        var udmedida='';
        for (i = 0; i < myItems.length; i++) {
            valor +=
            '<option value"'+myItems[i].idInventario+'">'+ myItems[i].nombreElemento+'</option>';
        }
        $("#elemento_per").html(valor);
    }
});