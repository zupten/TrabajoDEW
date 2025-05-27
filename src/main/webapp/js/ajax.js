document.addEventListener("DOMContentLoaded", function () {
    const botones = document.querySelectorAll(".boton-async");

    botones.forEach(boton => {
        boton.addEventListener("click", function () {
            const acronimo = this.textContent.trim();

            const xhr = new XMLHttpRequest();
            xhr.open('GET', `http://localhost:8080/Trabajo/profesor/ajax?action=AlumnosDeAsignatura&acronimo=${encodeURIComponent(acronimo)}`);

            xhr.onreadystatechange = function () {
                if (xhr.readyState === 4 && xhr.status === 200) {
                    try {
                        const respuesta = JSON.parse(xhr.responseText);
                        muestrarespuesta(respuesta);
                    } catch (e) {
                        console.error("Error al parsear JSON:", e);
                    }
                }
            };

            xhr.send();
        });
    });
});

function muestrarespuesta(data) {
    console.log("Respuesta AJAX:", data);
    alert("Recibidos " + data.length + " alumnos");
}
