# 🧩 ¿Qué es JSON?

JSON (*JavaScript Object Notation*) es un formato ligero de intercambio de datos basado en texto. 
Tiene una estructura específica formada por pares **clave-valor** y listas ordenadas, y es independiente del lenguaje, aunque su sintaxis está inspirada en los objetos de JavaScript.

- No es exclusivo de **JavaScript** → se usa en Java, Python, C#, etc.
- Es compatible de forma nativa con JavaScript → porque su sintaxis es muy similar a los objetos JS.
- Se usa principalmente para:
  - **APIs** (frontend ↔ backend)
  - **Configuración**
  - **Almacenamiento de datos** (Bases no relacionales)

 ---

 ## Configurar datos de un JSON

 **data.json:**
 ```js
 {
  "nombre": "John",
  "edad": 35,
  "activo": true,
  "lenguajes": ["Java", "JavaScript", "SQL"]
}
```

---

## 📦 Trabajando con JSON

Vamos a trabajar con JSON, pero es importante entender que **puede venir de diferentes formas**:

* Desde un archivo `.json`.
* Desde una API (lo más común en la realidad).
* Creado en el código como objeto.
* Creado en el código como texto (JSON real).

---

### 🟢 Desde un archivo `.json`
Datos guardados en un fichero externo.

> Esto lo usamos para practicar, no es lo más habitual en aplicaciones reales.

```js
const json = await fetch('./data.json')
  .then(res => res.json());
console.log(json);
```

---

### 🟢 Los datos vienen de un servidor (backend).
Es lo que se usa en aplicaciones reales (frontend ↔ backend)
```js
const json = await fetch('https://api.ejemplo.com/usuarios')
  .then(res => res.json());
```
--- 

### 🟢 Creado en el código como objeto

Ya es un objeto JavaScript listo para usar. Es el que usaremos para practicar al inicio.

```js
const usuario = {
  nombre: "Coke",
  edad: 40,
  activo: true
};
```

--- 

### 🟢 Creado en el código como texto (JSON real)
Aquí sí es JSON real (texto)
```js
const texto = '{ "nombre": "Coke", "edad": 40 }';
const usuario = JSON.parse(texto);
```

// Acceso a cada clave:

let nombre = json.nombre; // "John"
let edad = json.edad;     // 35
let activo = json.activo; // true 
let lenguajes = json.lenguajes; // ["Java", "JavaScript", "SQL"]

// acceso a arays o listas es con bucleso map
console.log(nombre);
console.log(edad);
console.log(activo);
console.log(lenguajes);

// Modificar valores

json.nombre ="Cambio";
console.log(json);

// Añadir claves con valores

json.categoria = null;
console.log(json)

```

 
