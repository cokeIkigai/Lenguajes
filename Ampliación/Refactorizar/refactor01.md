# 🧩 Refactorización – Gestión de alumnos en consola (Java)

- Se te entrega un programa que **gestiona alumnos** desde consola: permite insertar y listar datos con validaciones básicas.
- Funciona, pero el código está desordenado, repetitivo y poco mantenible.
- Revisa previamente que ejecuta y comienza tus dotes de refactorización.
- Transformar el mismo programa en una versión más limpia, modular y profesional, como si fuese código preparado para ampliarse en el futuro. 
- Dejarlo todo en la Clase Main.

*Tu objetivo es refactorizar, no rehacer*

### Enunciados

1. Mejorar `legibilidad` y eliminar código duplicado.
2. `Separar` responsabilidades en métodos (menú, lectura, validaciones y listado).
3. `Centralizar` validaciones en métodos reutilizables.
4. `Repetir` solo el campo inválido, no volver al menu.
5. El main debe tener máximo `15 líneas`.
6. `Mantener` la mismas funcionalidades (insertar, listar y salir).

---

**Archivo main.java:**

```java
package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<String> nombres = new ArrayList<>();
        ArrayList<String> apellidos = new ArrayList<>();
        ArrayList<Integer> edades = new ArrayList<>();
        ArrayList<String> correos = new ArrayList<>();

        int opcion = -1;

        while (opcion != 0) {

            System.out.println("\n1 Insertar alumno");
            System.out.println("2 Listar alumnos");
            System.out.println("0 Salir");

            if (sc.hasNextInt()) {
                opcion = sc.nextInt();
            } else {
                System.out.println("Debes introducir un número");
                sc.next(); // limpiar basura
                opcion = -1;
                continue;
            }

            if (opcion == 1) {

                // ===== NOMBRE =====
                System.out.print("Nombre: ");
                String nombre = sc.next();

                if (nombre.length() < 2) {
                    System.out.println("Nombre inválido");
                    continue;
                }

                // ===== APELLIDO =====
                System.out.print("Apellido: ");
                String apellido = sc.next();

                if (apellido.length() < 2) {
                    System.out.println("Apellido inválido");
                    continue;
                }

                // ===== EDAD =====
                System.out.print("Edad: ");

                if (!sc.hasNextInt()) {
                    System.out.println("Edad debe ser número");
                    sc.next();
                    continue;
                }

                int edad = sc.nextInt();

                if (edad < 18 || edad > 100) {
                    System.out.println("Edad fuera de rango (18-100)");
                    continue;
                }

                // ===== CORREO =====
                System.out.print("Correo: ");
                String correo = sc.next();

                // validación simple (mala a propósito)
                if (!correo.contains("@") || !correo.contains(".")) {
                    System.out.println("Correo inválido");
                    continue;
                }

                // guardar
                nombres.add(nombre);
                apellidos.add(apellido);
                edades.add(edad);
                correos.add(correo);

                System.out.println("Alumno guardado correctamente");
            }

            else if (opcion == 2) {

                if (nombres.size() == 0) {
                    System.out.println("No hay alumnos");
                } else {
                    for (int i = 0; i < nombres.size(); i++) {
                        System.out.println(
                                nombres.get(i) + " " +
                                        apellidos.get(i) + " | " +
                                        edades.get(i) + " | " +
                                        correos.get(i)
                        );
                    }
                }
            }

            else if (opcion != 0) {
                System.out.println("Opción incorrecta");
            }
        }

        sc.close();
    }
}

```
