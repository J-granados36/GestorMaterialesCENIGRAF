function borrarAmbiente(idAmbi){

    var idEliminar={
        id:idAmbi
    }
    $.ajax({
        type: "DELETE",
        url: app_ambi.backend+'/'+idAmbi,
        data: JSON.stringify(idEliminar),
        dataType: "JSON",
        contentType: "application/json",
        success: function (response) {
            location.reload();
        }
    })
}
function editarAmbiente(idAmbi){
    $.ajax({
        type: "GET",
        url: app_ambi.backend+"/"+idAmbi,
        dataType: "JSON",

        success: function (data) {
            $("#edit_nomb_ambi").empty().val(data.nombreAmbiente);

        }
    });
}

app_ambi={
    // Se llama la url del controller de intructores 
    backend: "http://localhost:8080/api/AmbienteModel",
    leer_ambi: function(){     
        $.ajax({
            url: app_ambi.backend + "/all",
            type: 'GET',
            datatype: 'JSON',
            success: function (response) {
                var myItems= response;
                var valor = '';
                for (i = 0; i < myItems.length; i++) {
                    valor +='<tr>'+
                                '<td>'+ myItems[i].nombreAmbiente+'</td>'+
                                '<td>'+'<button class="btn btn-danger" onclick="borrarAmbiente('+ myItems[i].idAmbiente+')">Borrar</button>'+'</td>'+
                                '<td>'+"<button type='button' class='btn btn-success' onclick='editarAmbiente("+ myItems[i].idAmbiente+")' data-toggle='modal' data-target='#editari'>Editar <i class='bi bi-pencil'></i></button>"+'</td>'+
                            '</tr>'
                }
                $("#body_ambi").html(valor);
            }
        })
    },
    reg_ambi: function(){
        $("#reg_ambientes").click(function() {
            var reg_ambi_nomb=$("#reg_ambi_nomb").val();
            var obj_prog={
                nombreAmbiente:reg_ambi_nomb
            }
            $.ajax({
                type: "POST",
                url: app_ambi.backend + "/save",
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
    actualizar_ambi(){
        $('#formulario_act_ambi').on("click", function (event){
            event.preventDefault();
         })

        $("#cambios_ambi").click(function(){

            var edit_nomb_ambi=$("#edit_nomb_ambi").val();
            var datos_editados={
                nombreAmbiente:edit_nomb_ambi,

            }

            var datosJSON=JSON.stringify(datos_editados);
            
            $.ajax({   
                type: "PUT",
                url: app_ambi.backend+"/update",
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
    app_ambi.leer_ambi();
    app_ambi.reg_ambi();
    app_ambi.actualizar_ambi();
});