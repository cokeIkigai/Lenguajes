# Arrays en Java

Un **array** es una estructura que almacena **varios valores del mismo tipo** en posiciones consecutivas.

---

## 1. Declaración de un array

### Forma 1: declarar + crear tamaño
```java
int[] numeros = new int[5]; 
// crea un array con 5 posiciones (0 a 4)
// Valor es fijo y no se puede añadir o quitar
```

### Forma 2: declarar con valores
```java
int[] notas = {5, 7, 9, 10};
```
## 2. Acceder a posiciones

Las posiciones empiezan en 0.
```java
int primero = notas[0]; // 5
int ultimo = notas[3];  // 10
```

## 3. Modificar un valor
```java
notas[1] = 8; // antes era 7
```
## 4. Longitud del array
```java
int tamaño = notas.length; // 4
```
## 5. Recorrer un array
Con for clásico
```java
for (int i = 0; i < notas.length; i++) {
    System.out.println(notas[i]);
}
```

Con for-each
```java
for (int n : notas) {
    System.out.println(n);
}
```
## 6. Arrays multidimensionales
```java
int[][] matriz = {
    {1, 2, 3},
    {4, 5, 6}
};

int x = matriz[0][1]; // 2
int y = matriz[1][1]; // 5
```

## 7. Ejemplo completo
```java
int[] edades = {20, 25, 30};

System.out.println("Primero: " + edades[0]); // 20
System.out.println("Tamaño: " + edades.length); // 3

for (int edad : edades) {
    System.out.println("Edad: " + edad); // 20 , 25 , 30
}
```
--- 

# ArrayList<String> en Java

`ArrayList<String>` es una **lista dinámica** que almacena **Strings**.  
A diferencia de un array normal, puede **crecer y reducirse** automáticamente.


### 1. Importar ArrayList

```java
import java.util.ArrayList;
```

### 2. Crear ArrayList
```java
ArrayList<String> nombres = new ArrayList<>();
```

### 3. Añadir elementos
```java
nombres.add("Coque");  // Coque
nombres.add("Luis");   // Coque , Luis
nombres.add("Ana");    // Coque, Luis, Ana
```

### 4. Acceder, Modificar u eliminar elementos
```java
String primero = nombres.get(0); // "Coque"
nombres.set(1, "Carlos"); // cambia "Luis" por "Carlos"
nombres.remove(0); // elimina "Coque"
```

### 5. Tamaño del ArrayList y recorrer
```java
int tamaño = nombres.size(); 
// 1º forma
for (int i = 0; i < nombres.size(); i++) {
    System.out.println(nombres.get(i));
}
// 2º forma
for (String n : nombres) {
    System.out.println(n);
}
```

### 6. Comprobar si existe un elemento y vaciar lista
```java
boolean existe = nombres.contains("Ana");
nombres.clear();
// Comprueba si está vacia
if (nombres.isEmpty()) { ... }

```

---
### Convertir ArrayList a Array

Deben tener la misma tipología

## 🔹 **ArrayList<String> → String[]**
```java
// Creamos el ArrayList
ArrayList<String> lista = new ArrayList<>();
lista.add("Coque");
lista.add("Ana");
lista.add("Luis");

// Para pasar ArrayList a array
String[] array = lista.toArray(new String[0]);
```

### String[] a ArrayList<String>:
```java
// Cermos el array
String[] array = {"Coque", "Ana", "Luis"};
// Pasar array a ArrayList
ArrayList<String> lista = new ArrayList<>(Arrays.asList(array));

```
## 🔹 **ArrayList<Integer> → Integer[]**

```java
// Creamos el ArrayList
ArrayList<Integer> lista = new ArrayList<>();
lista.add(10);
lista.add(20);
lista.add(30);

// Pasar ArrayList a array de Integer
Integer[] array = lista.toArray(new Integer[0]);
```
