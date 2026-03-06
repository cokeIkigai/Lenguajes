## 🔡 ENUNCIADO 1: Cifrado de un texto

Crea un método que intercambie cada letra de un texto de mínimo 5 frases cambie por su letra consecutiva. 
Si pones b camia por c, si hay una m cambia por n. En caso de que sean vocales la a:1, e: 2, i:3, o:4 , u :5. 

**Pistas:**

- Recorro el texto que está predeterminado en el código.
- Conseguir ir de caracter en caracter
- Cambiar a formato ASCII cada letra
- Sumar +1
- Cambiar a su formato caracter
- Concatenar con el "texto encriptado"
- Poder encriptar y desencriptar

--- 

```java
 // 🔹 De carácter a ASCII (char → int)
  char letra = 'A';
  int ascii = (int) letra;   // también valdría: int ascii = letra;
```

```java
 // 🔹 De carácter a ASCII (ints → char)
  int numero = 66;
  char caracter = (char) numero;
```

--- 

## 🔢 ENUNCIADO 2: Encriptarlo

Transforma tu DNI en un ASCII.

**Pistas:**

Id de un caracter en caracter paracambiar a ASCII

## 📆 ENUNCIADO 3: Pasar un PASSWORD 

Crea un password y cífralo junto con la fecha actual. (Usas el método anterior de cifrado)

Verificar si no ha caducado la sesión de un minuto.

Si ha caducado, se pone que ha caducado tantos minutos, segundos...

Si es antes de un minuto, muestras el password descífrado sin su fecha y hora, solo el password.

## 👮‍♂️ ENUNCIADO 4: Verificar si un DNI es válido

Un DNI consta de 8 números y una letra. Para verificar que es correcto y es válido de suman los números y se divide entre 23, se saca su resto.
La parte entera del resto, está asociada a una letra. Si es correcto, es válido el DNI.
Se puede usar un Scanner o una cadena predeterminada directamente.

## 🔐ENUNCIADO 5: Analizador de contraseñas Seguras

**5.1 Validar contraseña segura**: Crea un programa que compruebe si una contraseña introducida por el usuario es segura.

Por cada apartado que se vaya haciendo se va acoplando al anterior. La contraseña solo será válida si cumple todas estas condiciones:

- Tiene al menos 12 caracteres
- Contiene al menos una letra mayúscula
- Contiene al menos un número
- Contiene al menos un símbolo (por ejemplo: ! @ # $ % & * ?)

El programa debe indicar:

- Si la contraseña es válida o no
- Qué condición no se cumple en caso de ser incorrecta.

---

**5.2 Lista de contraseñas prohibidas:** Amplía el ejercicio anterior para que el programa rechace contraseñas demasiado comunes.

Crea una lista de contraseñas prohibidas, por ejemplo:
```
123456, password, qwerty, admin, 111111, abc123
```
Si el usuario introduce una contraseña que esté en esa lista, el programa debe indicar:

Contraseña no permitida (demasiado común)

--- 

**5.3. Analizador de fortaleza de contraseña (por puntuación)**

En este ejercicio debes crear un analizador de seguridad de contraseñas que asigne una puntuación a la contraseña introducida por el usuario.
Según la puntuación total, el programa clasificará la contraseña como:
```
0 -3             → Débil
3 - 5 puntos     → Media
5 – 7 puntos     → Fuerte
8 puntos o más   → Muy fuerte
```

**Sistema de puntuación**

La `longitud` es uno de los factores más importantes de seguridad.
```
Menos de 8 caracteres     → -2 puntos
Entre 8 y 11 caracteres   → +1 punto
Entre 12 y 15 caracteres  → +2 puntos
16 o más caracteres       → +3 puntos
```

Se evaluará si la contraseña contiene distintos `tipos` de caracteres.

```
Contiene letras minúsculas → +1 punto
Contiene letras mayúsculas → +1 punto
Contiene números           → +1 punto
Contiene símbolos          → +1 punto
```

Si la contraseña contiene patrones fáciles de adivinar, se restarán puntos.

Patrones a detectar:
```
123
abc
qwerty
aaaa
1111
password
admin
```

Penalización:

Contiene un patrón simple → -2 puntos
Contiene varios patrones  → -3 puntos

Las repeticiones hacen que la contraseña sea más fácil de adivinar.

```
aaa -1 punto
111 -1 punto
bbb -1 punto
aaaaaa -2 punto
```
