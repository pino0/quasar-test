# quasar-test

Nivel 1
Para dar solucion a este punto cree la clase FuegoQuasarNivel1 que se encuentra en el paquete com.fuego.quasar.api.algorithm del proyecto

Nivel 2 
Se creo el API REST que se solicito en el desafio, el cual recibe el payload acordado.
   POST:
   http://15.228.63.233:8080/topsecret 

Nivel 3
Se creo el API REST que se solicito en el desafio
    POST:
    http://15.228.63.233:8080/topsecret_split/{satellite_name} 

    GET:
    http://15.228.63.233:8080/topsecret_split  
    Retorna la ubicacion y el mensaje de la nave, aqui se hizo uso de un Map para almacenar las distintas mediciones realizadas por los 
    satelites a traves del "POST endpoint" para los satelites Kenobi, Skywalker y Sato

Si se quiere probar en la maquina local, descargar los fuentes del proyecto y luego ubicarse en la carpeta api 

luego si se cuenta con Docker instalado en la maquina local ejecutar el comando
  . dockerStart.sh

sino se cuenta con Docker se puede ejecutar la aplicacion java con el comando
  . withoutDockerStart.sh
    
    
