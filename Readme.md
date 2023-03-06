- [Introducción](#introducción)
- [Prerequisito](#prerequisito)
  - [Docker](#docker)
  - [Java](#java)

# Introducción

El repositorio contiene 2 proyectos, el del servidor y el del cliente. Por medio del servidor se invoca el cliente y se envia la traza a zipkin que es el colector de las peticiones.

# Prerequisito

Zipkin 

Página oficial  https://zipkin.io/

## Docker

```
    docker run -d -p 9411:9411 openzipkin/zipkin
```

## Java 

1. Descargar el archivo jar de la pagina oficial 

https://search.maven.org/remote_content?g=io.zipkin&a=zipkin-server&v=LATEST&c=exec

2. Ejecutar el siguiente comando

```
    java -jar zipkin.jar
```
