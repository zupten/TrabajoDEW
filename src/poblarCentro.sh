#!/bin/bash

echo "Iniciando login de administrador..."

TOKEN=$(curl -s -c sesion_admin_log.txt -X POST "http://localhost:9090/CentroEducativo/login" \
  -H "Content-Type: application/json" \
  -d '{"dni": "111111111", "password": "654321"}' | tr -d '"')

echo "Token obtenido: $TOKEN"
echo

echo "Creando alumnos..."

alumnos=(
  "88322119L,Nuria,Salvador Ramos"
  "77885443H,Tomás,López Barrera"
  "66233147D,Eva,Cano Vidal"
  "99112233P,Raúl,Álvarez Téllez"
)

for alumno in "${alumnos[@]}"; do
  IFS=',' read -r dni nombre apellidos <<< "$alumno"
  response=$(curl -s -o /dev/null -w "%{http_code}" -b sesion_admin_log.txt -X POST "http://localhost:9090/CentroEducativo/alumnos?key=$TOKEN" \
    -H "Content-Type: application/json" \
    -d "{\"dni\":\"$dni\",\"nombre\":\"$nombre\",\"apellidos\":\"$apellidos\",\"password\":\"123456\"}")
  echo "Alumno $dni creado código $response"
done

echo
echo "Creando profesores..."

profesores=(
  "44887766M,Estela,Granados Lopez"
  "32178945Z,Fernando,León Valero"
  "77889966T,Julia,Martí Giménez"
  "11445577R,Óscar,Ibáñez Ortega"
)

for profesor in "${profesores[@]}"; do
  IFS=',' read -r dni nombre apellidos <<< "$profesor"
  response=$(curl -s -o /dev/null -w "%{http_code}" -b sesion_admin_log.txt -X POST "http://localhost:9090/CentroEducativo/profesores?key=$TOKEN" \
    -H "Content-Type: application/json" \
    -d "{\"dni\":\"$dni\",\"nombre\":\"$nombre\",\"apellidos\":\"$apellidos\",\"password\":\"123456\"}")
  echo "Profesor $dni creado con código $response"
done

echo
echo "Creando asignaturas..."

asignaturas=(
  "WEB3,A,Programación Web Avanzada"
  "UX2,B,Experiencia de Usuario"
  "DSC1,A,Despliegue de Servicios"
  "APB1,B,Aplicaciones en Backend"
)

for asignatura in "${asignaturas[@]}"; do
  IFS=',' read -r acronimo cuatrimestre nombre <<< "$asignatura"
  response=$(curl -s -o /dev/null -w "%{http_code}" -b sesion_admin_log.txt -X POST "http://localhost:9090/CentroEducativo/asignaturas?key=$TOKEN" \
    -H "Content-Type: application/json" \
    -d "{\"acronimo\":\"$acronimo\",\"creditos\":4.5,\"cuatrimestre\":\"$cuatrimestre\",\"curso\":3,\"nombre\":\"$nombre\"}")
  echo "Asignatura $acronimo creada con código $response"
done

echo -e "\nMatriculando alumnos en asignaturas..."

matriculas=(
  "88322119L,WEB3" "88322119L,UX2" "88322119L,DSC1"
  "77885443H,WEB3" "77885443H,UX2" "77885443H,DSC1"
  "66233147D,WEB3" "66233147D,UX2" "66233147D,DSC1"
  "99112233P,WEB3" "99112233P,UX2" "99112233P,DSC1"
)

for matricula in "${matriculas[@]}"; do
  IFS=',' read -r dni asignatura <<< "$matricula"
  response=$(curl -s -o /dev/null -w "%{http_code}" -b sesion_admin_log.txt \
    -X POST "http://localhost:9090/CentroEducativo/asignaturas/$asignatura/alumnos?key=$TOKEN" \
    -H "Content-Type: application/json" \
    -d "{\"dni\":\"$dni\"}")
  echo "Alumno $dni matriculado en $asignatura (código $response)"
done

echo
echo "Asignando calificaciones a los alumnos..."

calificaciones=(
  "88322119L,WEB3,6" "88322119L,UX2,7" "88322119L,DSC1,8"
  "77885443H,WEB3,5" "77885443H,UX2,6" "77885443H,DSC1,7"
  "66233147D,WEB3,8" "66233147D,UX2,9" "66233147D,DSC1,6"
  "99112233P,WEB3,7" "99112233P,UX2,7" "99112233P,DSC1,6"
)

for calificacion in "${calificaciones[@]}"; do
  IFS=',' read -r dni asignatura nota <<< "$calificacion"
  response=$(curl -s -o /dev/null -w "%{http_code}" -b sesion_admin_log.txt \
    -X PUT "http://localhost:9090/CentroEducativo/alumnos/$dni/asignaturas/$asignatura" \
    -H "Content-Type: application/json" \
    -d "{\"nota\": \"$nota\"}")
  echo "Nota $nota asignada a $dni en $asignatura código $response"
done

echo
echo "Carga finalizada."
