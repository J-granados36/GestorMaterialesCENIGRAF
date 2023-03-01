function borrarMaquina(idMaqu){

    var idEliminar={
        id:idMaqu
    }
    $.ajax({
        type: "DELETE",
        url: app_maqu.backend+'/'+idMaqu,
        data: JSON.stringify(idEliminar),
        dataType: "JSON",
        contentType: "application/json",
        success: function (response) {
            location.reload();
        }
    })
}
function editarMaquina(idMaqu){
    $.ajax({
        type: "GET",
        url: app_maqu.backend+"/"+idMaqu,
        dataType: "JSON",

        success: function (data) {
            $("#edit_nomb_maqu").empty().val(data.nombreMaquina);
            $("#edit_placa_maqu").empty().val(data.placa);
            $("#edit_seri_maqu").empty().val(data.serial);
            $("#edit_fech_maqu").empty().val(data.adquisicion);
        }
    });
}

app_maqu={
    // Se llama la url del controller de intructores 
    backend: "http://localhost:8080/api/MaquinaModel",
    leer_maqu: function(){     
        $.ajax({
            url: app_maqu.backend + "/all",
            type: 'GET',
            datatype: 'JSON',
            success: function (response) {
                var myItems= response;
                var valor = '';
                for (i = 0; i < myItems.length; i++) {
                    valor +='<tr>'+
                                '<td>'+ myItems[i].nombreMaquina+'</td>'+
                                '<td>'+ myItems[i].serial+'</td>'+
                                '<td>'+ myItems[i].placa+'</td>'+
                                '<td>'+ myItems[i].adquisicion+'</td>'+
                                '<td>'+'<button class="btn btn-danger" onclick="borrarMaquina('+ myItems[i].idMaquina+')">Borrar <i class="bi bi-trash3"></i></button>'+'</td>'+

                                '<td>'+"<button type='button' class='btn btn-success' onclick='editarMaquina("+ myItems[i].idMaquina+")' data-toggle='modal' data-target='#editarm'>Editar <i class='bi bi-pencil'></i></button>"+'</td>'+
                            '</tr>'
                }
                $("#body_maqu").html(valor);
            }
        })
    },
    reg_maqu: function(){

        $("#reg_maquina").click(function() { 
            var reg_seri_maqu=$("#reg_seri_maqu").val();
            var reg_fech_maqu=$("#reg_fech_maqu").val();
            var reg_nomb_maqu=$("#reg_nomb_maqu").val();
            var reg_plac_maqu=$("#reg_plac_maqu").val();

            var obj_prog={
                adquisicion:reg_fech_maqu,
                nombreMaquina:reg_nomb_maqu,
                placa:reg_plac_maqu,
                serial:reg_seri_maqu
            }
            $.ajax({
                type: "POST",
                url: app_maqu.backend + "/save",
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
    actualizar_maqu(){

        $('#formulario_act_maq').on("click", function (event){
            event.preventDefault();
         })

        $("#cambios_maqu").click(function(){


            var edit_id_maqu= $("#edit_id_maqu").val();
            var edit_nomb_maqu= $("#edit_nomb_maqu").val();
            var edit_adqu_maqu= $("#edit_adqu_maqu").val();
            var edit_seri_maqu= $("#edit_seri_maqu").val();
            var edit_plac_maqu= $("#edit_plac_maqu").val();

            var datos_editados={
                idMaquina:edit_id_maqu,
                nombreMaquina:edit_nomb_maqu,
                adquisicion:edit_adqu_maqu,
                placa:edit_plac_maqu,
                serial:edit_seri_maqu
            }

            var datosJSON=JSON.stringify(datos_editados);
            
            $.ajax({   
                type: "PUT",
                url: app_maqu.backend+"/update",
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
function borrarMaquina(idMaqu){
        
    var idEliminar={
        id:idMaqu
    }   
    $.ajax({
        type: "DELETE",
        url: app_maqu.backend+'/'+idMaqu,
        data: JSON.stringify(idEliminar),
        dataType: "JSON",
        contentType: "application/json",
        success: function (response) {
            location.reload();
        }
    })
}
function editarMaquina(idMaqu){
    $.ajax({
        type: "GET",
        url: app_maqu.backend+"/"+idMaqu,
        dataType: "JSON",
        
        success: function (data) {
            $("#edit_id_maqu").empty().val(data.idMaquina);
            $("#edit_nomb_maqu").empty().val(data.nombreMaquina);
            $("#edit_adqu_maqu").empty().val(data.adquisicion);
            $("#edit_plac_maqu").empty().val(data.placa);
            $("#edit_seri_maqu").empty().val(data.serial);
        }
    });
}
$(document).ready(function () {
    app_maqu.leer_maqu();
    app_maqu.reg_maqu();
    app_maqu.actualizar_maqu();
});