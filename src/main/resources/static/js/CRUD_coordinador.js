$(function () {
    $("#imagen_firma").html("<img src='https://mdbootstrap.com/img/Photos/Others/placeholder.jpg' style='width: 200px'/>");
    $("#subir_firma").on("change", function (evt) {
        var files = evt.target.files; 
       
        //Obtenemos la imagen del campo "file". 
        for (var i = 0, f; f = files[i]; i++) {         
            //Solo admitimos imágenes.
            if (!f.type.match('image.*')) {
                continue;
            }
        
            var reader = new FileReader();
            
            reader.onload = (function(theFile) {
                return function(e) {
                // Creamos la imagen.
                    $("#imagen_firma").html(['<img class="thumb" style="width: 200px" src="', e.target.result,'" title="', escape(theFile.name), '"/>'].join(''));
                };
            })(f);
    
            reader.readAsDataURL(f);
        }
    });
});