var contadorp=1;
var contador2p=2;
var contadora=1;
var contador2a=2;
var contador=1;
var contador2=2;
function suma_elemento(){
    let tb_elementos=document.getElementById("tb_elementos").insertRow(contador2p++);
    let col1=tb_elementos.insertCell(0);
    let col2=tb_elementos.insertCell(1);
    let col3=tb_elementos.insertCell(2);
    let col4=tb_elementos.insertCell(3);
    let col5=tb_elementos.insertCell(4);

    contadorp++;

    col1.innerHTML='<td><input class="form-control" type="number" value="'+contadorp+'" readonly></td>';
    col2.innerHTML='<input type="search" class="form-control" placeholder="Buscar elemento" list="lista_elementos">';
    col3.innerHTML='<td><input type="number" class="form-control"></td>';
    col4.innerHTML='<td><select class="form-control"><option value="" default hidden></option><option value="">Unidad</option><option value="">Pliego</option><option value="">1/2 Pliego</option><option value="">Caja</option><option value="">Kilo</option><option value="">Rollo</option><option value="">Lamina</option><option value="">Galón</option><option value="">Paquete</option><option value="">Metros</option></select></td>';
    col5.innerHTML='<td><textarea style="height: 40px;" class="form-control" id=""></textarea></td>';          
    
}
function suma_elementop(){
    let tb_elementos=document.getElementById("tb_elementop").insertRow(contador2a++);
    let col1=tb_elementos.insertCell(0);
    let col2=tb_elementos.insertCell(1);
    let col3=tb_elementos.insertCell(2);
    let col4=tb_elementos.insertCell(3);
    let col5=tb_elementos.insertCell(4);

    contadora ++;

    col1.innerHTML='<td><input class="form-control" type="number" value="'+contadora+'" readonly></td>';
    col2.innerHTML='<td><input type="search" class="form-control" placeholder="Buscar elemento" list="lista_elementos"></td>';
    col3.innerHTML='<td><input type="number" class="form-control"></td>';
    col4.innerHTML='<td><select class="form-control"><option value="" default hidden></option><option value="">Unidad</option><option value="">Pliego</option><option value="">1/2 Pliego</option><option value="">Caja</option><option value="">Kilo</option><option value="">Rollo</option><option value="">Lamina</option><option value="">Galón</option><option value="">Paquete</option><option value="">Metros</option></select></td>';
    col5.innerHTML='<td><textarea style="height: 40px;" class="form-control" id=""></textarea></td>';          
    
}
function suma_elementom(){
    let tb_elementos=document.getElementById("tb_mante").insertRow(contador2++);
    let col1=tb_elementos.insertCell(0);
    let col2=tb_elementos.insertCell(1);

    contador ++;

    col1.innerHTML='<td><input class="form-control" type="number" value="'+contador+'" readonly></td>';
    col2.innerHTML='<td><input type="search" class="form-control" placeholder="Buscar elemento" list="lista_elementos"></td>';

}
