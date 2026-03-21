# 📚 Funciones útiles

Continuamos con otras funciones propias de JavaScript que permiten resolver tareas comunes de forma directa, sin necesidad de crear soluciones desde cero. Estas funciones ya están incorporadas en el lenguaje y están diseñadas para trabajar de manera más eficiente, clara y reutilizable, evitando repetir código innecesario.

## 🔹 Find() | Some() | Every()

```js
const arr = [1, 2, 3, 4];

// 1º elemento que cumple
const encontrado = arr.find(x => x > 2); // 3

// Alguno cumple
const hayMayorQue3 = arr.some(x => x > 3); // true
 
// Todos cumplen
const todosMayoresQue0 = arr.every(x => x > 0); // true
```

---

## 🔹 Strings: trim() | toUpperCase() / toLowerCase() | includes() | split()

```js
const texto = " Hola Mundo ";

// Quitar espacios al inicio y final
const sinEspacios = texto.trim(); // "Hola Mundo"

// Mayúscula / minúscula
texto.toUpperCase(); // " HOLA MUNDO "
texto.toLowerCase(); // " hola mundo "

// Comprobar si contiene algo
texto.includes("Mundo"); // true
texto.includes("tres");  // false

// Dividir en array
const palabras = texto.split(" "); // ["", "Hola", "Mundo", ""]

```
---

## 🔹 Números: parseInt() | parseFloat() | Number() | toFixed()

```js
// Convierte a entero
parseInt("10");      // 10
parseInt("10.9");    // 10
parseInt("10px");    // 10

// Convierte a decimal
parseFloat("10.5");  // 10.5
parseFloat("3.14px");// 3.14

// Conversión estricta
Number("123");       // 123
Number("10.5");      // 10.5
Number("10px");      // NaN ❗

// Limitar decimales (devuelve string)
(3.1416).toFixed(2); // "3.14"
(5).toFixed(2);      // "5.00"
```
---

## 🔹 Objetos: keys() | values() | entries()

```js
const obj = { nombre: "John", edad: 32 };

const claves = Object.keys(obj); // ["nombre", "edad"]

const valores = Object.values(obj); // ["John", 32]

const entradas = Object.entries(obj); // [["nombre", "edad"], ["John", 32]]
 
// Uso típico con entries
entradas.forEach(([clave, valor]) => {
  console.log(clave, valor);
});
```
---

## 🔹 JSON:  parse() | stringify()

```js
// Texto a objeto
const obj = JSON.parse('{"a":1}'); // { a: 1 }

// Objeto a texto
const texto = JSON.stringify({ a: 1 }); // '{"a":1}'
```

---

## 🔹 Utilidades ejecución tiempo: setTimeout() | setInterval() | clearInterval()

```js

//Ejecutar una vez después de X ms
setTimeout(() => {
  console.log("Hola después de 1 segundo");
}, 1000);

// Ejecutar cada X ms
const intervalo = setInterval(() => {
  console.log("Tick");
}, 1000);

// Parar el intervalo
setTimeout(() => {
  clearInterval(intervalo);
}, 5000);
```
