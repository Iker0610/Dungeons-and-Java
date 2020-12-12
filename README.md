# Authors

- Iria San Miguel Losantos.
- Iker de la Iglesia Martínez.
- Alexander Platas Montero.

# Description

Para este proyecto hemos creado un sistema web llamado "Relojería Platas".

En este sistema se almacenan tanto los usuarios registrados como las reparaciones realizadas por la relojería.

Respecto a la estructura, cuenta con una página de 'Log In' donde las personas que dispongan de una cuenta podrán identificarse y otra de 'Sign Up' donde cualquiera podrá crearse una nueva cuenta.

Por otro lado, existe una página principal donde aparecerá un listado con todas las reparaciones almacenadas en la base de datos. Cualquier persona puede entrar en esta página y consultar los datos de cada una de estas reparaciones. Además, también se podrán añadir nuevas, modificarlas y eliminarlas.

Respecto a los usuarios que se hayan identificado anteriormente, podrán modificar sus propios datos y únicamente sus datos.

# Instructions

#### Ejecutar el fichero script.sh
```bash
$ sh script.sh
```
##### Funcionalidad del script.sh:
  
  - Instala docker en caso de que no esté instalado (versión 19.03.12).
  - Instala docker-compose en caso de que no esté instalado.
  - Crea las imágenes necesarias.
  - Crea los containers necesarios.
  - Importa la base de datos.
  - Abre el sistema web a través de Firefox (puerto 8080).

# Contenido del zip

  - Fichero README
  - Los ficheros *Dockerfile* y *docker-compose.yml* necesarios.
  - Directorio app:
     - Directorio CSS:
        Contiene el fichero *style.css* que se encarga de mejorar el aspecto del sistema web.
     - Directorio model:
        Contiene los ficheros PHP que realizan las operaciones necesarias con la base de datos.
     - Directorio view:
        Contiene los ficheros PHP con el código HTML y PHP que crea la estructura del sistema web.
        En los directorios 'cuenta' y 'reparaciones' se encuentran los ficheros relacionados con estos datos.
     - *index.php*
  - El script que permite crear la imágenes, contenedores e importa los datos.
