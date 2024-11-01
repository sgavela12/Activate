document.addEventListener('DOMContentLoaded', function() {
  const hamburger = document.querySelector(".hamburger");
  const navLinks = document.querySelector(".nav-links");
  const links = document.querySelectorAll(".nav-links li");
  const userButton = document.getElementById('userButton');
  const dropdownContent = document.querySelector('.dropdown-content');

  // Manejo de la hamburguesa
  hamburger.addEventListener('click', ()=>{
    navLinks.classList.toggle("open");
    links.forEach(link => {
      link.classList.toggle("fade"); // Asegúrate de que la clase 'fade' esté en el CSS
    });

    // Animación de la hamburguesa
    hamburger.classList.toggle("toggle");
  });

  // Manejo de la lógica de active para los enlaces
  const currentPath = window.location.pathname;
  links.forEach(link => {
    if (link.getAttribute('data-route') === currentPath) {
      link.classList.add('active');
    } else {
      link.classList.remove('active');
    }
  });

  // Manejo del menú desplegable
  if (userButton) {
    userButton.addEventListener('click', function(event) {
      event.stopPropagation(); // Prevenir que el clic cierre el menú inmediatamente
      if (dropdownContent) {
        dropdownContent.style.display = dropdownContent.style.display === 'block' ? 'none' : 'block';
      }
    });
  }

  // Cierra el menú desplegable al hacer clic fuera de él
  document.addEventListener('click', function(event) {
    if (dropdownContent && !userButton.contains(event.target) && !dropdownContent.contains(event.target)) {
      dropdownContent.style.display = 'none';
    }
  });
});
