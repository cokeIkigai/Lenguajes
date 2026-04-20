# 🚀  EXPRESS

Express es un **framework** para `Node.js` que simplifica la creación de servidores y APIs.

En lugar de manejar manualmente las URLs y métodos con if y código repetitivo, Express permite definir rutas de forma directa, como “cuando llegue una petición aquí, ejecuta esta función”.

Además, facilita trabajar con peticiones y respuestas (JSON, parámetros, body) y ayuda a organizar el código en partes más claras como rutas y controladores.

En resumen: Express elimina complejidad y permite centrarse en la lógica en lugar de en los detalles técnicos.

---


**📖 SIN EXPRESS:**

```js
if (req.url === "/peliculas" && req.method === "GET") {
 .....
}
```

**📖 CON EXPRESS:**

```js
app.get("/peliculas", (req, res) => {
  res.json(peliculas);
});
```
