app_prog= {
    backend_prog: "http://localhost:8080/api/ProgramaModel",
    
    leer_prog: function(){      
        $("#tabla_prog").DataTable({
            "ordering": false,
            "info": false,
            "processing": true,
            "paging": false,
            ajax: {
                url: app_prog.backend_prog + "/all",
                dataSrc:function(JSON){
                    console.log(JSON);
                    return JSON;
                }    
            },
            columns:[
                {defaultContent: "numeroFicha"},
                {data: "nombrePrograma"},
                {defaultContent: "nombreInstructor"},
                {defaultContent: "<button type='button' class='btn btn-success' data-toggle='modal' data-target='#editarp' id='editar_prog'>Editar <i class='bi bi-pencil'></i></button>"},
                {defaultContent: "<button type='button' class='btn btn-danger' id='eliminar_prog'>Eliminar <i class='bi bi-trash3'></i></button>"}
            ]
        })
    },
    registrar_prog: function(){
        $("#add_programa").click(function(){ 
            $("#instructores_prog").empty();
            $.ajax({
                type: "POST",
                url: app_prog.backend_prog + "/save",
                dataType: "JSON",
                error: function(){
                    alert("Error al importar instructores");
                },
            }).done(function(instructores){
                $.each(instructores, function (i, item) {
                    $("#reg_instructores_prog").append($('<option>',{
                        value: item.id,
                        text: item.name
                    }));
                });
            });
        });
        $("#reg_programa").click(function () { 
            var reg_prog_ficha=$("#reg_prog_ficha").val();
            var reg_prog_prog=$("#reg_prog_prog").val();
            var reg_instructores_prog=$("#reg_instructores_prog").val();
            var obj_prog={
                ficha: reg_prog_ficha,
                programa:reg_prog_prog,
                intructor:reg_instructores_prog
            }
            $.ajax({
                type: "POST",
                url: "",
                data: JSON.stringify(obj_prog),
                contentType: "application/json",
                success: function (response) {
                    table.ajax.reload();
                    table.draw();
                }
            }).fail(function($xhr){
                var data=$xhr.responseJSON;
            })

        });
    },
    actualizar_prog: function(){
        $("#tabla_prog").on('click', '#editar_prog', function () {

            var id_prog=table.row($(this).parents('<tr>')).id();

            $.ajax({
                url: backend, //+id_prog,
                dataType: "json",
                error: function () {
                    alert("Error en la petición");
                }
            }).done(function(data){
                $("edit_ficha_prog").empty().append(data.id);
                $("edit_prog_prog").val(data.name);
                $("edit_instru_prog").val(data.username);
            })            
        }),
        $("guardar_edit_prog").click(function () { 
            var edit_ficha_prog=$("#edit_ficha_prog").val();
            var edit_prog_prog=$("#edit_prog_prog").val();
            var edit_instru_prog=$("#edit_instru_prog").val();
            var obj_prog={
                ficha: edit_ficha_prog,
                programa:edit_prog_prog,
                intructor:edit_instru_prog
            }
            $.ajax({
                type: "PUT",
                url: "",
                data: JSON.stringify(obj_prog),
                contentType: "application/json",
                success: function (response) {
                    table.ajax.reload();
                    table.draw();

                    $("#editarp").modal('hide')
                }
            }).fail(function($xhr){
                var data=$xhr.responseJSON;
            })         
        });
    },
    eliminar_prog: function(){
        $("#tabla_prog").on('click', '#eliminar_prog', function () {
            
        }),
        $("#guardar_eliminar_prog").click(function () { 
            var eliminar_prog_id= $("#eliminar_prog_id").val();
            $.ajax({
                type: "DELETE",//+ eliminar_prog_id,
                url: "url" ,
                contentType: "application/json",
                success: function (response) {
                    table.ajax.reload();
                    table.draw();

                    $("#editarp").modal('hide')
                }
            }).fail(function($xhr){
                var data=$xhr.responseJSON;
            });
        });
    }
}
app_inst={
    backend: "http://localhost:8080/api/InsModel",

    leer_inst: function(){      
        $("#tabla_inst").DataTable({
            "ordering": false,
            "info": false,
            "processing": true,
            "paging": false,
            ajax: {
                url: app_inst.backend + "/all",
                dataSrc:function(JSON){
                    return JSON;
                }    
            },
            columns:[
                {data: "cedula"},
                {data: "nombreInstructor"},
                {data: "celular"},
                {data: "correo"},              
                {defaultContent: "<button type='button' class='btn btn-success' data-toggle='modal' data-target='#editari'>Editar <i class='bi bi-pencil'></i></button>"},
                {defaultContent: "<button type='button' class='btn btn-danger' >Eliminar <i class='bi bi-trash3'></i></button>"}
            ]
        })
    }
}
$(document).ready(function(){      
    app_prog.leer_prog();
    app_prog.registrar_prog();
    app_prog.actualizar_prog();
    app_prog.eliminar_prog();
    app_inst.leer_inst();
});