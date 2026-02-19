# 📚 TEMA: OPERADORES EN JAVASCRIPT

Los operadores permiten realizar operaciones con valores y variables.

I. OPERADORES: 

- Operadores aritméticos
- Operadores de asignación
- Operadores de comparación
- Operadores lógicos
- Operador de concatenación

II. COMPARADORES:

- Comparativo Débil/Fuerte
- Comparativo tipos

---

### 🔹 1. Operadores aritméticos

Se usan con números.

```js
  let a = 10;
  let b = 3;
  
  console.log(a + b);  // suma
  console.log(a - b);  // resta
  console.log(a * b);  // multiplicación
  console.log(a / b);  // división
  console.log(a % b);  // resto
  console.log(a ** b); // potencia
  console.log(a++);    // incremento
  console.log(a--);    // decremento
```

--- 

### 🔹 2. Operadores de asignación

Modifican el valor de una variable.
```js
  let n = 10;
  
  n += 5; // n = n + 5
  n -= 2;
  n *= 3;
  n /= 2;
```

Esto conecta muy bien con variables.

--- 

### 🔹 3. Operadores de comparación

Devuelven true o false.
```js
  let edad = 18;
  
  console.log(edad > 16);
  console.log(edad < 30);
  console.log(edad == "18");  // compara valor
  console.log(edad === 18);   // compara valor y tipo
```

--- 

### 🔹 4. Operadores lógicos

Se usan muchísimo en condiciones.
```js
  let activo = true;
  let admin = false;
  
  console.log(activo && admin); // AND
  console.log(activo || admin); // OR
  console.log(!activo);         // NOT
```

---  

### 🔹 5. Operador de concatenación

Muy visual si vienen de Java.
```js
  let nombre = "Ana";
  let texto = "Hola " + nombre;
```

---

### 🪞 Comparador (=, ==, ===)

Debemos diferenciar entre los siguientes operadores o asigandores.

- **Para cuando es `=`:** lo que se está haciendo es una asignación de los valores, no se está igualando o comprando a otra cosa.

```js
let a = 0;         
```

En este caso, la variable a, no se está preguntando si ¿a es igual cero?, es la afirmación o la asignación del valor. Se está diciendo que ahora a `tiene` el valor 0.

- **Para cuando es `==`:** lo que se está haciendo es comparar los dos valores, donde te devuelve un booleano, true o false. Se le llama comparador débil debido a que compara el valor y no tiene encuenta el tipo. JavaScript intenta convertir los valores antes de comparar.

```js
console.log(5 == "5");    // true
console.log(5 === "5");   // false
console.log(true == 1);   // true

console.log(true == 1);   // true
console.log(true === 1);  // false
```
---

### 🛒 COMPARADOR

```js


// 🔹 Comparaciones con false
console.log(false == 0);         // true
console.log(false == []);        // true
console.log(false == {});        // false
console.log(false == null);      // false
console.log(false == undefined); // false


// 🔹 Comparaciones con true
console.log(true == 1);   // true
console.log(true == []);  // false
console.log(true == {});  // false
console.log(true == undefined); // false
console.log({} == 0);        // false

// 🔹 Comparaciones con []
console.log([] == 0);         // true
console.log([] == false);     // true
console.log([] == true);      // false
console.log([] == null);      // false
console.log([] == undefined); // false

// 🔹 Comparaciones especiales
console.log(null == undefined); // true
console.log(null == false);     // false
console.log(undefined == false);// false

// 🔹 Comparaciones con 0

console.log(0 == null);      // false
console.log(0 == undefined); // false
```
