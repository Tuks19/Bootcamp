function raiz_positiva (a,b,c){
    return (-b + Math.sqrt(b**2 - 4*a*c)) / (2*a);
}

console.log(raiz_positiva(1, -3, 2));

function raiz_negativa (a,b,c){
    return (-b - Math.sqrt(b**2 - 4*a*c)) / (2*a);
}

console.log(raiz_negativa(1, -3, 2));

function cambio(id, nuevoTexto) {
    document.getElementById(id).innerHTML = nuevoTexto;
}

function cambioNumerico(id,) {
    let randomNumber = Math.floor(Math.random() * 100) + 1;
    document.getElementById(id).innerHTML = randomNumber;
}