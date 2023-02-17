function borrarPersonal(idInst){
        
    var idEliminar={
        id:idInst
    }   
    $.ajax({
        type: "DELETE",
        url: app_inst.backend+'/'+idInst,
        data: JSON.stringify(idEliminar),
        dataType: "JSON",
        contentType: "application/json",
        success: function (response) {
            location.reload();
        }
    })
}
function editarPersonal(idInst){
    $.ajax({
        type: "GET",
        url: app_inst.backend+"/"+idInst,
        dataType: "JSON",
        
        success: function (data) {
            $("#edit_id_inst").empty().val(data.idPersonal);
            $("#edit_cedu_inst").empty().val(data.cedula);
            $("#edit_nomb_inst").empty().val(data.nombrePersonal);
            $("#edit_celu_inst").empty().val(data.celular);
        }
    });
}
app_inst={
    // Se llama la url del controller de intructores 
    backend: "http://localhost:8080/api/InsModel",
    // Se DataTable para darle un diseño por defecto de jquery 
    leer_inst: function(){     
        $.ajax({
            
            url: app_inst.backend + "/all",
            type: 'GET',
            datatype: 'JSON',
            success: function (response) {
                var myItems= response;
                var valor = '';
                for (i = 0; i < myItems.length; i++) {
                    valor +='<tr>'+
                                '<td>'+ myItems[i].cedula+'</td>'+
                                '<td>'+ myItems[i].nombreInstructor+'</td>'+
                                '<td>'+ myItems[i].celular+'</td>'+
                                '<td>'+'<button class="btn btn-danger" onclick="borrarPersonal('+ myItems[i].idPersonal+')">Borrar</button>'+'</td>'+
                                '<td>'+"<button type='button' class='btn btn-success' onclick='editarPersonal("+ myItems[i].idPersonal+")' data-toggle='modal' data-target='#editari'>Editar <i class='bi bi-pencil'></i></button>"+'</td>'+
                            '</tr>'
                }
                $("#body_inst").html(valor);
            }
        })
    },
    reg_inst: function(){
        $("#reg_Personales").click(function() { 
            var reg_instru_docu=$("#reg_instru_docu").val();
            var reg_instru_nomb=$("#reg_instru_nomb").val();
            var reg_instru_celu=$("#reg_instru_celu").val();
            var reg_instru_corr=$("#reg_instru_corr").val();
            var obj_prog={
                cedula:reg_instru_docu,
                celular:reg_instru_celu,
                correo:reg_instru_corr,
                nombrePersonal:reg_instru_nomb
            }
            $.ajax({
                type: "POST",
                url: app_inst.backend + "/save",
                data: JSON.stringify(obj_prog),
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
    actualizar_inst(){
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
                idPersonal:edit_id_inst,
                cedula:edit_cedu_inst,
                nombrePersonal:edit_nomb_inst,
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
$(document).ready(function () {
    app_inst.leer_inst();
    app_inst.reg_inst();
    app_inst.actualizar_inst();
});