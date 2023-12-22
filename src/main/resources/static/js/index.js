document.addEventListener("DOMContentLoaded", function () {
    let noticias = document.querySelectorAll(".noticia");
    let index = 0;

    function mostrarNoticia() {
        noticias[index].style.display = "none";
        index = (index + 1) % noticias.length;
        noticias[index].style.display = "block";
    }

    setInterval(mostrarNoticia, 7000); // Cambiar cada 7 segundos (7000 ms)
});
