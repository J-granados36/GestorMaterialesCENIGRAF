var app= {
    backend: "http://localhost:8080/api/",
    init: function(){
        app.initDataTable("#tabla_prog");
    },
    initDataTable(id){
        $(id).DataTable({
            ajax: {
                URL: app.backend + "/all",
                dataSrc: function(json){
                    return json;
                } 
            },
            columns:[
                {data: ""},
                {data: ""},
                {data: ""}
            ]
        })
    }
}
$(document).ready(function () {      
    app.init();
});

/*function reg_program(){
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
}*/