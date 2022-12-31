var contadora=1;
var contador2a=2;
function suma_elementoa(){
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/Inventario/all",
        dataType: "JSON",
        success: function (response) {
            var myItems= response;
            var valor = '';
            for (i = 0; i < myItems.length; i++) {
                valor += myItems[i].nombreElemento;
            }
            $("#tb_elementoa").append(
            '<tr>'+
                '<td><input class="form-control" type="number" value="'+contador2a+'" readonly></td>'+
                '<td><select class="form-control"><option default hidden>Seleccionar</option><option value="'+idvalor+'">'+valor+'</option></select></td>'+
                '<td><input type="number" class="form-control"></td>'+
                '<td><input type="number" class="form-control"></td>'+
                '<td><textarea style="height: 40px;" class="form-control" id=""></textarea></td>'+
            '</tr>');        
            contador2a++;
        }
    });
}
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
        $("#ins_anu").html(valor);
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
        $("#fic_anu").html(valor);
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
        $("#pro_anu").html(valor);
    }
});
$.ajax({
    type: "GET",
    url: "http://localhost:8080/api/Inventario/all",
    dataType: "JSON",
    success: function (response) {
        var myItems= response;
        var valor = '';
        for (i = 0; i < myItems.length; i++) {
            valor +='<option hidden default>Seleccionar</option>'+
            '<option value"'+myItems[i].idInventario+'">'+ myItems[i].nombreElemento+'</option>'
        }
        $("#elemento_anu").html(valor);
    }
});
