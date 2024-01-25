let registrarse = document.getElementById("registrarse-button")

document.addEventListener('DOMContentLoaded', function () {
let loginTab = document.getElementById('loginTab');
let signupTab = document.getElementById('signupTab');
let regLogCheckbox = document.getElementById('reg-log');
let cardWrapper = document.querySelector('.card-3d-wrapper');
let arrowLabel = document.querySelector('.arrow-label');

function showLoginForm() {
cardWrapper.style.transform = 'rotateY(0deg)';

}

function showSignupForm() {
cardWrapper.style.transform = 'rotateY(180deg)';

}

loginTab.addEventListener('click', function () {
showLoginForm();
regLogCheckbox.checked = false;
});

signupTab.addEventListener('click', function () {
showSignupForm();
regLogCheckbox.checked = true;
});

regLogCheckbox.addEventListener('change', function () {
if (regLogCheckbox.checked) {
  showSignupForm();
} else {
  showLoginForm();
}
});
});

registrarse.addEventListener("click",comprobarClave)



document.addEventListener('DOMContentLoaded', function () {

  let formRegistro = document.getElementById('formulario-registro');

  formRegistro.addEventListener('submit', function (event) {
      event.preventDefault();

      comprobarClave();

      if (validacionExitosa) {
          this.submit();
      }
  });
});

function comprobarClave() {
  let clave1 = document.getElementById("contraseña").value;
  let clave2 = document.getElementById("confirmar-contraseña").value;

  if (clave1 === clave2) {
      alert("Las dos claves son iguales...\nRealizaríamos las acciones del caso positivo");

      validacionExitosa = true;
  } else {
      alert("Las dos claves son distintas...\nRealizaríamos las acciones del caso negativo");
      validacionExitosa = false;
  }
}

