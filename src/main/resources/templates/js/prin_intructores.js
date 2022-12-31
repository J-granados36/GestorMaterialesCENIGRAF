var contador=1;
var contador2=2;
function suma_elementom(){
    let tb_elementos=document.getElementById("tb_mante").insertRow(contador2++);
    let col1=tb_elementos.insertCell(0);
    let col2=tb_elementos.insertCell(1);

    contador ++;

    col1.innerHTML='<td><input class="form-control" type="number" value="'+contador+'" readonly></td>';
    col2.innerHTML='<td><input type="search" class="form-control" placeholder="Buscar elemento" list="lista_elementos"></td>';

}
