var app= {
    backend: "https://jsonplaceholder.typicode.com/users",
    leer_prog: function(){      
        $("#tabla_prog").DataTable({
            ajax: {
                url: app.backend,
                dataSrc:function(JSON){
                    return JSON;
                } 
            },
            columns:[
                {data: "id"},
                {data: "name"},
                {data: "username"}
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