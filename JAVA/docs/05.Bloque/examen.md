# 🧪 EXAMEN PRÁCTICO JAVA 

Se valora: claridad, lógica, uso correcto de Java. No hace falta perfección, pero sí que funcione.

## Lógica y estructuras (40%)

**Pide un número al usuario y muestra:**

- Cuántos números pares hay entre 1 y ese número.
- Cuántos impares.

**Dado este array:**
```java
int[] numeros = {3, 7, 2, 9, 12, 5};
```

* Mostrar el número mayor.
* Mostrar la media.
* Mostrar solo los números mayores que 5.

**Simula un sistema simple de ventas:**

```java
double[] ventas = {120.5, 300.0, 50.0, 400.0, 90.0};
```

* Calcula el Total vendido.
* Venta media.
* Cuántas ventas son mayores a 100€.

---

## Métodos (20%)

**Crea métodos y úsalos en el main:**

```java
// devuelve el mayor de un array
public static int obtenerMayor(int[] array){}

// devuelve la media
public static double calcularMedia(int[] array){}
```

--- 
🔹 Programación orientada a objetos (30%)

**Crea una clase Producto con:**

- nombre (String)
- precio (double)
- stock (int)
- Constructor
- Método mostrarInfo() → imprime datos

**Uso de la clase anterior Productos**

En el main quiero que: 

* Crees 2 productos y que muestres su información
  
* Reduce el stock de uno en 1 unidad

---
## Modificación de código (10%)

**Este código tiene errores corrígelo:**

```java
public class Prueba {
    public static void main(String[] args) {
        int numero = "5";
        if(numero = 5){
            System.out.println("Es cinco");
        }
    }
}
```
