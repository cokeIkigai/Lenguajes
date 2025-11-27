# Bucles en Java

Los **bucles** permiten repetir una acción varias veces.  
Java tiene 4 principales: `for`, `while`, `do-while` y el `for-each`.

---

## 1. Bucle **for**
Se usa cuando sabes **cuántas veces** quieres repetir algo.

```java
for (inicio del contador; condicion; incremento) {
    // Código si cumple la condicion
}
```
```java
for (int i = 0; i < 5; i++) {
    System.out.println("i vale: " + i);
}
```

## 2. Bucle while

Repite mientras la condición sea true. Hasta que no se cumpla la condición está en el bucle.

```java
int i = 0;

while (i < 5) {
    System.out.println("i vale: " + i);
    i++; // importante incrementar
}
```
## 3. Bucle do-while

Similar a while, pero siempre se ejecuta al `menos` una vez. 
```java
int i = 0;

do {
    System.out.println("i vale: " + i);
    i++;
} while (i < 5);
```
## 4. Bucle for-each (recorrer arrays o listas)

Para recorrer `colecciones`.

```java
String[] nombres = {"Coke", "Luis", "Ana"};

for (String nombre : nombres) {
    System.out.println(nombre);
}
```
## 5. Términos de control
`break`: Sale del bucle.

```java
for (int i = 0; i < 10; i++) {
    if (i == 5) break; // Cuando i = 5 sale del bucle no conitnua hacia el 6
}
```
`continue`: Salta a la siguiente vuelta del bucle.
```java
for (int i = 0; i < 5; i++) {
    if (i == 2) continue; // Cuando sea i = 2 va para el 3 
    System.out.println(i);
}
```
