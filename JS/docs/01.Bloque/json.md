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

## 🔄Configurar datos de un JSON

JSON es el formato en el que viajan los datos, pero en JavaScript siempre trabajamos con objetos.

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
* **Trabajar con ello** (Deserializar)
```js
const texto = '{ "nombre": "Guille", "edad": 32, "activo": true }';
const usuario = JSON.parse(texto);
console.log(usuario);
```
* **Enviarlo** (Serializar)
```js
const objeto = { "nombre": "Zoe", "edad": 6, "activo": true };
const usuario = JSON.stringify(objeto);
console.log(usuario);
```

---

## 📦 Trabajando con JSON

Vamos a trabajar con JSON, pero es importante entender que **puede venir de diferentes formas**:

* Fichero externo.
* Servidor (backend).
* Creado en el código como objeto
* Creado en el código como texto (JSON real).

---
### 🟢 Código (objeto)

Ya es un objeto JavaScript listo para usar. Es el que usaremos para practicar al inicio.

```js
const usuario = {
  nombre: "Coke",
  edad: 40,
  activo: true
};
```
--- 

### 🟢 Código (JSON)

Aquí sí es JSON real (texto)
```js
const texto = '{ "nombre": "Coke", "edad": 40 }';
const usuario = JSON.parse(texto);
```
---
### 🟢 Fichero externo.

> Esto lo usamos para practicar, no es lo más habitual en aplicaciones reales.

```js
const json = await fetch('./data.json')
  .then(res => res.json());
console.log(json);
```

---

### 🟢 Servidor (backend).
Es lo que se usa en aplicaciones reales (frontend ↔ backend)
```js
const json = await fetch('https://api.ejemplo.com/usuarios')
  .then(res => res.json());
```
--- 
## ⚒️ TRABAJAR CON UN JSON EN JAVASCRIPT

Vamos a ver cómo **leer**, **extraer**, **modificar** y **añadir** datos de un JSON después de convertirlo en un objeto de JavaScript.

### 🔴 Acceder a las claves:
```js
 ```js
let data = {
  "nombre": "John",
  "edad": 35,
  "activo": true,
  "lenguajes": ["Java", "JavaScript", "SQL"]
};

// Acceso a propiedades
let nombre = data.nombre; 
let edad = data["edad"];
let activo = data["activo"];

let clave = "lenguajes";
let lenguajes = data[clave];

console.log(nombre);      // John
console.log(edad);        // 35
console.log(activo);      // true
console.log(lenguajes);   // ["Java", "JavaScript", "SQL"]
```

---

### 🟡 Modificar valores:

```js
json.nombre = "Luis";
console.log(json);
```
---

### 🔵 Añadir claves:

```js
json.categoria = null;
console.log(json)
```
