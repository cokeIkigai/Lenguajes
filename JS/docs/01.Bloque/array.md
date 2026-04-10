# 🔢 ARRAY

Un array es una estructura de datos que permite almacenar varios valores en una sola variable, organizados en posiciones (índices). Es de tipo Objeto.

### ✅ Creación de un Array y sus propiedades más básicas

```js
const colores = ["rojo", "verde", "azul"];

console.log(colores[0]); // rojo
console.log(colores[2]); // azul
```

**🟢Modificar**
```js
const nums = [1, 2, 3];

nums[1] = 10;

console.log(nums); // [1, 10, 3]
```
**🔴length**

```js
const nums = [1, 2, 3, 4];
console.log(nums.length); // 4
```

**🔵Añadir**

```js
const nums = [1, 2];

nums.push(3);    // añade al final
nums.unshift(0); // añade al inicio
```

**🟡Eliminar**

```js
const nums = [1, 2, 3];
nums.pop();    // quita el último
nums.shift();  // quita el primero
```

---

### ✅ Recorrer

**🔹 for clásico**

```js
const nums = [10, 20, 30];

for (let i = 0; i < nums.length; i++) {
  console.log(nums[i]);
}
```
**🔹 for...of**
```js
for (let valor of array) {
  console.log(valor);
}
```

**🔹 forEach**
```js
const numeros = [1, 2, 3];

numeros.forEach(n => console.log(n));

// Con 2 argumentos:

// (1º es el valor del elemento y 2º el índice)
numeros.forEach((valor, indice) => {
  console.log(indice, valor);
});

// 1, 0
// 2, 1
// 2, 2
```

---

### ✅ Métodos importantes 

**🔹 map → transforma**

```js
const nums = [1, 2, 3];

const dobles = nums.map(n => n * 2);
// [2, 4, 6]
```

**🔹 filter → filtra**
```js
const nums = [1, 2, 3, 4];

const pares = nums.filter(n => n % 2 === 0);
// [2, 4]
```

**🔹 reduce → acumula**
```js
const nums = [1, 2, 3];

const suma = nums.reduce((acc, n) => acc + n, 0);
// 6
```

---

🎯 Idea clave para clase
Un array no es solo “guardar datos”
Es procesar datos

- 👉 map → cambiar
- 👉 filter → seleccionar
- 👉 reduce → resumir

---

[Ejercicios](ejercicioArray.md)
