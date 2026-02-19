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
  const PI = 3.1416;
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

Para estos ejemplos si buscasemos o lo mirásemos


