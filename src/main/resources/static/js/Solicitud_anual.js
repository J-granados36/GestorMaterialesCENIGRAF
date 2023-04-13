$(function () {
    $("#eliminar_fila").hide();
    $("#nuevo_articulo").click(function () { 
        var html_ele=$("#elemento_prin_anu").html();
        $("#body_elemento").append(
            "<tr>"+html_ele+"</tr>"
        );
        $("#eliminar_fila").show();
    });
    $("#eliminar_fila").click(function () { 
        $("#tabla_ele_anu tr:last").remove();
        var filas=$("#tabla_ele_anu tr").length;

        if(filas>=3){
            $("#eliminar_fila").show();
        }
        else{
            $("#eliminar_fila").hide();
        }
    });
});