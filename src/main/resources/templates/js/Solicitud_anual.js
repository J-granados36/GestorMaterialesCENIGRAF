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
            $("#elemento_anu").append(valor);

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
    }});
    $("#suma_elementoa").click(function () { 
        $("#fila_prina").clone().appendTo("#tb_elementoa_body").end();
        $("#elemento_anu").$(selector).attr(attributeName, value);;
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
            valor +=
            '<option value="'+myItems[i].idInstructor+'">'+ myItems[i].nombreInstructor+'</option>'
        }
        $("#ins_anu").html('<option hidden default>Seleccionar</option>'+valor);
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
            valor +=
            '<option value="'+myItems[i].numeroFicha+'">'+ myItems[i].numeroFicha+'</option>'
        }
        $("#fic_anu").html('<option hidden default>Seleccionar</option>'+valor);
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
            valor +=
            '<option value="'+myItems[i].idPrograma+'">'+ myItems[i].nombrePrograma+'</option>'
        }
        $("#pro_anu").html('<option hidden default>Seleccionar</option>'+valor);
    }
});
