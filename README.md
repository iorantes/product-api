# product-api
Servicio de administracion de productos y usuarios.

El servicio puede probarse en la siguiente dirección
https://textelaniin.azurewebsites.net/

Carpeta que contiene la coleccion de postman
https://drive.google.com/open?id=1RnFp8bgIpBmZYYIUYvc9s4pr5IsmzlLy

El  script de creacion de objetos e insercion de registros se encuentran en la raiz del repositorio.

## Publicacion Local
### Requisitos de Software
- JDK 1.8
- Maven

### Base de datos
Actualmente la aplicacion se encuentra apuntando a una base de datos MS SQL Server alojada en azure, esta configuracion se puede cambiar en el archivo application.properties.

### Pasos para ejecutar la aplicacion
1. Abrir consola de comandos.
2. Ubicarse en la carpeta raiz del proyecto.
3. Ejecutar el comando "mvn clean package"
4. Entrar en la carpeta generada target/
5. Ejecutar el comando "java -jar products-0.0.1-SNAPSHOT.jar"


## Proceso de autenticacion

Para el proceso de autenticacion, en postman se debe elegir en la pestaña de authorization el tipo "Oauth 2.0" y rellenar los datos como en la imagen:

![image](https://user-images.githubusercontent.com/5969482/79080564-41acaa80-7cd3-11ea-99a8-5feec51be863.png)
