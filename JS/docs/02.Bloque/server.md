# 🌐 ¿Qué es un servidor?

Un servidor es un programa (o máquina) que está escuchando continuamente y preparado para responder cuando alguien le pide algo. Un servidor no hace nada hasta que alguien le pide algo

- Está activo en un puerto (ej: 3000)
- Espera solicitudes de clientes (navegador, app, etc.)
- Devuelve una respuesta


## 🔁 Tipos de peticiones HTTP (métodos)

Son las distintas formas en las que un cliente puede comunicarse con el servidor según lo que quiere hacer:

📥 **GET** → Obtener datos | Solo pide información | No modifica nada : ```/usuarios``` -> ver datos de usuario

📤 **POST** → Enviar datos | Envía información al servidor | Suele crear algo nuevo :  ```/usuarios``` -> crear usuario

✏️ **PUT** → Reemplazar datos | Actualiza completamente un recurso : ```PUT /usuarios/1``` -> editar todo un objeto

🩹 **PATCH** → Actualizar parcialmente | Modifica solo una parte : ```/usuarios/1``` -> cambiar solo un campo

❌ **DELETE** → Eliminar | Borra un recurso : ```/usuarios/1``` -> eliminar datos

En el código lo vais a ver referenciado con `req`.

---

## 📤 ¿Qué es una respuesta?

Una respuesta (response) es lo que el servidor devuelve al cliente después de recibir una petición. Es la “contestación” del servidor a lo que ha pedido el cliente

Incluye 3 cosas principales:

- Código de estado → indica qué ha pasado (200, 404…)
- Cabeceras (headers) → información sobre la respuesta
- Cuerpo (body) → los datos (texto, JSON, HTML…)

**TIPOS DE RESPUESTA**

```js
res.statusCode = 200;                                  // Código de estado (OK)
res.statusMessage = "OK";                              // Mensaje del estado (opcional)
res.setHeader("Content-Type", "application/json");     // Define tipo de contenido
res.getHeader("Content-Type");                         // Obtiene una cabecera concreta
res.getHeaders();                                      // Devuelve todas las cabeceras
res.hasHeader("Content-Type");                         // Comprueba si existe una cabecera
res.removeHeader("Content-Type");                      // Elimina una cabecera
res.write("Hola ");                                    // Envía parte del cuerpo (puede haber varias)
res.write("mundo");                                    // Añade más contenido
res.end("Fin de respuesta");                           // Envía el contenido final y cierra la respuesta
res.writeHead(200, { "Content-Type": "text/plain" });  // Estado + cabeceras en una sola línea
res.on("finish", () => {});                            // Se ejecuta cuando la respuesta termina correctamente
res.on("close", () => {});                             // Se ejecuta si la conexión se cierra antes de terminar
---------------------------------------------------------------------------------------------------------------
res.statusMessage = "OK";                              // Mensaje del estado
res.getHeader("Content-Type");                         // Obtener header
res.getHeaders();                                      // Obtener todos los headers
res.hasHeader("Content-Type");                         // Comprobar si existe
res.removeHeader("Content-Type");                      // Eliminar header
res.writeHead(200, { "Content-Type": "text/plain" });  // Estado + headers juntos
---------------------------------------------------------------------------------------------------------------
res.flushHeaders();                                    // Fuerza el envío de cabeceras
res.setTimeout(5000, () => {});                        // Tiempo máximo de respuesta
res.cork();                                            // Agrupa escrituras (optimización)
res.uncork();                                          // Envía lo acumulado
res.destroy();                                         // Cierra la conexión abruptamente
```

**USO COTIDIANO**

```js
res.statusCode = 200;                              // Código de estado
res.setHeader("Content-Type", "application/json"); // Tipo de contenido
res.write("datos");                                // Enviar parte del body
res.end("fin");                                    // Terminar respuesta
```




