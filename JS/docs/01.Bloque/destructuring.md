# ⚙️ DESTRUCTURING EN JAVASCRIPT

El **destructuring** es una sintaxis de JavaScript que permite **extraer valores de arrays** o **propiedades de objetos** y guardarlos directamente en variables.

---
## 📖 Objeto Json.

Se utiliza sobretodo para no abarcar muchos `obj.nombre` y que sea menor código y más claro.

**Sin destructuring**
```js
const persona = {
  nombre: "Ana",
  edad: 30
};

let nombre = persona.nombre;
let edad = persona.edad;
console.log(nombre);
console.log(edad);
```

**Con destructuring**
```js
const persona = {
  nombre: "Ana",
  edad: 30
};

const { nombre, edad } = persona;
console.log(nombre);
console.log(edad);
```

---
## ✏️ Camabiar nombre (alias)
```js
const persona = {
  nombre: "Ana"
};

const { nombre: nombreUsuario } = persona;

console.log(nombreUsuario); // Ana
```
---

## Destructuring anidado

Para objetos dentro de objetos.
```js
const usuario = {
  nombre: "Ana",
  direccion: {
    ciudad: "Madrid"
  }
};

const { direccion: { ciudad } } = usuario;

console.log(ciudad); // Madrid
```

---

## 🔢 ARRAYS

Sirve para sacar valores por posición.
```js
const colores = ["rojo", "verde", "azul"];
const [a, b, c] = colores;

console.log(a); // rojo
```

Saltar posiciones 
```js
// Con un hueco
const colores = ["amarillo", "morado", "negro"];

const [primero, , tercero] = colores;

console.log(primero); // amarillo
```
Valores por defecto
```js
// Añadir nuevos elementos al array 
const numeros = [10];

const [a, b = 20] = numeros;

console.log(a); // 10
console.log(b); // 20
```
---

## 🗄️ OPERADOR REST ...

Sirve para recoger el resto de valores.

**En arrays**

```js
const numeros = [1, 2, 3, 4, 5];

const [primero, segundo, ...resto] = numeros;

console.log(primero); // 1
console.log(resto);   // [3, 4, 5]
```

**En objetos**

```js
const persona = {
  nombre: "Ana",
  edad: 30,
  ciudad: "Madrid"
};

const { nombre, ...resto } = persona;

console.log(nombre); // Ana
console.log(resto);  // { edad: 30, ciudad: "Madrid" }
```
---

Intercambiar variables

```js
let a = 1;
let b = 2;

[a, b] = [b, a];
```
---

## DESTRUCTURING EN FUNCIONES

Muy útil cuando una función recibe un objeto.
```js
const persona = {
  nombre: "Ana",
  edad: 30
};

function mostrar({ nombre, edad }) {
  console.log(nombre);
  console.log(edad);
}

mostrar(persona);
```

---

## Atención con ERROR TÍPICO

```js
const { nombre } = undefined; //  ERROR
const { nombre } = objeto || {}; // Correcto !
```

---
[Ejercicios](EjercicioDestructuring.md)

