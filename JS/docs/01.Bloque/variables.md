# 📚 TEMA: VARIABLES EN JAVASCRIPT

## ¿Qué son las variables?

Las variables son contenedores que almacenan datos en la memoria. En JavaScript, podemos declararlas usando `var`, `let` o `const`.

```console
[tipo] [identificador] = [valor];
```

```console
// ┌─ Tipo (var, let, const)
// │     ┌─ Identificador (nombre de la variable)
// │     │          ┌─ Operador de asignación
// │     │          │    ┌─ Valor                
// ↓     ↓          ↓    ↓
  let nombreUsuario = "Carlos";
```

```js
  var edad = 25;   // Deshuso
  let nombre = "Ana";
  const PI = 3.1416; // nombre en MAYÚSCULAS
```

## Declaración de las variables:

Declarar una variable es crearla o presentarla al programa para que sepa que existe. Una vez que se declara no hace falta volver a declararla y se puede volver a reutilizarla si la necesitamos. 

- Let y var: Se puede declarar sin tener un valor
- Const: Necesita tner valor si se declara.

```js
let nombre;     // ✅ Declaración
const PI;       // ❌ Error: const debe tener valor
var edad;       // ✅ Declaración
```
En JavaScript no se declara el tipo, solo la variable. El tipo lo tiene el valor, no la variable.

```js
// 🔹 Primitivos
let texto = "Hola";                 // string
let numero = 42;                    // number
let decimal = 3.14;                 // number
let activo = true;                  // boolean
let indefinido;                     // undefined
let vacio = null;                   // null
let grande = 1234567890123456789n;  // bigint
let simbolo = Symbol("id");         // symbol

// 🔹 Objetos (referencia)
let objeto = { nombre: "Ana", edad: 30 }; // object
let array = [1, 2, 3];                    // object (array)
let funcion = function () {};             // function (object)

console.log(typeof null);         // "object"  ← comportamiento histórico
console.log(typeof []);           // "object"
console.log(typeof function(){}); // "function"

```

Una vez declarada la variable, se puede usar para guardar cualquier tipo de valor, ya que tiene un tipado dinámico. Pero si se modifica, va pisando al anterior que estaba asignado.

```js
let dato;

dato = 10;        // number
dato = "hola";    // string
dato = true;      // boolean
```

Para conocer que tipo de valor tiene una variable lo podemos saber asi:

```js
  let dato;
  dato = 10;        
  console.log(typeof dato) // number

  dato = "hola";    
  console.log(typeof dato) // string

  dato = true;      
  console.log(typeof dato) // boolean
```

### Diferencia entre undefined y null
```js
let a;
let b = null;

console.log(a); // undefined → no inicializada
console.log(b); // null → vacío intencional
```

### Declarar varias variables

```js
let nombre = "Luis", edad = 30, activo = true;

let x, y, x;
x = 10;
y = 20;
z = 30;

let [n1, n2, n3] = [10, 20, 30];
console.log(n1, n2, n3);

```

## 🧩SCOPE

El scope es el ámbito de visibilidad de una variable. Define dónde puedes acceder a ella dentro del código.

### 🌏1. GLOBAL

Variable creada fuera de bloques o funciones. Normalmente se declara al inicio del programa y tienes acceso en todo él.

```js 
let nombre = "Ana";
console.log(nombre); // accesible
```

### 🏙️ 2. BLOQUE {}

Está dentro de funciones o de condiciones.

```js
if (true) {
  let edad = 40;
  console.log(edad); // OK
}
console.log(edad); // ❌ error
```


### 🛞 3. FUNCIÓN

```js
function saludar() {
  let mensaje = "hola";
  console.log(mensaje);
}
saludar();
console.log(mensaje); // ❌ error
```

### 🤼 4. VAR vs LET

Aunque ya `var` está en deshuso, es necesario comprender cómo funciona.

`VAR` NO tiene scope de bloque:
```js
if (true) {
  var x = 10;
}
console.log(x); // 10  ← sigue existiendo
```
`LET` SÍ tiene scope de bloque;
```js
if (true) {
  let y = 20;
}
console.log(y); // ❌ error
```

### 🌑 5. Shadowing 

Una variable interna puede “tapar” otra.

```js
let valor = 1;
if (true) {
  let valor = 2;
  console.log(valor); // 2
}
console.log(valor); // 1
```

### 🟢 Resumen Scopes

```js
  let global = "soy global";

  function test() {
    let local = "soy local";
  
    if (true) {
      let bloque = "solo bloque";
      console.log(global);
      console.log(local);
      console.log(bloque);  
    }
   console.log(local)
   console.log(bloque); // error
  }
test();
```





























