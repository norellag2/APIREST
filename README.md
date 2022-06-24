# Desarrollo de API Rest con Spring Boot e  HUBERNATE

Spring Boot:
Framework para el desarrollo de servidores con el lenguaje Java, es una evolución de Spring con servidor incorporado (Tomcat)

Spring usa Maven como gestor de dependencias (encarga de descargar las librerías o paquetes que use el proyecto)

JPA 
Especificación para implementar persistencia en los servidores desarrollados con Spring-Java(conjunto de interfaces), establece como se mapean los objetos del servidor con las tablas de las bases de datos.

Hibernate
Herramienta ORM (mapeo objeto-relacional), define como se llevarán a cabo las operaciones de mapeo entre los objetos del servidor y las tablas de la base de datos.

## Setup del proyecto en Visual Studio Code
1.- Crear proyecto Java
2.- Seleccionar Spring BOOT
3.- Seleccionar Maven Project
4.- Seleccionar version de Java
5.- Completar el input group id "com.acme"
6.- Completar el artefacto "apirest"
7.- Añadir las dependecias del proyecto
     - Spring Web
     - Spring Data JPA
     - MySQL Driver
     - Spring Boot DevTools
8.- Seleccionamos la carpeta donde se creará el proyecto 
9.- Esperar con paciencia y tras un tiempo tendremos nuestro proyecto en un directorio con el mismo nombre "apirest"

## Establecer los valores de conexion de la API al servidor de la base de datos
Este paso se realiza introduciendo los datos en el archivo properties

resources/application.properties

## Crear la entidad
La entidad lo que permite es definir en una clase los atributos que correspondan con los campos de la base de datos.

Creamos un paquete models.entity y una clase Articulo.java

## Crear el repository
El siguiente paso es crear el repository conocido como DAO o Dao.
DAO = Objeto de acceso a datos.
Utilizar un conjunto de funciones que están en la librería repository para aplicar a nuestra clase "". Lo que proporcionan esas funciones es realizar las operaciones CRUD en la base de datos.

Un paquete dao en el paquete models y dentro de ese paquete una interfaz para el Dao de la clase correspondiente.

## Crear el servicio 
En el servicio (que va a tener una interfaz y una clase) crearemos los métodos para trabajar con los diferentes atributos de la entidad.

Nos creamos un paquete services en el paquete models y vamos a añadir una interfaz y una clase.

## Crear el controlador 
El controlador va a tener la lógica relacionada con las peticiones a la API para usar los métodos de operaciones con la base de datos
Crear un nuevo paquete controllers en el paquete origen apirest y dentro del paquete una clase con el controlador para la entidad articulo.

``````````````````````````````````````````````````````````````````````
1.-Entidad --> objeto
2.- DAO --> "Decir" que métodos 
3..- Servicio--> declaramos los métodos de la funcionalidad que queramos hacer
4.-Controlador--> asocia rutas de la API con los métodos anteriores`
´´´´´´´´´´´´´´´´´´´´´´´´´´´´´´´´´´´´´´´´´´´´´´´´´´´´´´´´´´´´´´´´´´´´´´´´
