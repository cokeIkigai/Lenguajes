# 🧠 Funciones en JavaScript
## 📌 ¿Qué es una función?

### 1. Una función es un bloque de código reutilizable que se ejecuta cuando la llamas.

```js
// función que no devuelve valor

function saludar() {
  console.log("Hola");
}

// función que devuelve un valor

function despedirse() {
  return "Adiós";
}

saludar()
despedirse()
```

### 2. Funciones con parámetros

Permiten recibir datos para trabajar con ellos.

```js
function sumar(a, b) {
  return a + b;
}

console.log(sumar(3, 5)); // 8
```

