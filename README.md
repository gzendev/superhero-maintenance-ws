# Superhero Maintenance API

Software de mantenimiento de Súper Héroes desarrollado como challenge para W2M.

## Módulos 

1. Rest API <superhero-maintenance-ws>
  
## Stack Tecnológico

1. Java - 1.11.x +

2. Maven - 3.x.x +
  
3. H2 Database
  
4. Flyway Migrations
  
5. Swagger
  
6. Spring Boot - 2.5.4
  
7. Security Rest API
  
## Pasos para Configurar
  
**1. Clonar la Aplicación

```bash
git clone https://github.com/gzendev/superhero-maintenance-ws.git
```
  
**2. Construir y correr la app usando Maven 

```bash
mvn package
java -jar superhero-maintenance-ws/target/superhero-maintenance-ws.jar

```
Alternativamente, también podés correr la app usando,

```bash
mvn spring-boot:run
```

La app comenzará a correr en <http://localhost:8080>


## Explorar Rest APIs

La app define los siguientes EndPoints. Ver en <http://localhost:8080/swagger-ui/>

