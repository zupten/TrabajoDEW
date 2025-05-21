**Registro de accesos**

Este proyecto registra automáticamente todos los accesos a páginas protegidas mediante un filtro Java.

El archivo de log se genera en la siguiente ruta del sistema: **/tmp/logs/accesos.log**

Ejecuta estos comandos en tu terminal:

mkdir -p /tmp/logs

touch /tmp/logs/accesos.log

chmod 666 /tmp/logs/accesos.log


Esto crea la carpeta y el archivo necesarios para que el filtro funcione sin errores.

Cada línea del fichero `accesos.log` contiene:  FECHA_HORA USUARIO IP URL MÉTODO

Ejemplo: 2025-05-22T00:49:01.321 12345678W 127.0.0.1 /Trabajo/identificacion GET
