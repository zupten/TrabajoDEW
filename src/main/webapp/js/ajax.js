document.addEventListener("DOMContentLoaded", function () {
    const botones = document.querySelectorAll(".boton-async");
    const salida = document.getElementById("salida");

    botones.forEach(boton => {
        boton.addEventListener("click", function () {
            const acronimo = this.textContent.trim();

            const xhr = new XMLHttpRequest();
            xhr.open('GET', `/Trabajo/profesor/ajax?action=AlumnosDeAsignatura&acronimo=${encodeURIComponent(acronimo)}`);

            xhr.onreadystatechange = function () {
                if (xhr.readyState === 4) {
                    if (xhr.status === 200) {
                        // ✅ La respuesta ya es HTML, así que se inyecta directamente
                        salida.innerHTML = xhr.responseText;
                    } else {
                        salida.innerHTML = `<p class="text-danger">Error al cargar los alumnos. Código ${xhr.status}</p>`;
                    }
                }
            };

            xhr.send();
        });
    });
});


