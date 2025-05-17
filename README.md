# Proyecto de Gestión de Productos, Ventas y Clientes con Java, Spring boot, MySQL y Hibernate

## Descripción

Este proyecto consiste en un sistema de gestión de productos, ventas y clientes, implementado con **Spring boot**, **Maven** y **Hibernate**. Además, se implementó un patrón MVC para separar la lógica de negocio y el control de flujo, facilitando el mantenimiento, la escalabilidad y la reutilización del código.

El mismo fue desarrollado en el marco del curso Desarrollo de APIs con Spring Boot de TodoCode.

## DockerHub

`https://hub.docker.com/r/pablojanb/bazar`

## Funcionalidades

- **Crud de clientes:** Crear, obtener, actualizar y eliminar clientes en el sistema.
- **Endpoints:**
  - Crear cliente: `POST /clientes/crear`
  - Obtener clientes: `GET /clientes`
  - Obtener un cliente: `GET /clientes/{id_cliente}`
  - Editar cliente: `PUT /clientes/editar/{id_cliente}`
  - Eliminar cliente: `DELETE /clientes/eliminar/{id_cliente}`

- **Crud de productos:** Crear, obtener, actualizar y eliminar productos en el sistema.
- **Endpoints:**
  - Crear producto: `POST /productos/crear`
  - Obtener productos: `GET /productos`
  - Obtener un producto: `GET /productos/{codigo_producto}`
  - Editar producto: `PUT /productos/editar/{codigo_producto}`
  - Eliminar producto: `DELETE /productos/eliminar/{codigo_producto}`
- **Extra:**
  - Obtener productos con bajo stock: `GET /productos/falta_stock`

- **Crud de ventas:** Crear, obtener, actualizar y eliminar ventas en el sistema.
- **Endpoints:**
  - Crear venta: `POST /ventas/crear`
  - Obtener ventas: `GET /ventas`
  - Obtener una venta: `GET /ventas/{codigo_venta}`
  - Editar venta: `PUT /ventas/editar/{codigo_venta}`
  - Eliminar venta: `DELETE /ventas/eliminar/{codigo_venta}`
- **Extras:**
  - Obtener la lista de productos de una venta específica: `GET /ventas/productos/{codigo_venta}`
  - Obtener el monto total y cantidad de ventas de un día específico: `GET /ventas/dia/{fecha_venta}`
  - Obtener datos de la venta de mayor monto: `GET /ventas/mayor_venta`

## Tecnologías

[![My Skills](https://skillicons.dev/icons?i=spring,java,hibernate,docker,maven,idea,postman)](https://skillicons.de)

- **Spring boot:** Como framework para la creación de APIs RESTful.
- **Maven:** Como gestor de dependencias.
- **MySQL:** Para la persistencia de datos.
- **Hibernate:** Para interactuar con la DB desde el servidor.
- **Postman:** Prueba de solicitudes por protocolo HTTP.
- **Docker:** Crear imagen y contenedores.