# Condicionales en Java

Los condicionales permiten **tomar decisiones** según si una condición es `true` o `false`.

---

## 1. `if`
Ejecuta un bloque **solo si** la condición es verdadera.

```java
if (condicion) {
    // Si se cumple entra por aquí (true)
    // Lógica dentro de la condición  
}

if (edad >= 18) {
    System.out.println("Mayor de edad");
}
```
## 2. `if - else`

Ejecuta un bloque u otro según la condición.

```java
if (nota >= 5) {
    System.out.println("Aprobado");
} else {
    System.out.println("Suspenso");
}
```
## 3. `if - else if - else`

Varios casos posibles

```java
if (nota >= 9) {
    System.out.println("Sobresaliente");
} else if (nota >= 7) {
    System.out.println("Notable");
} else if (nota >= 5) {
    System.out.println("Aprobado");
} else {
    System.out.println("Suspenso");
}

```
## 4. Operador ternario

Condición en una sola línea

```java
String resultado = (edad >= 18) ? "Adulto" : "Menor";
```

## 5. switch (varias opciones por valor)

```java
int dia = 3;

switch (dia) {
    case 1 -> System.out.println("Lunes");
    case 2 -> System.out.println("Martes");
    case 3 -> System.out.println("Miércoles");
    case 4 -> System.out.println("Jueves");
    case 5 -> System.out.println("Viernes");
    case 6 -> System.out.println("Sábado");
    case 7 -> System.out.println("Domingo");
    default -> System.out.println("Día inválido");
}
```

## 6. Operadores importantes para condicionales

```java
==   igual
!=   distinto
>    mayor
<    menor
>=   mayor o igual
<=   menor o igual
```

## Ejemplo completo

```java
int edad = 20;
boolean tieneCarnet = true;

if (edad >= 18 && tieneCarnet) {
    System.out.println("Puede conducir");
} else {
    System.out.println("No puede conducir");
}
```
