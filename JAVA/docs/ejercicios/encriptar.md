## ENUNCIADO 1: Cifrado de un texto

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

## ENUNCIADO 2: Encriptarlo

Transforma tu DNI en un ASCII.

**Pistas:**

Id de un caracter en caracter paracambiar a ASCII

## ENUNCIADO 3: Pasar un PASSWORD 

Crea un password y cífralo junto con la fecha actual. (Usas el método anterior de cifrado)

Verificar si no ha caducado la sesión de un minuto.

Si ha caducado, se pone que ha caducado tantos minutos, segundos...

Si es antes de un minuto, muestras el password descífrado sin su fecha y hora, solo el password.

## ENUNCIADO 4: Verificar si un DNI es válido

Un DNI consta de 8 números y una letra. Para verificar que es correcto y es válido de suman los números y se divide entre 23, se saca su resto.
La parte entera del resto, está asociada a una letra. Si es correcto, es válido el DNI.
Se puede usar un Scanner o una cadena predeterminada directamente.

