# Práctica en grupo — API de películas con registro y login

## Objetivo

- **Backend obligatorio**
- Gestión de usuarios
- Registro y login
- Validaciones en backend
- Endpoints para películas y usuarios
- Uso de **Git** en grupo
- Los datos se almacenarán en memoria no se usará MySQL todavía.  
- **Frontend (mínimo)**

---

# Contexto de la práctica

- Vais a crear una pequeña plataforma de películas donde los usuarios se le quedarán guardados qué películas han visto. Dependiendo de la cantidad de peliculas que haya en el back les aparecerán.
- Sólo el admin podrá ver, añadir y borrar las péliculas.
- Los usuarios podran quitarla de favoritos para que no les aparezcan en su lista.

La aplicación debe permitir:

- registrar usuarios
- iniciar sesión
- consultar películas
- consultar información de usuarios
- añadir, modificar o eliminar películas según lo que implementéis

---

# Datos iniciales

## Películas
Se os dará un archivo JSON con **10 películas iniciales**.

Ese archivo será vuestra base inicial de datos para películas.

## Usuarios
Debéis crear vosotros la estructura de usuarios.

---

# Información mínima de cada usuario

Cada usuario debe tener **como mínimo** estos campos:

```json
{
  "id": 1,
  "nombre": "Coke",
  "email": "coke@email.com",
  "password": "1234", // min 5 letras, 1 numero , 1 mayuscula, 1 minuscula. Cifrada
  "rol": "user",
  "peliculasVistas": [1, 3, 5],
  "favoritas": [2, 4]
}
```
Películas:

```js
const peliculas = [
  {
    id: 1,
    titulo: "Inception",
    director: "Christopher Nolan",
    anio: 2010,
    genero: "Ciencia ficción"
    url: "https://m.media-amazon.com/images/M/MV5BYzdjMDAxZGItMjI2My00ODA1LTlkNzItOWFjMDU5ZDJlYWY3XkEyXkFqcGc@._V1_.jpg"
  }
];
```
