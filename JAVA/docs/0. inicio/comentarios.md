# 📝Comentarios en Java y otras opciones relacionadas

Los **comentarios** permiten añadir texto dentro del código que **no se ejecuta**.  
Sirven para explicar, documentar o desactivar partes del programa.

---

# 1. Comentario de una sola línea

Se usa `//`

```java
// Esto es un comentario de una sola línea
int edad = 20; // También puede ir al final de la línea
```
2. Comentario de varias líneas
- Se usa `/* ... */`

```java
/*
Esto es un comentario
de varias líneas
puede ocupar varias líneas
*/
int edad = 20;
```
3. Comentario de documentación (JavaDoc)
- Se usa `/** ... */`
- Sirve para documentar métodos, clases y atributos.
- Muy usado en proyectos profesionales.

```java
/**
 * Este método suma dos números.
 * @param a primer número
 * @param b segundo número
 * @return resultado de la suma
 */
public int sumar(int a, int b) {
    return a + b;
}
```

4. Comentar o descomentar código temporalmente
   
- Para `evitar` que una parte del código se ejecute:

```java
// System.out.println("Esto no se ejecuta");

//O varias líneas:

/*
System.out.println("Línea 1");
System.out.println("Línea 2");
*/
```

5. Buenas prácticas con comentarios
   
- Comentar por qué, no solo qué hace el código.

No comentar cosas obvias:

```java
int edad = 20; // declaro la edad
int edad = 20; // edad mínima requerida para registrarse
```
6. Marcadores comunes usados por programadores
- Se usan para buscar más rápido tareas pendientes:

```java
// TODO: mejorar este método
// FIX: revisar error de índice
// NOTE: esta función se usa en 3 clases diferentes
// WARNING: rendimiento bajo en grandes listas
```

7. Comentarios en bloque dentro de una línea
```java
int x = 5 /* valor inicial */ + 10;
```

8. Comentario para desactivar partes de un método
```java
public void test() {

    // Código antiguo:
    /*
    System.out.println("Versión antigua");
    procesarDatosViejos();
    */

    // Código actual:
    System.out.println("Versión nueva");
}
```
