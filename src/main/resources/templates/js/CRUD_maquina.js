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
                                '<td>'+ myItems[i].placa+'</td>'+
                                '<td>'+ myItems[i].adquisicion+'</td>'+
                                '<td>'+'<button class="btn btn-danger" onclick="borrarMaquina('+ myItems[i].idMaquina+')">Borrar</button>'+'</td>'+
                                '<td>'+"<button type='button' class='btn btn-success' onclick='editarMaquina("+ myItems[i].idMaquina+")' data-toggle='modal' data-target='#editari'>Editar <i class='bi bi-pencil'></i></button>"+'</td>'+
                            '</tr>'
                }
                $("#body_maqu").html(valor);
            }
        })
    },
    reg_maqu: function(){
        $("#reg_maquinas").click(function() {
            var reg_maqu_fech=$("#reg_maqu_fech").val();
            var reg_maqu_nom=$("#reg_maqu_nom").val();
            var reg_maqu_num=$("#reg_maqu_num").val();
            var obj_prog={
                adquisicion:reg_maqu_fech,
                placa:reg_maqu_num,
                nombreMaquina:reg_maqu_nom
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
        $('#formulario_act_maqu').on("click", function (event){
            event.preventDefault();
         })

        $("#cambios_maqu").click(function(){

            var edit_nomb_maqu=$("#edit_nomb_maqu").val();
            var edit_placa_maqu=$("#edit_placa_maqu").val();
            var edit_fech_maqu=$("#edit_fech_maqu").val();

            var datos_editados={
                nombreMaquina:edit_nomb_maqu,
                placa:edit_placa_maqu,
                adquisicion:edit_fech_maqu,
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
$(document).ready(function () {
    app_maqu.leer_maqu();
    app_maqu.reg_maqu();
    app_maqu.actualizar_maqu();
});