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
            $("#elemento_per").append(valor);

            $("#elemento_per").on('focus change', function () {
                $("#udmedper").empty();
                $("#descper").empty();
            
                var ideleanu=$("#elemento_per").val();
            
                $.ajax({
                    type: "GET",
                    url: "http://localhost:8080/api/Inventario/"+ideleanu,
                    dataType: "JSON",
                    success: function (response) {
                        $("#udmedper").val(response.undMedida);
                        $("#descper").val(response.descripcionElemento);
                    }
                });
            });            
    }});
    $("#suma_elementop").click(function () { 
        $("#fila_prinp").clone().appendTo("#tb_elementop_body");
        $("#udmedper").empty();
        $("#descper").empty();
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