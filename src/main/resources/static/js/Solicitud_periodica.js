$(function () {
    n =  new Date();y = n.getFullYear();m = n.getMonth() + 1;d = n.getDate();
    if(d<10){d='0'+d;}
    if(m<10){ m='0'+m;}
    $("#f_solicitud").val(d+"/"+m+"/"+y);
    $("#ficha").select2({ 
        ajax:{
            url: "http://localhost:8080/api/FichaModel/all",
            dataType: "JSON",
            processResults: function (data) {
                return{
                    results:
                        $.map(data, function (obj) {
                            return{ id: obj.idFicha, text: obj.numeroFicha}
                        })
                }
        }},
        placeholder: "Seleccionar la ficha"
    });
    $("#tip_cuentadante").select2({
        placeholder: "Seleccionar el tipo"
    });
});
$("#tip_cuentadante").on("change", function () { 

    var tip_cue=$("#tip_cuentadante option:selected").val();
        
    switch(tip_cue){
        case "Unipersonal":
            $(".tipo_cuenta_nom").html(
                '<label>Nombre cuentadante:</label>'+
                '<select class="form-control mt-2" id="nom_cue_uni" style="width: 100%" required></select>'
            );
            $(".tipo_cuenta_doc").html(
                '<label>Documento cuentadante:</label>'+
                '<input type="number" class="form-control " id="doc_cue_uni" readonly>'
            );
            $("#nom_cue_uni").select2({
                ajax:{
                    url: "http://localhost:8080/api/PersonalCenigrafModel/all",
                    dataType: "JSON",
                    processResults: function (data) {
                        return{
                            results:
                                $.map(data, function (obj) {
                                    return{ id: obj.idPer, text: obj.nombrePersonal}
                                })
                        }
                }},
                placeholder: "Seleccionar el cuentadante"
            })
            $("#nom_cue_uni").on("change focus", function () {
                var cue_uni=$("#nom_cue_uni").val();
                $.ajax({
                    type: "GET",
                    url: "http://localhost:8080/api/PersonalCenigrafModel/"+cue_uni,
                    dataType: "JSON",
                    success: function (response) {
                        $("#doc_cue_uni").val(response.documento);
                    }
                });
            });
            break;

        case "Multiple":
            $(".tipo_cuenta_nom").html(
                '<label>Nombre cuentadante 1:</label>'+
                '<select class="form-control mt-2" id="nom_cue_uno" required></select>'+
                '<label class="mt-2">Nombre cuentadante 2:</label>'+
                '<select class="form-control mt-2" id="nom_cue_dos"></select>'+
                '<label class="mt-2">Nombre cuentadante 3:</label>'+
                '<select class="form-control mt-2" id="nom_cue_tres"></select>'
            );
            $(".tipo_cuenta_doc").html(
                '<label >Documento cuentadante:</label>'+
                '<input type="number" class="form-control" id="doc_cuenta_uno" readonly>'+
                '<label class="mt-2">Documento cuentadante:</label>'+
                '<input type="number" class="form-control" id="doc_cuenta_dos" readonly>'+
                '<label class="mt-2">Documento cuentadante:</label>'+
                '<input type="number" class="form-control" id="doc_cuenta_tres" readonly>'
            );
            $("#nom_cue_uno").select2({
                ajax:{
                    url: "http://localhost:8080/api/PersonalCenigrafModel/all",
                    dataType: "JSON",
                    processResults: function (data) {
                        return{
                            results:
                                $.map(data, function (obj) {
                                    return{ id: obj.idPer, text: obj.nombrePersonal}
                                })
                        }
                }},
                placeholder: "Seleccionar el cuentadante"
            })
            $("#nom_cue_uno").on("change", function () {
                var cue_uni=$("#nom_cue_uno").val();
                $.ajax({
                    type: "GET",
                    url: "http://localhost:8080/api/PersonalCenigrafModel/"+cue_uni,
                    dataType: "JSON",
                    success: function (response) {
                        $("#doc_cuenta_uno").val(response.documento);
                    }
                });
            });
            $("#nom_cue_dos").select2({
                ajax:{
                    url: "http://localhost:8080/api/PersonalCenigrafModel/all",
                    dataType: "JSON",
                    processResults: function (data) {
                        return{
                            results:
                                $.map(data, function (obj) {
                                    return{ id: obj.idPer, text: obj.nombrePersonal}
                                })
                        }
                }},
                placeholder: "Seleccionar el cuentadante"
            })
            $("#nom_cue_dos").on("change", function () {
                var cue_uni=$("#nom_cue_dos").val();
                $.ajax({
                    type: "GET",
                    url: "http://localhost:8080/api/PersonalCenigrafModel/"+cue_uni,
                    dataType: "JSON",
                    success: function (response) {
                        $("#doc_cuenta_dos").val(response.documento);
                    }
                });
            });
            $("#nom_cue_tres").select2({
                ajax:{
                    url: "http://localhost:8080/api/PersonalCenigrafModel/all",
                    dataType: "JSON",
                    processResults: function (data) {
                        return{
                            results:
                                $.map(data, function (obj) {
                                    return{ id: obj.idPer, text: obj.nombrePersonal}
                                })
                        }
                }},
                placeholder: "Seleccionar el cuentadante"
            })
            $("#nom_cue_tres").on("change", function () {
                var cue_uni=$("#nom_cue_tres").val();
                $.ajax({
                    type: "GET",
                    url: "http://localhost:8080/api/PersonalCenigrafModel/"+cue_uni,
                    dataType: "JSON",
                    success: function (response) {
                        $("#doc_cuenta_tres").val(response.documento);
                    }
                });
            });
            break;

        default:
            $(".tipo_cuenta_nom").html(" ");
            $(".tipo_cuenta_doc").html(" ");
            break;
    }
});