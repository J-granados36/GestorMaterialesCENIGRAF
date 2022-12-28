app_elem={
    // Se llama la url del controller de intructores 
    backend: "http://localhost:8080/api/ElementoModel",
    // Se DataTable para darle un diseño por defecto de jquery 
    leer_elem: function(){     
        $.ajax({
            url: app_elem.backend + "/all",
            type: 'GET',
            datatype: 'JSON',
            success: function (response) {
                var myItems= response;
                var valor = '';
                for (i = 0; i < myItems.length; i++) {
                    valor +='<tr>'+
                                '<td>'+ myItems[i].idElemento+'</td>'+
                                '<td>'+ myItems[i].nombreElemento+'</td>'+
                                '<td>'+ myItems[i].descripcion+'</td>'+
                                '<td>'+ myItems[i].undMedida+'</td>'+
                                '<td>'+ myItems[i].cantidad+'</td>'+
                                '<td>'+'<button class="btn btn-danger" onclick="borrarElemento('+ myItems[i].idElemento+')">Borrar <i class="bi bi-trash3"></i></button>'+'</td>'+
                                '<td>'+"<button type='button' class='btn btn-success' onclick='editarInstructor("+ myItems[i].idElemento+")' data-toggle='modal' data-target='#editari'>Editar <i class='bi bi-pencil'></i></button>"+'</td>'+
                            '</tr>'
                }
                $("#body_elem").html(valor);
            }
        })
    },
    reg_elem: function(){
        $("#reg_elementos").click(function() { 
            var reg_elem_nomb=$("#reg_elem_nomb").val();
            var reg_elem_desc=$("#reg_elem_desc").val();
            var reg_elem_cant=$("#reg_elem_cant").val();
            var reg_elem_medi=$("#reg_elem_medi").val();
            var obj_elem={
                cantidad:reg_elem_cant,
                undMedida:reg_elem_medi,
                descripcion:reg_elem_desc,
                nombreElemento:reg_elem_nomb
            }
            $.ajax({
                type: "POST",
                url: app_elem.backend + "/save",
                data: JSON.stringify(obj_elem),
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
function borrarElemento(idElem){
        
    var idEliminar={
        idElemento:idElem
    }   
    $.ajax({
        type: "DELETE",
        url: app_elem.backend+'/'+idElem,
        data: JSON.stringify(idEliminar),
        dataType: "JSON",
        contentType: "application/json",
        success: function (response) {
            location.reload();
        }
    })
}
$(document).ready(function () {
    app_elem.leer_elem();
    app_elem.reg_elem();
    app_elem.actualizar_elem();
});