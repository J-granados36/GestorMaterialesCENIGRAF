var app= {
    backend: "https://jsonplaceholder.typicode.com/users",
    leer_prog: function(){      
        $("#tabla_prog").DataTable({
            "ordering": false,
            "info": false,
            "processing": true,
            "paging": false,
            ajax: {
                url: app.backend,
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
        $("#reg_programa").click(function(){ 
            $.ajax({
                type: "POST",
                url: "url",
                data: "data",
                dataType: "dataType",
                success: function (response) {
                    
                }
            });
        });
    },
    actualizar_prog: function(){

    },
    eliminar_prog: function(){

    }
}
$(document).ready(function () {      
    app.leer_prog();
    app.registrar_prog();
    app.actualizar_prog();
    app.eliminar_prog();
});