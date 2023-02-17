$(function () {
    $("#eliminar_fila").hide();
    $("#nuevo_articulo").click(function () { 
        var html_ele=$("#elemento_prin_per").html();
        $("#body_elemento").append(
            "<tr>"+html_ele+"</tr>"
        );
        $("#eliminar_fila").show();
    });
    $("#eliminar_fila").click(function () { 
        $("#tabla_ele_per tr:last").remove();
        var filas=$("#tabla_ele_per tr").length;

        if(filas>=3){
            $("#eliminar_fila").show();
        }
        else{
            $("#eliminar_fila").hide();
        }
    });
});
$("#tip_cuentadante").on("change", function () { 

    var tip_cue=$("#tip_cuentadante option:selected").val();
        
    switch(tip_cue){
        case "Unipersonal":
            $(".tipo_cuenta_nom").html(
                '<label>Nombre cuentadante:</label>'+
                '<select class="form-control" id=""></select>'
            );
            $(".tipo_cuenta_doc").html(
                '<label>Documento cuentadante:</label>'+
                '<input type="number" class="form-control" id="doc_cuenta_uno">'
            );
            break;

        case "Multiple":
            $(".tipo_cuenta_nom").html(
                '<label>Nombre cuentadante 1:</label>'+
                '<select class="form-control" id=""></select>'+
                '<label>Nombre cuentadante 2:</label>'+
                '<select class="form-control" id=""></select>'+
                '<label>Nombre cuentadante 3:</label>'+
                '<select class="form-control" id=""></select>'
            );
            $(".tipo_cuenta_doc").html(
                '<label>Documento cuentadante:</label>'+
                '<input type="number" class="form-control" id="doc_cuenta_uno">'+
                '<label>Documento cuentadante:</label>'+
                '<input type="number" class="form-control" id="doc_cuenta_dos">'+
                '<label>Documento cuentadante:</label>'+
                '<input type="number" class="form-control" id="doc_cuenta_tres">'
            );
            break;

        default:
            $(".tipo_cuenta_nom").html(" ");
            $(".tipo_cuenta_doc").html(" ");
            break;
    }
});