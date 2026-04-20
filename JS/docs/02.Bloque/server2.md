# 📕 Proyecto API Películas (Express)

Para poder ejecutar y arrancar este proyecto se deben seguir los suignetes pasos:

**1º.** Crear el proyecto, carpeta

**2º.** git init -y

**3º.** npm i nodemon express

**4º.** Añadir en el archivo package.json en la parte de script.
   ```
   "dev": "nodemon server.js"
   ```
**5. Ejecutar el servidor con:**
   ```
    npm run dev
   ```
---

**server.js**

```js
const express = require("express");
const peliculasRoutes = require("./routes/peliculasRoutes");

const app = express();
const PORT = 3000;

app.use(express.json());

// Ruta de prueba
app.get("/", (req, res) => {
  res.send("API de películas funcionando");
});

// Rutas de la API
app.use("/api", peliculasRoutes);

// 404
app.use((req, res) => {
  res.status(404).json({ mensaje: "Ruta no encontrada" });
});

app.listen(PORT, () => {
  console.log(`Servidor en http://localhost:${PORT}`);
});

```

---

**routes/peliculasRoutes.js**

```js
const express = require("express");
const router = express.Router();

const peliculasController = require("../controllers/peliculasController");

// Obtener todas
router.get("/peliculas", peliculasController.getPeliculas);

// Obtener por ID
router.get("/peliculas/:id", peliculasController.getPeliculaById);

// Crear nueva
router.post("/peliculas", peliculasController.createPelicula);

module.exports = router;
```

---

**controllers/peliculasController.js**

```js
const peliculas = require("../data/peliculas");

const peliculasController = {

  // GET /peliculas
  getPeliculas: (req, res) => {
    const { director, anio } = req.query;

    let resultado = peliculas;

    // filtro por director
    if (director) {
      resultado = resultado.filter(p =>
        p.director.toLowerCase().includes(director.toLowerCase())
      );
    }

    // filtro por año
    if (anio) {
      resultado = resultado.filter(p =>
        p.anio === parseInt(anio)
      );
    }

    res.status(200).json(resultado);
  },

  // GET /peliculas/:id
  getPeliculaById: (req, res) => {
    const id = parseInt(req.params.id);
    const pelicula = peliculas.find(p => p.id === id);

    if (!pelicula) {
      return res.status(404).json({ mensaje: "Película no encontrada" });
    }

    res.status(200).json(pelicula);
  },

  // POST /peliculas
  createPelicula: (req, res) => {
    const { titulo, director, anio } = req.body;

    if (!titulo || !director || !anio) {
      return res.status(400).json({
        mensaje: "Faltan datos: titulo, director y anio son obligatorios"
      });
    }

    const nuevaPelicula = {
      id: peliculas.length + 1,
      titulo,
      director,
      anio
    };

    peliculas.push(nuevaPelicula);

    res.status(201).json({
      mensaje: "Película creada correctamente",
      pelicula: nuevaPelicula
    });
  }

};

module.exports = peliculasController;
```

---

**data/peliculas.js**

```js
const peliculas = [
  { id: 1, titulo: "Matrix", director: "Wachowski", anio: 1999 },
  { id: 2, titulo: "Interstellar", director: "Christopher Nolan", anio: 2014 },
  { id: 3, titulo: "Inception", director: "Christopher Nolan", anio: 2010 },
  { id: 4, titulo: "The Dark Knight", director: "Christopher Nolan", anio: 2008 },
  { id: 5, titulo: "Pulp Fiction", director: "Quentin Tarantino", anio: 1994 },
  { id: 6, titulo: "Fight Club", director: "David Fincher", anio: 1999 },
  { id: 7, titulo: "Forrest Gump", director: "Robert Zemeckis", anio: 1994 },
  { id: 8, titulo: "Gladiator", director: "Ridley Scott", anio: 2000 },
  { id: 9, titulo: "Titanic", director: "James Cameron", anio: 1997 },
  { id: 10, titulo: "Avatar", director: "James Cameron", anio: 2009 },
  { id: 11, titulo: "The Godfather", director: "Francis Ford Coppola", anio: 1972 },
  { id: 12, titulo: "The Godfather Part II", director: "Francis Ford Coppola", anio: 1974 },
  { id: 13, titulo: "The Shawshank Redemption", director: "Frank Darabont", anio: 1994 },
  { id: 14, titulo: "The Lord of the Rings: The Fellowship of the Ring", director: "Peter Jackson", anio: 2001 },
  { id: 15, titulo: "The Lord of the Rings: The Two Towers", director: "Peter Jackson", anio: 2002 },
  { id: 16, titulo: "The Lord of the Rings: The Return of the King", director: "Peter Jackson", anio: 2003 },
  { id: 17, titulo: "Star Wars: A New Hope", director: "George Lucas", anio: 1977 },
  { id: 18, titulo: "The Empire Strikes Back", director: "Irvin Kershner", anio: 1980 },
  { id: 19, titulo: "Jurassic Park", director: "Steven Spielberg", anio: 1993 },
  { id: 20, titulo: "The Social Network", director: "David Fincher", anio: 2010 }
];

module.exports = peliculas;
```
