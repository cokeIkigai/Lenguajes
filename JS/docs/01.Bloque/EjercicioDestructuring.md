# 📜 Ejercicios

```js
const tienda = {
  nombre: "TechStore",
  configuracion: {
    idioma: "es",
    moneda: "EUR"
  },
  productoDestacado: {
    nombre: "Laptop",
    precio: 1200
  },
  usuarios: [
    { id: 1, nombre: "Ana", email: "ana@email.com" },
    { id: 2, nombre: "Luis", email: "luis@email.com" }
  ],
  pedido: {
    id: 101,
    cliente: {
      nombre: "Carlos",
      direccion: {
        ciudad: "Madrid",
        cp: "28001"
      }
    },
    productos: ["ratón", "teclado", "monitor"]
  },
  filtros: {
    precioMin: 50,
    precioMax: 10 
  }
};
```

1. Extrae idioma y moneda sin usar `.`.
2. Extrae nombre y precio del productoDestacado y muéstralos por consola.
3. Extrae el nombre del primer usuario del array usuarios.
4. Extrae el primer producto y guarda el resto en otra variable.
5. Extrae directamente la ciudad del cliente.
6. Del primer usuario, extrae email y guarda el resto en otro objeto (simulando quitar datos sensibles).
7. Extrae idioma y una variable tema con valor por defecto "light" desde configuracion.
8. Contar productos del pedido
9. Crea una función mostrarProducto que reciba productoDestacado y muestre nombre y precio usando destructuring en parámetros.
10. Intercambia los valores de precioMin y precioMax usando destructuring.

---
<!--
Correción

```js
// 1. Extrae idioma y moneda sin usar ..

const { configuracion: { idioma, moneda } } = tienda;
console.log(idioma, moneda);

// 2. Extrae nombre y precio del productoDestacado y muÃ©stralos por consola.

const { productoDestacado: { nombre , precio } } = tienda;
console.log(nombre, precio);

// 3. Extrae el nombre del primer usuario del array usuarios.

const { usuarios: [{ nombre: nombreUsuario }] } = tienda;
console.log(nombreUsuario);

// 4. Extrae el primer producto y guarda el resto en otra variable.

const { pedido: { productos: [primerProducto, ...restoProductos] } } = tienda;
console.log(primerProducto);

// 5. Extrae directamente la ciudad del cliente.

const { pedido: { cliente: { direccion: { ciudad } } } } = tienda;
console.log(ciudad);

// 6. Del primer usuario, extrae email y guarda el resto en otro objeto (simulando quitar datos sensibles).

const { usuarios: [{ email, ...datosSensibles }] } = tienda;

console.log(email);
console.log(datosSensibles);

// 7. Extrae idioma y una variable tema con valor por defecto "light" desde configuracion.

const { configuracion: { language, tema = "light" } } = tienda;
console.log(idioma, tema);

// 8. Contar productos del pedido
const { pedido: { productos } } = tienda;
console.log(productos.length);

// 9. Crea una función mostrarProducto que reciba productoDestacado y muestre nombre y precio usando destructuring en parámetros.

function mostrarProducto({ productoDestacado: { nombre, precio } }) {
    console.log(`Producto: ${nombre}, Precio: ${precio}`);
}
mostrarProducto(tienda);

// 10. Intercambia los valores de precioMin y precioMax usando destructuring.

let { filtros: { precioMin, precioMax } } = tienda;
[precioMin, precioMax] = [precioMax, precioMin];
```
->
