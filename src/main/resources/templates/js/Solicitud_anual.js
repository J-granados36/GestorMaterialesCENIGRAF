var contador2a=2;
$(document).ready(function(){
    $(document).on("click","#sumitema", function (){
    $.ajax({
        type: "GET",

url: "http://localhost:8080/api/ElementoModel/all",
        dataType: "JSON",
        success: function (response) {
            var myItems= response;
            var valor = '';
            for (i = 0; i < myItems.length; i++) {
                valor += myItems[i].nombreElemento;
                idvalor += myItems[i].idInventario; 
            }
            $("#tb_elementoa").append(

            '<tr>'+
                '<td><input class="form-control" type="number" value="'+contador2a+'" readonly></td>'+
                '<td><select class="js-example-basic" id="buscador_elemanu" style="width: 100%"><option default hidden>Seleccionar</option></select></td>'+
                '<td><input type="number" class="form-control"></td>'+
                '<td><input type="text" class="form-control" id="udmedanui"></td>'+
                '<td><textarea style="height: 40px;" class="form-control" id="descanui"></textarea></td>'+
            '</tr>');    
            
            $.each(response, function(indice, fila){
                $('#buscador_elemanu').append("<option value='"+ fila.idInventario+"'>"+fila.nombreElemento+"</option>");
            });


            contador2a++;


            $("#buscador_elemanu").on('focus change', function () {
                $("#udmedanui").empty();
                $("#descanui").empty();
            
                var ideleanu=$("#buscador_elemanu").val();
            
                $.ajax({
                    type: "GET",
                    url: "http://localhost:8080/api/Inventario/"+ideleanu,
                    dataType: "JSON",
                    success: function (response) {
                        $("#udmedanui").val(response.undMedida);
                        $("#descanui").val(response.descripcionElemento);
                    }
                });
            });
            }
        });    
    });
    $(function(){
        $.ajax({
            type: 'GET',
            url: 'http://localhost:8080/api/Inventario/all',
            success:function (response){  
                $.each(response, function(indice, fila){
                    $('#elemento_anu').append("<option value='"+ fila.idInventario+"'>"+fila.nombreElemento+"</option>");
                });
        }});
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


$("#elemento_anu").on('focus change', function () {
    $("#udmedanu").empty();
    $("#descanu").empty();

    var ideleanu=$("#elemento_anu").val();

    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/Inventario/"+ideleanu,
        dataType: "JSON",
        success: function (response) {
            $("#udmedanu").val(response.undMedida);
            $("#descanu").val(response.descripcionElemento);
        }
    });
});