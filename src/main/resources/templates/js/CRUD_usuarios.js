app_usua={
    // Se llama la url del controller de intructores 
    backend: "http://localhost:8080/api/UserModel",
    leer_usua: function(){     
        $.ajax({
            url: app_usua.backend + "/all",
            type: 'GET',
            datatype: 'JSON',
            success: function (response) {
                var myItems= response;
                var valor = '';
                for (i = 0; i < myItems.length; i++) {
                    valor +='<tr>'+
                                '<td>'+ myItems[i].nombre+'</td>'+
                                '<td>'+ myItems[i].contrasena+'</td>'+
                                '<td>'+'<button class="btn btn-danger" onclick="borrarUsuario('+ myItems[i].idUsuario+')">Borrar</button>'+'</td>'+
                                '<td>'+"<button type='button' class='btn btn-success' onclick='editarInstructor("+ myItems[i].idUsuario+")' data-toggle='modal' data-target='#editari'>Editar <i class='bi bi-pencil'></i></button>"+'</td>'+
                            '</tr>'
                }
                $("#body_usua").html(valor);
            }
        })
    },
    reg_usua: function(){
        $("#reg_usuario").click(function() { 
            var reg_usuario_nomb=$("#reg_usuario_nomb").val();
            var reg_usuario_cont=$("#reg_usuario_cont").val();
            var obj_usua={
                nombre:reg_usuario_nomb,
                contrasena:reg_usuario_cont,
            }
            $.ajax({
                type: "POST",
                url: app_usua.backend + "/save",
                data: JSON.stringify(obj_usua),
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
    actualizar_usua(){
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
function borrarUsuario(idUsua){
        
    var idEliminar={
        idUsuario:idUsua
    }   
    $.ajax({
        type: "DELETE",
        url: app_usua.backend+'/'+idUsua,
        data: JSON.stringify(idEliminar),
        dataType: "JSON",
        contentType: "application/json",
        success: function (response) {
            location.reload();
        }
    })
}
$(document).ready(function () {
    app_usua.leer_usua();
    app_usua.reg_usua();
    app_usua.actualizar_usua();
});