# 📦 ARRAYS DE OBJETOS

En aplicaciones reales, los datos suelen recibirse en forma de **arrays de objetos**:

- una **base de datos** (consultas que devuelven filas)
- una **API HTTP** (peticiones que devuelven JSON)

En ambos casos, en JavaScript terminan siendo objetos dentro de arrays, como los que estamos usando.

Trabajamos con **datos estructurados**.

---

## 📖 Ejemplo real

```js
const usuarios = [
  { id: 1, nombre: "Ana", edad: 20 },
  { id: 2, nombre: "Luis", edad: 30 },
  { id: 3, nombre: "Pedro", edad: 25 }
];

console.log(usuarios);            // Array de Objetos
console.log(usuarios[0]);         // objeto completo
console.log(usuarios[0].nombre);  // Ana
```

Igual que en un array de números cada valor tiene su propio índice, aquí cada objeto también ocupa una posición dentro del array y se accede por su índice.
Para recorrer los datos al estar en un ARRAY se usa:

```js
usuarios.forEach(u => {
  console.log(u.nombre);
});

```
--- 

## 🧪 Ejercicios

Obtenemos estos datos de información de una base de datos:

```js
const productos = [
  { id: 1, nombre: "Ratón", precio: 15, stock: 50, categoria: "Periféricos", activo: true },
  { id: 2, nombre: "Teclado", precio: 30, stock: 20, categoria: "Periféricos", activo: true },
  { id: 3, nombre: "Monitor", precio: 200, stock: 10, categoria: "Pantallas", activo: false },
  { id: 4, nombre: "Portátil", precio: 900, stock: 5, categoria: "Ordenadores", activo: true },
  { id: 5, nombre: "Webcam", precio: 70, stock: 15, categoria: "Accesorios", activo: true }
];
```

1. Accede al primer producto del array y muestra su nombre.
2. Accede al tercer producto del array y muestra su precio.
3. Muestra únicamente el nombre de cada producto.
4. Muestra el nombre y el precio de cada producto.
5. Muestra solo los productos cuyo precio sea mayor que 20.
6. Muestra solo los productos que estén activos.
7. cambia el precio del producto "Ratón" a 18.
8. Aumenta en 5 unidades el stock de todos los productos.
9. Añade una nueva clave llamada iva con valor 21 a cada producto.
10. Añade una nueva clave llamada caro con valor true si el precio es mayor que 100, o false en caso contrario.
11. Muestra cuántos productos hay en total en el array.
12. muestra el producto cuyo nombre sea "Teclado".
---

