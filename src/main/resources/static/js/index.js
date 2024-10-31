document.addEventListener("DOMContentLoaded", function () {
    let noticias = document.querySelectorAll(".noticia");
    let index = 0;
    mostrarNoticia();


    


    function mostrarNoticia() {
        noticias[index].style.display = "none";
        index = (index + 1) % noticias.length;
        noticias[index].style.display = "block";

        noticias[index].style.backgroundImage = `url(${noticias[index].firstElementChild.textContent})`;
    


        
    }


    

    setInterval(mostrarNoticia, 7000); // Cambiar cada 7 segundos (7000 ms)
});


