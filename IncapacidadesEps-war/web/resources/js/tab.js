//$(document).ready(function () {
//    var elemento = $("#tab_pisos div").not(".tab");
//    elemento.click(function () {
//        $(".tab").animate({scrollLeft:150}, 1000);
//    })
//})

$(document).on("ready", function () {
    var flechas = $("[class *= flecha]");
    var elemento = $(".tab")
    $("[class *= flecha-izq]").click(function () {
        scrollear(elemento.scrollLeft() - 91, elemento)
    })

    $("[class *= flecha-der]").click(function () {
        scrollear(elemento.scrollLeft() + 91, elemento)
    })
    
    elemento.scroll(function () {
        var ancho = elemento.innerWidth();
        var ultimo = elemento.find("li:last-child");
        var ultimoPos = ultimo.position().left + ultimo.outerWidth()
        if(ancho > ultimoPos + 5)
           elemento.stop();
    })
    console.log('this:', this);
})

function scrollear(posicion, elemento) {
    elemento.animate({
        scrollLeft: posicion
    }, 1000);
}