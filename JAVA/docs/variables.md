# Variable en Java
Una **variable** es un **espacio en memoria** donde se almacena un dato que puede cambiar durante la ejecución del programa.

---

## Componentes de una variable
Una variable se compone de:

1. **Tipo de dato** → indica qué tipo de valor almacena 

    a) Primitivo:
   - Ejemplos: `int`, `double`, `boolean`, `String` 

    b) Referencia:
   - Ejemplos: `Clase`, `Objeto`, `Array...`

2. **Nombre de la variable** → identificador para acceder al dato  
   - Debe empezar por letra, nunca por número  
   - Ejemplos: `edad`, `precioTotal`, `esActivo`

3. **Valor** → dato almacenado  
   - Ejemplo: `25`, `10.5`, `true`
   - Ejemplo: 

---

## Estructura general
```java 
tipo nombre = valor;
```
- Ejemplos Primitivos:
```JAVA
int edad = 25;
double precio = 19.99;
boolean esMayor = true;
String nombre = "Coke";
```
- Ejemplos de Referencia:
```JAVA
Persona alumno = new Persona();
int[] edades = new int[3];
```
##  String

**Concatenación** : Agrupar o añadir cadenas de texto junto con variables
```JAVA
String ciudad = "Madrid";
String saludo = "Hola " + ciudad;
String texto = `saludo , soy Jorge `
```

**Métodos frecuentes:**
```java
String texto = "Programación";

texto.length();      // número de caracteres
texto.toUpperCase(); // "PROGRAMACIÓN"
texto.toLowerCase(); // "programación"
texto.charAt(0);     // 'P'
texto.contains("gra"); // true
String sub = saludo.substring(0, 4); // Prog
```

**String.format**
```java
String nombre = "Jorge";
int edad = 28;
String texto = String.format("Soy %s y tengo %d años", nombre, edad);
String reemplazo = saludo.replace("Pro", "Coke"); // "Cokegramación"
String sinEspacios = conEspacios.trim(); // quita los espacios delante y detrás"
String[] partes = frase.split(","); // ["uno", "dos", "tres"]
String unido = String.join(" - ", "A", "B", "C"); // "A - B - C"
```

## Integer

**Diferentes tipos para guardar valores tipo número:**

`Integer` es la **clase envoltorio (wrapper)** del tipo primitivo `int`.

| Tipo      | Tamaño      | Decimales | Ejemplo      |
| --------- | ----------- | --------- | ------------ |
| `byte`    | 1 byte      | no        | 100          |
| `short`   | 2 bytes     | no        | 1000         |
| **`int`** | **4 bytes** | **no**    | **2025**     |
| `long`    | 8 bytes     | no        | 10000000000L |
| `float`   | 4 bytes     | sí        | 3.14f        |
| `double`  | 8 bytes     | sí        | 3.14159      |

**Convertir String a Number:**

```JAVA
String numero = "123";
int valor = Integer.parseInt(numero); // 123
Integer num = Integer.valueOf(numero); // 123
```
**Convertir Number a String:**

```JAVA
String texto = Integer.toString(50); // "50"
String texto = String.valueOf(50);   // "50"
```

**Random**
```java
int n = (int)(Math.random() * 10) + 1;
```
**Potencias y raíces**
```java
double potencia = Math.pow(2, 3);  // 2^3 = 8
double raiz = Math.sqrt(16);       // 4
```
**Valor absoluto**
```java
int abs = Math.abs(-10); // 10
```
**Redondeo**
```java
long r1 = Math.round(3.6); // Normal: 4
double r2 = Math.floor(3.9); // hacia abajo: 3.0
double r3 = Math.ceil(3.1); // Hacia arriba: 4.0
```


## Boolean


`boolean` es un tipo primitivo que solo puede tener **dos valores** `TRUE` o `FALSE`.
Sirve para condiciones, decisiones y expresiones lógicas.

# Declaración de un boolean

```java
boolean activo = true;
boolean terminado = false;
```

### Operadores lógicos

**AND (&&)**

Devuelve `true` si ambas son `true`:

```java
boolean r = (5 > 3) && (10 > 8); // true
```

**OR(||)**
Devuelve `false` si alguna es `true`:
```java
boolean r = (5 > 10) || (10 > 8); // true
```

**NOT(!)**

```java
boolean a = true;
boolean b = !a;  // false
```

**Convertir desde Boolean (objeto) a boolean (primitivo)**
```java
Boolean obj = Boolean.TRUE;
boolean valor = obj.booleanValue();
```
**valueOf → crear objetos Boolean**
```java
Boolean b1 = Boolean.valueOf(true);
Boolean b2 = Boolean.valueOf("false");
```
