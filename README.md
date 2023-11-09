Api Rest Midas-Market donde se puede

-Registrar un usuario,
-Autenticar un usuario.
-Listar productos y Usuarios,
-registrar productos,
-dar de baja productos o pasarlos a estado inactivo (delete logico),
-volver a activar algun producto,
-actualizar productos.

- Se trabajo con Spring Boot
- Se implemento sobre una base de datos en memoria (H2).
- Se implementoe autenticación y autorización de forma que solo los usuarios autenticados puedan acceder a la API.
- Se implemento Documentación de la API utilizando Swagger.
- Se incluyeron pruebas unitarias del código.
- Se Manejaron  errores (Exceptions)


El trabajo se realizo bajo las sig directivas:

Según el tipo de usuario, se va a permitir realizar distintas acciones.
sólo consideraremos dos tipos de usuarios: los clientes y los administradores

Los administradores pueden:
- Iniciar sesión
- Realizar abmc de productos
- Ver la lista de todos los usuarios registrados en el sistema.

Los clientes pueden:
- Registrarse
- Iniciar sesión
- Listar todos los productos

El producto debe tener al menos los siguientes atributos:
- id
- name
- price
- count

 


