app_inve={
    // Se llama la url del controller de intructores 
    backend: "http://localhost:8080/api/ElementosConsumibles",
    // Se DataTable para darle un diseño por defecto de jquery 
    leer_elem: function(){     
        $.ajax({
            url: app_inve.backend + "/all",
            type: 'GET',
            datatype: 'JSON',
            success: function (response) {
                var myItems= response;
                var valor = '';
                for (i = 0; i < myItems.length; i++) {
                    valor +='<tr>'+
                                '<td>'+ myItems[i].codigoSena+'</td>'+
                                '<td>'+ myItems[i].decripcionBien+'</td>'+
                                '<td>'+ myItems[i].unidadMedida+'</td>'+
                                '<td>'+ myItems[i].cantidadAlmacen+'</td>'+
                                '<td>'+ myItems[i].estado+'</td>'+
                                '<td>'+'<button class="btn btn-danger" onclick="borrarElemento('+ myItems[i].idInventario+')">Borrar <i class="bi bi-trash3"></i></button>'+'</td>'+
                                '<td>'+"<button type='button' class='btn btn-success' onclick='editarFicha("+ myItems[i].idInventario+")' data-toggle='modal' data-target='#editarinve'>Editar <i class='bi bi-pencil'></i></button>"+'</td>'+
                            '</tr>'
                }
                $("#body_inve").html(valor);
            }
        })
    },
    reg_elem: function(){
        $("#reg_inventario").click(function() { 
            var reg_inve_nomb=$("#reg_inve_nomb").val();
            var reg_inve_desc=$("#reg_inve_desc").val();
            var reg_inve_cant=$("#reg_inve_cant").val();
            var reg_inve_medi=$("#reg_inve_medi").val();
            var reg_inve_esta=$("#reg_inve_esta").val();

            var obj_inve={
                cantidadAlmacen:reg_inve_cant,
                undMedida:reg_inve_medi,
                descripcionElemento:reg_inve_desc,
                nombreElemento:reg_inve_nomb,
                estado:reg_inve_esta

            }
            $.ajax({
                type: "POST",
                url: app_inve.backend + "/save",
                data: JSON.stringify(obj_inve),
                dataType: 'JSON',
                contentType: "application/json",
                success: function () {
                    location.reload();
                }
            }).fail(function($xhr){
                var data=$xhr.responseJSON;
            })

        });
    },
    actualizar_elem(){
        $('#formulario_act_inv').on("click", function (event){
            event.preventDefault();
         })

        $("#cambios_inve").click(function(){


            var edit_id_inve=$("#edit_id_inve").val();
            var edit_inve_nomb=$("#edit_nomb_inve").val();
            var edit_inve_desc=$("#edit_desc_inve").val();
            var edit_inve_cant=$("#edit_cant_inve").val();
            var edit_inve_medi=$("#edit_medi_inve").val();
            var edit_inve_esta=$("#edit_esta_inve").val();

            var datos_editados={
                idInventario:edit_id_inve,
                nombreElemento:edit_inve_nomb,
                descripcionElemento:edit_inve_desc,
                undMedida:edit_inve_medi,
                cantidadAlmacen:edit_inve_cant,
                estado:edit_inve_esta
            }

            var datosJSON=JSON.stringify(datos_editados);
            
            $.ajax({   
                type: "PUT",
                url: app_inve.backend+"/update",
                data: datosJSON,
                dataType: "JSON",
                contentType: "application/json",
                success: function () {
                    location.reload();
                }
            });
        });       
    } 
}
function borrarElemento(idInve){
        
    var idEliminar={
        idElemento:idInve
    }   
    $.ajax({
        type: "DELETE",
        url: app_inve.backend+'/'+idInve,
        data: JSON.stringify(idEliminar),
        dataType: "JSON",
        contentType: "application/json",
        success: function (response) {
            location.reload();
        }
    })
}
function editarFicha(idinve){

    $.ajax({
        type: "GET",
        url: app_inve.backend+"/"+idinve,
        dataType: "JSON",
        
        success: function (data) {
            $("#edit_id_inve").empty().val(data.idInventario);
            $("#edit_nomb_inve").empty().val(data.nombreElemento);
            $("#edit_desc_inve").empty().val(data.descripcionElemento);
            $("#edit_medi_inve").empty().val(data.undMedida);
            $("#edit_cant_inve").empty().val(data.cantidadAlmacen);    
            $("#edit_esta_inve").empty().val(data.estado);
        }
    });

}
$(document).ready(function () {
    app_inve.leer_elem();
    app_inve.reg_elem();
    app_inve.actualizar_elem();
});