# 🧠 Funciones en JavaScript
## 📌 ¿Qué es una función?

Una función es un bloque de código reutilizable que se ejecuta cuando la llamas.

### 1. Función y su llamada

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

 ### 2. Parámetros por defecto

Si no se pasa valor, se usa uno por defecto.

```js
function saludar(nombre = "Invitado") {
  console.log("Hola " + nombre);
}

saludar();        // Hola Invitado
saludar("Coke");  // Hola Coke
```

### 3. Funciones anónimas

No tienen nombre, suelen usarse dentro de variables.

```js
const multiplicar = function(a, b) {
  return a * b;
};

console.log(multiplicar(2, 4)); // 8
```

### 4. Arrow functions (funciones flecha)

Forma moderna y más corta.
```js
const restar = (a, b) => {
  return a - b;
};

console.log(restar(10, 3)); // 7
```

👉 Versión corta (retorno implícito):

```js
const doble = x => x * 2;

console.log(doble(5)); // 10
```

---

### 🧪 Ejercicios
1. Haz una función que reciba un número y devuelva su doble.
2. Haz una función que reciba dos números y devuelva su suma.
3. Haz una función que reciba un texto y devuelva su longitud.
4. Haz una función que reciba un número y diga si es positivo, negativo o cero.
5. Haz una función que reciba un número y devuelva true si es par y false si es impar.
