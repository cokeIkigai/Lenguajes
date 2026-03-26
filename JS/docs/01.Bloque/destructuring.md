# 🟣 DESTRUCTURING EN JAVASCRIPT

El **destructuring** es una sintaxis de JavaScript que permite **extraer valores de arrays** o **propiedades de objetos** y guardarlos directamente en variables.

---
## Sacar propiedades de un objeto.

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
