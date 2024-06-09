const hamburger = document.querySelector(".hamburger");
const navLinks = document.querySelector(".nav-links");
const links = document.querySelectorAll(".nav-links li");

hamburger.addEventListener('click', ()=>{
   //Animate Links
    navLinks.classList.toggle("open");
    links.forEach(link => {
        link.classList.toggle("fade");
    });

    //Hamburger Animation
    hamburger.classList.toggle("toggle");
});


document.addEventListener("DOMContentLoaded", function() {
  const links = document.querySelectorAll('.nav-link');
  const loginButton = document.getElementById('loginButton');
  const currentPath = window.location.pathname;

  links.forEach(link => {
    if (link.getAttribute('data-route') === currentPath) {
      link.classList.add('active');
    } else {
      link.classList.remove('active');
    }
  });

  // Check if the current path is the login page
  if (currentPath === '/activate/iniciarSesion') {
    loginButton.classList.add('active');
  } else {
    loginButton.classList.remove('active');
  }
});

// JavaScript for dropdown menu
document.addEventListener('DOMContentLoaded', function() {
  const userButton = document.getElementById('userButton');
  const dropdownContent = document.querySelector('.dropdown-content');

  userButton.addEventListener('click', function(event) {
    event.stopPropagation();
    dropdownContent.style.display = dropdownContent.style.display === 'block' ? 'none' : 'block';
  });

  document.addEventListener('click', function() {
    dropdownContent.style.display = 'none';
  });
});
