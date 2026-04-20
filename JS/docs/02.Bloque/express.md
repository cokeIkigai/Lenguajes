# 🚀  EXPRESS

Express es un **framework** para `Node.js` que simplifica la creación de servidores y APIs.

En lugar de manejar manualmente las URLs y métodos con if y código repetitivo, Express permite definir rutas de forma directa, como “cuando llegue una petición aquí, ejecuta esta función”.

Además, facilita trabajar con peticiones y respuestas (JSON, parámetros, body) y ayuda a organizar el código en partes más claras como rutas y controladores.

En resumen: Express elimina complejidad y permite centrarse en la lógica en lugar de en los detalles técnicos.

---


**📘 SIN Express:**

```js
if (req.url === "/peliculas" && req.method === "GET") {...}
```

**📖 CON Express:**

```js
app.get("/peliculas", (req, res) => { res.json(peliculas); });
```

---

### 🚒 Uso Express

Necesario para poder utilizar todas las funciones relacionadas con las peticiones y url.

Aquí es donde vamos a utilizar nuestro servidor, donde antes lo recogíamos en http ahora es express.

```js
const express = require("express");

const app = express();

// app.get → obtener datos
app.get("/usuarios", (req, res) => { res.send("GET"); });

// app.post → crear datos
app.post("/usuario", (req, res) => { res.send("POST"); });

// app.put → actualizar completamente
app.put("/usuario/:id", (req, res) => { res.send("PUT"); });

// app.patch → actualizar parcialmente
app.patch("/usuario/:id", (req, res) => { res.send("PATCH"); });

// app.delete → borrar
app.delete("/usuario/:id", (req, res) => { res.send("DELETE"); });

// app.use → middleware (se ejecuta antes de las rutas)
app.use((req, res, next) => { next();});

// app.all → cualquier método HTTP
app.all("/endpoint", (req, res) => { res.send("ALL");});

// app.listen → arrancar servidor
app.listen(3000, () => {console.log("Servidor iniciado");});
```

