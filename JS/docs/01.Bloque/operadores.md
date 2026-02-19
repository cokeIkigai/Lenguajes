# 📚 TEMA: OPERADORES EN JAVASCRIPT

Los operadores permiten realizar operaciones con valores y variables.

- Operadores aritméticos
- Operadores de asignación
- Operadores de comparación
- Operadores lógicos
- Operador de concatenación

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

###🔹 3. Operadores de comparación

Devuelven true o false.
```js
  let edad = 18;
  
  console.log(edad > 16);
  console.log(edad < 30);
  console.log(edad == "18");  // compara valor
  console.log(edad === 18);   // compara valor y tipo
```

Aquí puedes introducir la idea clave:

=== es más estricto que ==

###🔹 4. Operadores lógicos

Se usan muchísimo en condiciones.
```js
  let activo = true;
  let admin = false;
  
  console.log(activo && admin); // AND
  console.log(activo || admin); // OR
  console.log(!activo);         // NOT
```
###🔹 5. Operador de concatenación

Muy visual si vienen de Java.
```js
  let nombre = "Ana";
  let texto = "Hola " + nombre;
```
