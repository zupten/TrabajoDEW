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
						document.getElementById("boton-media").addEventListener("click", function () {
                           const notasElements = document.querySelectorAll(".nota");
                           const notas = Array.from(notasElements).map(element => parseFloat(element.textContent));
                           let suma = 0;
                           let count = 0;
                           notas.forEach(function (nota) {
					   		   count++;
                               if (!isNaN(nota)) {
                                   suma += nota;
                               }
                           });
                           const media = count > 0 ? suma / count : 0;
							this.textContent = media.toFixed(2);
						    const mensaje = document.createElement("p");
						    mensaje.textContent = "La media de las notas es: " + media.toFixed(2);
						    this.parentNode.replaceChild(mensaje, this);
						})
                    } else {
                        salida.innerHTML = `<p class="text-danger">Error al cargar los alumnos. Código ${xhr.status}</p>`;
                    }
                }
            };

            xhr.send();
        });
    });
});


