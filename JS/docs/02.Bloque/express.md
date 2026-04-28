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
app.get("/peliculas", (req, res) => { // codigo; res.json(peliculas); });
```

---

### 🚒 Uso Express

Necesario para poder utilizar todas las funciones relacionadas con las peticiones y url.

Aquí es donde vamos a utilizar nuestro servidor, donde antes lo recogíamos en http ahora es express.

```js
const express = require("express");

const app = express();
app.use(express.json());

// app.get → obtener datos
app.get("/usuarios", (req, res) => {  res.send("GET"); });

// app.post → crear datos
app.post("/usuario", (req, res) => {  res.send("POST"); });

// app.put → actualizar completamente
app.put("/usuario/:id", (req, res) => {  res.send("PUT"); });

// app.patch → actualizar parcialmente
app.patch("/usuario/:id", (req, res) => {  res.send("PATCH"); });

// app.delete → borrar
app.delete("/usuario/:id", (req, res) => {  res.send("DELETE"); });

// app.listen → arrancar servidor
app.listen(3000, () => {console.log("Servidor iniciado");});
```

## Ejercicio

1. Crear un endpoint que devuelva todos los usuarios
2. Crear un endpoint que devuelva todas las películas
3. Crear un endpoint que devuelva un usuario a partir de su id
4. Crear un endpoint que devuelva una película a partir de su id
5. Crear un endpoint que devuelva únicamente los usuarios activos
6. Crear un endpoint que devuelva únicamente los usuarios inactivos
7. Crear un endpoint que permita filtrar películas por género
8. Crear un endpoint que devuelva películas posteriores a un año indicado
9. Crear un endpoint que permita crear un nuevo usuario a partir de un JSON recibido
10. Crear un endpoint que permita crear una nueva película a partir de un JSON recibido
11. Crear un endpoint que permita buscar usuarios por nombre (coincidencia parcial)
12. Crear un endpoint que permita buscar usuarios mayores de una edad indicada
13. Crear un endpoint que permita buscar usuarios por email exacto
14. Crear un endpoint que permita obtener todas las películas de un director concreto
15. Crear un endpoint que permita buscar películas cuya duración sea mayor a un valor dado
16. Crear un endpoint que permita actualizar completamente un usuario a partir de su id
17. Crear un endpoint que permita actualizar parcialmente un usuario (solo algunos campos)
18. Crear un endpoint que permita actualizar completamente una película a partir de su id
19. Crear un endpoint que permita actualizar parcialmente una película (solo algunos campos)
20. Crear un endpoint que permita eliminar un usuario a partir de su id.

```js
let usuarios = [
  { id: 1, nombre: "Ana", edad: 22, email: "ana@email.com", activo: true },
  { id: 2, nombre: "Luis", edad: 30, email: "luis@email.com", activo: false },
  { id: 3, nombre: "Marta", edad: 27, email: "marta@email.com", activo: true },
  { id: 4, nombre: "Carlos", edad: 35, email: "carlos@email.com", activo: true },
  { id: 5, nombre: "Lucía", edad: 19, email: "lucia@email.com", activo: false },
  { id: 6, nombre: "Jorge", edad: 41, email: "jorge@email.com", activo: true },
  { id: 7, nombre: "Elena", edad: 29, email: "elena@email.com", activo: true },
  { id: 8, nombre: "Pablo", edad: 24, email: "pablo@email.com", activo: false },
  { id: 9, nombre: "Sara", edad: 33, email: "sara@email.com", activo: true },
  { id: 10, nombre: "David", edad: 38, email: "david@email.com", activo: true },
  { id: 11, nombre: "Raúl", edad: 45, email: "raul@email.com", activo: false },
  { id: 12, nombre: "Nuria", edad: 26, email: "nuria@email.com", activo: true },
  { id: 13, nombre: "Iván", edad: 31, email: "ivan@email.com", activo: true },
  { id: 14, nombre: "Laura", edad: 28, email: "laura@email.com", activo: false },
  { id: 15, nombre: "Sergio", edad: 36, email: "sergio@email.com", activo: true },
  { id: 16, nombre: "Carmen", edad: 42, email: "carmen@email.com", activo: true },
  { id: 17, nombre: "Diego", edad: 23, email: "diego@email.com", activo: false },
  { id: 18, nombre: "Patricia", edad: 34, email: "patricia@email.com", activo: true },
  { id: 19, nombre: "Alberto", edad: 39, email: "alberto@email.com", activo: true },
  { id: 20, nombre: "Claudia", edad: 21, email: "claudia@email.com", activo: false }
];

let peliculas = [
  { id: 1, titulo: "Matrix", anio: 1999, director: "Lana Wachowski", genero: "Ciencia ficción", duracion: 136 },
  { id: 2, titulo: "Gladiator", anio: 2000, director: "Ridley Scott", genero: "Acción", duracion: 155 },
  { id: 3, titulo: "Interstellar", anio: 2014, director: "Christopher Nolan", genero: "Ciencia ficción", duracion: 169 },
  { id: 4, titulo: "El Padrino", anio: 1972, director: "Francis Ford Coppola", genero: "Drama", duracion: 175 },
  { id: 5, titulo: "Toy Story", anio: 1995, director: "John Lasseter", genero: "Animación", duracion: 81 },
  { id: 6, titulo: "Titanic", anio: 1997, director: "James Cameron", genero: "Romance", duracion: 195 },
  { id: 7, titulo: "Avatar", anio: 2009, director: "James Cameron", genero: "Ciencia ficción", duracion: 162 },
  { id: 8, titulo: "Inception", anio: 2010, director: "Christopher Nolan", genero: "Ciencia ficción", duracion: 148 },
  { id: 9, titulo: "Joker", anio: 2019, director: "Todd Phillips", genero: "Drama", duracion: 122 },
  { id: 10, titulo: "The Dark Knight", anio: 2008, director: "Christopher Nolan", genero: "Acción", duracion: 152 },
  { id: 11, titulo: "Forrest Gump", anio: 1994, director: "Robert Zemeckis", genero: "Drama", duracion: 142 },
  { id: 12, titulo: "Pulp Fiction", anio: 1994, director: "Quentin Tarantino", genero: "Crimen", duracion: 154 },
  { id: 13, titulo: "Fight Club", anio: 1999, director: "David Fincher", genero: "Drama", duracion: 139 },
  { id: 14, titulo: "The Shawshank Redemption", anio: 1994, director: "Frank Darabont", genero: "Drama", duracion: 142 },
  { id: 15, titulo: "Avengers: Endgame", anio: 2019, director: "Russo Brothers", genero: "Acción", duracion: 181 },
  { id: 16, titulo: "Spider-Man", anio: 2002, director: "Sam Raimi", genero: "Acción", duracion: 121 },
  { id: 17, titulo: "Frozen", anio: 2013, director: "Chris Buck", genero: "Animación", duracion: 102 },
  { id: 18, titulo: "Coco", anio: 2017, director: "Lee Unkrich", genero: "Animación", duracion: 105 },
  { id: 19, titulo: "The Lion King", anio: 1994, director: "Roger Allers", genero: "Animación", duracion: 88 },
  { id: 20, titulo: "Mad Max: Fury Road", anio: 2015, director: "George Miller", genero: "Acción", duracion: 120 }
];
```



