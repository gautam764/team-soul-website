console.log("Team SouL website loaded");

document.addEventListener("DOMContentLoaded", function () {

    const links = document.querySelectorAll("nav a");

    links.forEach(function (link) {

        link.addEventListener("click", function () {

            console.log("Opening:", link.textContent);

        });

    });

});