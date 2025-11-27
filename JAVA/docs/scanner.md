# 🖨️ Scanner en Java

`Scanner` es una clase que permite **leer datos del usuario** desde el teclado. Se usa mucho para ejercicios de introducción.

---

## 1. Importar Scanner

```java
import java.util.Scanner;
```
### Crear un objeto Scanner
```java
// System.in → indica que se leerá desde el teclado.
Scanner sc = new Scanner(System.in);
```

## 2. Leer diferentes tipos de datos

```java
// Leer un String (una palabra)
String nombre = sc.next();

//Leer un double
double precio = sc.nextDouble();

// Leer un boolean
boolean activo = sc.nextBoolean();

// Leer un String completo (con espacios)
String frase = sc.nextLine();

// Leer un int
int edad = sc.nextInt();
```
### 3. Después de nextInt() o nextDouble(), queda un salto de línea pendiente.
```java
int edad = sc.nextInt();
sc.nextLine(); // limpiar el buffer
String nombre = sc.nextLine();
```
## 4. Ejemplo con Main
```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce tu nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Introduce tu edad: ");
        int edad = sc.nextInt();

        System.out.println("Hola " + nombre + ", tienes " + edad + " años.");
    }
}
```
## 5. Cerrar el Scanner
```java
sc.close();
```
