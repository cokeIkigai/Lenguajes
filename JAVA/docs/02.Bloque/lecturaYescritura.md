
#  📂 Lectura desde un Archivo

En Java, cuando necesitamos leer archivos de texto, **FileReader** nos permite acceder al contenido, pero leer carácter por carácter resulta ineficiente. 
Aquí es donde **BufferedReader** entra en acción, ya que utiliza un búfer para optimizar la lectura, especialmente útil cuando trabajamos con archivos grandes.

## 👓 FileReader y BufferedReader

**BufferedReader** permite leer archivos línea por línea, lo que lo hace eficiente para procesar texto. Este código muestra cómo leer un archivo de texto línea por línea de manera eficiente. 
FileReader establece la conexión con el archivo, mientras que **BufferedReader** agrega capacidad de búfer y el método **readLine()** para procesar texto línea por línea, reduciendo operaciones de **entrada/salida** al disco.

```java
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("archivo.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
```

## 🕶️ **Lectura desde un Archivo con Scanner**

La clase **Scanner** en Java proporciona una forma alternativa y versátil para leer archivos de texto. 
A diferencia de BufferedReader que se enfoca en eficiencia con búfer, Scanner ofrece funcionalidades adicionales para parsear y analizar datos estructurados dentro del archivo.

```java
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File("archivo.txt"))) {
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + e.getMessage());
        }
    }
}
```
---

## ✏️ Escritura de Archivos en Java

Para escribir datos en archivos de texto, Java ofrece varias alternativas. 
**FileWriter** permite la escritura básica, mientras que BufferedWriter optimiza el proceso mediante búfer, y PrintWriter añade funcionalidades de formato similares a System.out.

### Escritura con FileWriter y BufferedWriter

Combina FileWriter para crear/escribir en un archivo con BufferedWriter para mejorar el rendimiento usando búfer. 
Incluye métodos específicos como newLine() para saltos de línea correctos según el sistema operativo.

```java
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("archivo.txt"))) {
            bw.write("Primera línea");
            bw.newLine();
            bw.write("Segunda línea");
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
}
```

## ✏️ Escritura con PrintWriter

Utiliza PrintWriter que simplifica la escritura de texto formateado, ofreciendo métodos como **println()** similares a los usados en consola. 
Es especialmente útil para datos estructurados o cuando se necesita un formato específico.

```java
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) {
        try (PrintWriter pw = new PrintWriter("archivo.txt")) {
            pw.println("Línea 1");
            pw.println("Línea 2");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
```
---

📌 Buenas Prácticas - Punto por Punto



| #	| Categoría	         | Mala Práctica ❌	                    | Buena Práctica ✅	                          | Código Ejemplo |
|---|--------------------|----------------------------------------|---------------------------------------------|------------------------------------------------|
| 1	| Manejo de Recursos |	Cerrar manualmente, riesgo de olvido	| Usar try-with-resources                     |	try (BufferedReader br = ...) { ... }          |
| 2	| Encoding	         | Encoding por defecto del sistema	      | Especificar encoding explícito	            | StandardCharsets.UTF_8                         |
| 3	| Validación	       | Asumir que el archivo existe	          | Verificar existencia y permisos             |	archivo.exists() && archivo.canRead()          |
| 4	| Rutas	             | Rutas absolutas (no portables)	        | Usar rutas relativas cuando sea posible	    | new File("datos/archivo.txt")                  |
| 5	| Orden de Cierre	   | Cerrar en cualquier orden	            | Último en abrir, primero en cerrar	        | br.close() (cierra FileReader también)         |


| #	| Categoría	         | Mala Práctica ❌	                    | Buena Práctica ✅	                          | Código Ejemplo |
|---|--------------------|----------------------------------------|---------------------------------------------|------------------------------------------------|
| 6	| Rendimiento	       | Sin buffer para archivos grandes	      | Siempre usar buffering	                    | BufferedReader, BufferedWriter                 |
| 7	| Elección de Clase	 | Usar la misma para todo	              | Elegir según necesidad	                    | FileReader→texto, Scanner→parsing              |
| 8 | Modo Escritura	   | Siempre sobrescribir	                  | Usar append cuando corresponda              |	new FileWriter(archivo, true)                  |
| 9	| Excepciones	       | Capturar Exception genérico	          | Capturar excepciones específicas	          | catch (FileNotFoundException)                  |


| 10 | Memoria	         | Acumular todo en listas	              | Procesar línea por línea	                  | while ((linea = br.readLine()) != null)        |

| #	| Categoría	         | Mala Práctica ❌	                    | Buena Práctica ✅	                          | Código Ejemplo |
|---|--------------------|----------------------------------------|---------------------------------------------|------------------------------------------------|
| 11 | Archivos          | Grandes Buffer por defecto	            | Buffer personalizado para grandes archivos	| new char[8192] (8KB)                           |
| 12 | Testing	         | Probar solo casos normales	            | Probar casos extremos	                      | Vacío, grande, caracteres especiales           |
| 13 | Logging	         | Usar System.out.println	              | Usar sistema de logging	                    | LOGGER.info("Procesando...")                   |
| 14 | Validación        | Datos	Procesar sin validar	          | Validar datos de entrada	                  | if (linea == null || linea.trim().isEmpty())   |
| 15 | Mantenibilidad	   | Strings literales repetidos	          | Usar constantes para nombres	              | final String ARCHIVO = "datos.txt"             |

| #	| Categoría	         | Mala Práctica ❌	                    | Buena Práctica ✅	                          | Código Ejemplo |
|---|--------------------|----------------------------------------|---------------------------------------------|------------------------------------------------|
| 16 | Seguridad	       | Confiar en rutas de usuario	          | Validar rutas de entrada	                  | Verificar que no salga de directorio permitido |
| 17 | Archivos Temp	   | Dejar archivos temporales	            | Limpiar recursos temporales	                | finally { tempFile.delete() }                  |
| 18 | Documentación	   | Sin comentarios sobre formato	        | Documentar supuestos del archivo	          | Formato: nombre,edad,ciudad                    |
| 19 | Monitoreo	       | Sin control de recursos	              | Monitorear uso de memoria	                  | Runtime.getRuntime().totalMemory()             |
| 20 | Escalabilidad	   | Cargar archivos gigantes en memoria	  | Considerar alternativas	                    | Procesamiento por lotes, bases de datos        |





### Actividad

Crear un programa que lea un archivo con información de estudiantes, procese los datos y genere un nuevo archivo con información actualizada.

* Deberás crear un archivo estudiantes.txt con datos de estudiantes
* Luego leerlo, y añadir un nuevo dato después de su nota, que sea el 10% de su nota
* Guardar los resultados en un nuevo archivo estudiantes_actualizados.txt.

Archivo de entrada estudiantes.txt:
```text
Juan Pérez,Matemáticas,75
María García,Física,82
Carlos López,Química,68
Ana Martínez,Historia,91
Luis Rodríguez,Programación,88
Formato de cada línea:
Nombre,Asignatura,Nota
```

* Leer el archivo estudiantes.txt línea por línea
* Para cada estudiante, aumentar la nota en un 10%
* La nueva nota debe ser redondeada al entero más cercano
* Guardar los resultados en estudientes_actualizados.txt
* Mostrar un resumen en consola del procesamiento
