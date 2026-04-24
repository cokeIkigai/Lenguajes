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

<!--

```js
// 1. Accede al primer producto del array y muestra su nombre.
productos[0].nombre //* 
const [{ nombre }] = productos
productos.forEach((_, i) => i === 0 ? productos[i].nombre : null)
for (const p of productos) { p.nombre; break; }
productos.map(p => p.nombre)[0]
productos.filter((_, i) => i === 0)[0].nombre
productos.find((_, i) => i === 0).nombre

// 2. Accede al tercer producto del array y muestra su precio.
productos[2].precio //* 
const [,,{ precio }] = productos
productos.forEach((_, i) => i === 2 ? productos[i].precio : null)
let i2=0; for (const p of productos) { i2===2 ? p.precio : null; if(i2++===2) break; }
productos.map(p => p.precio)[2]
productos.filter((_, i) => i === 2)[0].precio
productos.find((_, i) => i === 2).precio

// 3. Muestra únicamente el nombre de cada producto.
productos.forEach(p => p.nombre) //* 
for (const p of productos) p.nombre
productos.map(p => p.nombre)
productos.filter(() => true).map(p => p.nombre)
productos.find(p => p.nombre)

// 4. Muestra el nombre y el precio de cada producto.
productos.forEach(p => ({ nombre: p.nombre, precio: p.precio })) //* 
for (const p of productos) ({ nombre: p.nombre, precio: p.precio })
productos.map(p => ({ nombre: p.nombre, precio: p.precio }))
productos.filter(() => true).map(p => ({ nombre: p.nombre, precio: p.precio }))
productos.find(p => p.nombre)

// 5. Muestra solo los productos cuyo precio sea mayor que 20.
productos.filter(p => p.precio > 20) //* 
productos.forEach(p => p.precio > 20 ? p : null)
for (const p of productos) p.precio > 20 ? p : null
productos.map(p => p.precio > 20 ? p : null)
productos.find(p => p.precio > 20)

// 6. Muestra solo los productos que estén activos.
productos.filter(p => p.activo) //* 
productos.forEach(p => p.activo ? p : null)
for (const p of productos) p.activo ? p : null
productos.map(p => p.activo ? p : null)
productos.find(p => p.activo)

// 7. Cambia el precio del producto "Ratón" a 18.
productos.find(p => p.nombre === "Ratón").precio = 18 //* 
productos.forEach(p => p.nombre === "Ratón" ? (p.precio = 18) : null)
for (const p of productos) p.nombre==="Ratón" ? (p.precio=18) : null
productos.map(p => p.nombre === "Ratón" ? { ...p, precio: 18 } : p)
productos.filter(p => p.nombre === "Ratón")

// 8. Aumenta en 5 unidades el stock de todos los productos.
productos.map(p => ({ ...p, stock: p.stock + 5 })) //* 
productos.forEach(p => p.stock += 5)
for (const p of productos) p.stock += 5
productos.filter(() => true).map(p => ({ ...p, stock: p.stock + 5 }))
productos.find(p => p.stock)

// 9. Añade una nueva clave llamada iva con valor 21 a cada producto.
productos.map(p => ({ ...p, iva: 21 })) //* 
productos.forEach(p => p.iva = 21)
for (const p of productos) p.iva = 21
productos.filter(() => true).map(p => ({ ...p, iva: 21 }))
productos.find(p => p.iva)

// 10. Añade una nueva clave llamada caro con valor true si el precio es mayor que 100, o false en caso contrario.
productos.map(p => ({ ...p, caro: p.precio > 100 })) //* 
productos.forEach(p => p.caro = p.precio > 100)
for (const p of productos) p.caro = p.precio > 100
productos.filter(() => true).map(p => ({ ...p, caro: p.precio > 100 }))
productos.find(p => p.caro)

// 11. Muestra cuántos productos hay en total en el array.
productos.length //* 
let total=0; productos.forEach(() => total++)
let total2=0; for (const _ of productos) total2++
productos.map(() => 1).length
productos.filter(() => true).length

// 12. Muestra el producto cuyo nombre sea "Teclado".
productos.find(p => p.nombre === "Teclado") //* 
productos.filter(p => p.nombre === "Teclado")[0]
productos.forEach(p => p.nombre === "Teclado" ? p : null)
let res; for (const p of productos) p.nombre==="Teclado" ? res=p : null
productos.map(p => p.nombre === "Teclado" ? p : null)
```

### Resumen

**Posición conocida** → [i]: cuando sabes el índice exacto y accedes directamente sin recorrer.
**Acción sin devolver** → forEach: cuando ejecutas algo por cada elemento sin crear nuevo array (no permite break, recorre todo siempre).
**Recorrer con control** → for...of: cuando necesitas iterar y poder usar break / continue (puedes detener el bucle cuando quieras)
**Filtrar (varios)** → filter: cuando quieres quedarte con los elementos que cumplen una condición (recorre todo el array y devuelve uno nuevo).
**Transformar (todos)** → map: cuando quieres modificar cada elemento y obtener un nuevo array (recorre todo el array).
**Buscar uno** → find: cuando necesitas un único elemento que cumpla una condición (se detiene al encontrarlo).

->
