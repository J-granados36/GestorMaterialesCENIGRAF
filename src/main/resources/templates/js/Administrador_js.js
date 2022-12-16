var app_prog= {
    backend: "https://jsonplaceholder.typicode.com/users",
    
    leer_prog: function(){      
        $("#tabla_prog").DataTable({
            "ordering": false,
            "info": false,
            "processing": true,
            "paging": false,
            ajax: {
                url: app_prog.backend,
                dataSrc:function(JSON){
                    return JSON;
                }    
            },
            columns:[
                {data: "id"},
                {data: "name"},
                {data: "username"},
                {defaultContent: "<button type='button' class='btn btn-success' data-toggle='modal' data-target='#editarp'>Editar <i class='bi bi-pencil'></i></button>"},
                {defaultContent: "<button type='button' class='btn btn-danger' >Eliminar <i class='bi bi-trash3'></i></button>"}
            ]
        })
    },
    registrar_prog: function(){
        $("#add_programa").click(function(){ 
            $("#instructores_prog").empty();
            $.ajax({
                type: "GET",
                url: app_prog.backend,
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
            $("#reg_prog_ficha").val();
            $("#reg_prog_prog").val();
            $("#reg_instructores_prog").val();
        });
    },
    actualizar_prog: function(){

    },
    eliminar_prog: function(){

    }
}
app_inst={
    backend: "https://jsonplaceholder.typicode.com/users",

    leer_inst: function(){      
        $("#tabla_inst").DataTable({
            "ordering": false,
            "info": false,
            "processing": true,
            "paging": false,
            ajax: {
                url: app_prog.backend,
                dataSrc:function(JSON){
                    return JSON;
                }    
            },
            columns:[
                {data: "id"},
                {data: "name"},
                {data: "username"},
                {data: "address.city"},
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