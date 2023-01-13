app_inve={
    // Se llama la url del controller de intructores 
    backend: "http://localhost:8080/api/Inventario",
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
                                '<td>'+ myItems[i].idInventario+'</td>'+
                                '<td>'+ myItems[i].nombreElemento+'</td>'+
                                '<td>'+ myItems[i].descripcionElemento+'</td>'+
                                '<td>'+ myItems[i].undMedida+'</td>'+
                                '<td>'+ myItems[i].cantidadAlmacen+'</td>'+
                                '<td>'+ myItems[i].estado+'</td>'+
                                '<td>'+'<button class="btn btn-danger" onclick="borrarElemento('+ myItems[i].idInventario+')">Borrar <i class="bi bi-trash3"></i></button>'+'</td>'+
                                '<td>'+"<button type='button' class='btn btn-success' onclick='editarInstructor("+ myItems[i].idInventario+")' data-toggle='modal' data-target='#editari'>Editar <i class='bi bi-pencil'></i></button>"+'</td>'+
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
        $('#formulario_act_ins').on("click", function (event){
            event.preventDefault();
         })

        $("#cambios_inst").click(function(){

            var edit_id_inst=$("#edit_id_inst").val();
            var edit_cedu_inst=$("#edit_cedu_inst").val();
            var edit_nomb_inst=$("#edit_nomb_inst").val();
            var edit_celu_inst=$("#edit_celu_inst").val();
            var edit_corr_inst=$("#edit_corr_inst").val();

            var datos_editados={
                idInstructor:edit_id_inst,
                cedula:edit_cedu_inst,
                nombreInstructor:edit_nomb_inst,
                celular:edit_celu_inst,
                correo:edit_corr_inst
            }

            var datosJSON=JSON.stringify(datos_editados);
            
            $.ajax({   
                type: "PUT",
                url: app_inst.backend+"/update",
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
$(document).ready(function () {
    app_inve.leer_elem();
    app_inve.reg_elem();
    app_inve.actualizar_elem();
});