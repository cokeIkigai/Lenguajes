# ENUNCIADO 1: CIFRADO DEL ABECEDARIO INVERTIDO

Crea un método que intercambie cada letra de un texto de mínimo 5 frases cambie por su letra consecutiva. 
Si pones b camia por c, si hay una m cambia por n. En caso de que sean vocales la a:1, e: 2, i:3, o:4 , u :5. 

**Pistas:**

- Recorro el texto que está predeterminado en el código.
- Conseguir ir de caracter en caracter
- Cambiar a formato ASCII cada letra
- Sumar +1
- Cambiar a su formato caracter
- Concatenar con el "texto encriptado"

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

# ENUNCIADO 2: PASAR  A SU CODIGO ASCII

Transforma tu DNI en un ASCII.

**Pistas:**

Id de un caracter en caracter paracambiar a ASCII

# ENUNCIADO 3: PASAR un PASSWORD 

Crea un método donde tenga relación a la hora que se ha creado y si después de un minuto no se desencripta que diga que ha expirado.

# ENUNCIADO 4: VERIFICAR SI UN DNI ES VÁLIDO

Se puede usar un Scanner o una cadena predeterminada directamente.

