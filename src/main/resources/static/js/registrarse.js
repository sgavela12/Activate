document.addEventListener('DOMContentLoaded', function () {
    var loginTab = document.getElementById('loginTab');
    var signupTab = document.getElementById('signupTab');
    var cardWrapper = document.querySelector('.card-3d-wrapper');

    loginTab.addEventListener('click', function () {
      cardWrapper.style.transform = 'rotateY(0deg)';
    });

    signupTab.addEventListener('click', function () {
      cardWrapper.style.transform = 'rotateY(180deg)';
    });
  });