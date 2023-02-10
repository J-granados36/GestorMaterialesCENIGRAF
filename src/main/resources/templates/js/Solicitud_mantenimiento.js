$(function () {
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/api/Inventario/all',
        success:function (response){ 
            var myItems= response;
            var valor = '';
            for (i = 0; i < myItems.length; i++) {
                valor += '<option value="'+myItems[i].idInventario+'">'+myItems[i].nombreElemento+'</option>';
            } 
            $("#elemento_man").append(valor);

            $("#elemento_man").on('focus change', function () {
                $("#udmedman").empty();
                $("#descman").empty();
            
                var ideleman=$("#elemento_man").val();
            
                $.ajax({
                    type: "GET",
                    url: "http://localhost:8080/api/Inventario/"+ideleman,
                    dataType: "JSON",
                    success: function (response) {
                        $("#udmedman").val(response.undMedida);
                        $("#descman").val(response.descripcionElemento);
                    }
                });
            });            
    }});
    $("#suma_elementom").click(function () { 
        $("#fila_prinm").clone().appendTo("#tb_elementom_body").end();
    });
});
$.ajax({
    type: "GET",
    url: "http://localhost:8080/api/AmbienteModel/all",
    dataType: "JSON",
    success: function (response){  
        var myItems= response;
        var valor = '';
        for (i = 0; i < myItems.length; i++) {
            valor +=
            '<option value="'+myItems[i].idAmbiente+'">'+ myItems[i].nombreAmbiente+'</option>'
        }
        $("#amb_man").html('<option hidden default>Seleccionar</option>'+valor);
    }
});
$.ajax({
    type: "GET",
    url: "http://localhost:8080/api/MaquinaModel/all",
    dataType: "JSON",
    success: function (response){  
        var myItems= response;
        var valor = '';
        for (i = 0; i < myItems.length; i++) {
            valor +=
            '<option value="'+myItems[i].idAMaquina+'">'+ myItems[i].nombreMaquina+'</option>'
        }
        $("#maq_man").html('<option hidden default>Seleccionar</option>'+valor);
    }
});