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

## 🔢 ARRAYS

Sirve para sacar valores por posición.
```js
const colores = ["rojo", "verde", "azul"];
const [a, b, c] = colores;

console.log(a); // rojo
console.log(b); // verde
console.log(c); // azul

// Con un hueco
const colores2 = ["amarillo", "morado", "negro"];

const [primero, , tercero] = colores2;

console.log(primero); // amarillo
console.log(tercero); // negro

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
console.log(segundo); // 2
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
