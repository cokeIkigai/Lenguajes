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

```js
req.url                                            // "/usuarios?id=1" → URL completa solicitada
req.method                                         // "GET", "POST", etc. → método HTTP
req.headers                                        // { host, user-agent, ... } → todas las cabeceras
req.headers["content-type"]                        // "application/json" → tipo de contenido
req.headers["authorization"]                       // "Bearer ..." → token de acceso
req.headers["user-agent"]                          // "Mozilla..." → info del cliente
const url = new URL(req.url, "http://localhost");
url.pathname                                       // "/usuarios" → ruta sin parámetros
url.search                                         // "?id=1" → query completa
url.searchParams.get("id")                         // "1" → valor de parámetro
req.httpVersion                                    // "1.1" → versión del protocolo
req.on("data", chunk => { /* datos en trozos */ }) // recibir body (POST/PUT)
req.on("end", () => { /* fin de datos */ })        // termina recepción
req.socket                                         // info de conexión (IP, puerto)
req.socket.remoteAddress                           // IP del cliente
req.complete                                       // true/false → si la petición terminó correctamente
```
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

---

## Crear Servidor JS

```js
const http = require("http");

const server = http.createServer((req, res) => {
    console.log(req.url);
    res.end("Servidor funcionando");
});

server.listen(3000, () => {
    console.log("Servidor en http://localhost:3000");
});
```

**Extendido**

```js
const http = require("http");

const server = http.createServer((req, res) => {

    // 🔹 Ruta raíz
    if (req.url === "/" && req.method === "GET") {
        res.statusCode = 200;
        res.setHeader("Content-Type", "text/plain; charset=utf-8");
        res.end("Servidor funcionando");
        return;
    }

    // 🔹 Lista de usuarios (JSON)
    if (req.url === "/usuarios" && req.method === "GET") {
        const usuarios = [
            { id: 1, nombre: "Ana" },
            { id: 2, nombre: "Luis" }
        ];

        res.statusCode = 200;
        res.setHeader("Content-Type", "application/json");
        res.end(JSON.stringify(usuarios));
        return;
    }

    // 🔹 Usuario por id (query param)
    if (req.url.startsWith("/usuario") && req.method === "GET") {
        const url = new URL(req.url, "http://localhost");
        const id = url.searchParams.get("id");

        res.statusCode = 200;
        res.setHeader("Content-Type", "application/json");
        res.end(JSON.stringify({ mensaje: `Usuario solicitado con id ${id}` }));
        return;
    }

    // 🔹 Crear usuario (POST)
    if (req.url === "/usuarios" && req.method === "POST") {
        let body = "";

        req.on("data", chunk => {
            body += chunk;
        });

        req.on("end", () => {
            const nuevoUsuario = JSON.parse(body);

            res.statusCode = 201;
            res.setHeader("Content-Type", "application/json");
            res.end(JSON.stringify({
                mensaje: "Usuario creado",
                usuario: nuevoUsuario
            }));
        });

        return;
    }

    // 🔹 Ruta no encontrada
    res.statusCode = 404;
    res.setHeader("Content-Type", "text/plain");
    res.end("Ruta no encontrada");
});

server.listen(3000, () => {
    console.log("Servidor en http://localhost:3000");
});
```




