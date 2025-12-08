# Conectar a POSTGRE

**1.**  Creamos un proyecto desde intellij con `Maven`. 
**2.**  Deberemos tener una base de datos con una tabla de `Usuario`.
**3.**  Tendremos un archivo `Main` que va a ejecutar la traida de todos los Usuario.
**4.**  Crearemos el archivo `Usuario` donde estará el CRUD de traer los datos de la base de datos.
**5.**  Crearemos un archivo donde se realiza la connexión a la base de datos Postgre

---

**Usuario.java**
```java
package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Usuario {
    public void listarUsuarios() {

        // Definimos la consulta SQL que queremos ejecutar sobre la base de datos.
        String sql = "SELECT id, nombre FROM usuarios";

        // try-with-resources: abre los recursos y los cierra automáticamente al terminar.
        // Establece la conexión con la base de datos usando nuestra clase ConnectionBBDD.
        try (Connection conn = ConnectionBBDD.getConnection();
             // Prepara la sentencia SQL para evitar errores y ataques (SQL Injection).
             PreparedStatement stmt = conn.prepareStatement(sql);
             // Ejecuta la consulta y guarda los resultados en un ResultSet.
             ResultSet rs = stmt.executeQuery()) {

            // Itera por cada fila devuelta por la consulta.
            while (rs.next()) {
                // Obtiene los datos de cada columna ("id" y "nombre") y los imprime por consola.
                System.out.println(rs.getInt("id") + " - " + rs.getString("nombre"));
            }

        } catch (Exception e) {
            // Si ocurre cualquier error (conexión, SQL, lectura), se imprime la traza para depurar.
            e.printStackTrace();
        }
    }


    public boolean findByName(String nombreBuscado) {
    boolean found = true;
        String sql = "SELECT id, nombre FROM usuarios WHERE nombre = ?";

        try (Connection conn = ConnectionBBDD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Sustituye el ? por el nombre que queremos buscar.
            stmt.setString(1, nombreBuscado);

            // Ejecuta la consulta SELECT.
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                // Si existe al menos un usuario con ese nombre...
                System.out.println("Ya existe un nombre en la Base de datos pon otro");
            } else {
                System.out.println("No existe ningún usuario con el nombre: " + nombreBuscado);
                found = false;

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return found;
    }

    public void insertarUsuario(String nombre) {
        String sql = "INSERT INTO usuarios (nombre) VALUES (?)";
        boolean found = findByName(nombre);
        if (!found){
            try (Connection conn = ConnectionBBDD.getConnection();
                 PreparedStatement stmt = conn.prepareStatement(sql)) {

                stmt.setString(1, nombre);
                stmt.executeUpdate();

                System.out.println("Usuario insertado: " + nombre);
                listarUsuarios();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void deleteByName(String nombre) {

        String sql = "DELETE FROM usuarios WHERE nombre = ?";

        try (Connection conn = ConnectionBBDD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Sustituye el ? por el nombre del usuario a borrar.
            stmt.setString(1, nombre);

            // Ejecuta el DELETE y devuelve cuántas filas se eliminaron.
            int filas = stmt.executeUpdate();

            if (filas > 0) {
                System.out.println("Usuario eliminado: " + nombre);
                listarUsuarios();
            } else {
                System.out.println("No existe ningún usuario con el nombre: " + nombre);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void actualizarUsuario(String nombreActual, String nombreNuevo) {

        String sql = "UPDATE usuarios SET nombre = ? WHERE nombre = ?";

        try (Connection conn = ConnectionBBDD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nombreNuevo);   // Nuevo nombre
            stmt.setString(2, nombreActual);  // Nombre que buscamos para actualizar

            int filas = stmt.executeUpdate(); // Ejecuta el UPDATE

            if (filas > 0) {
                System.out.println("Nombre actualizado de '" + nombreActual + "' a '" + nombreNuevo + "'.");
                listarUsuarios();
            } else {
                System.out.println("No existe ningún usuario con el nombre: " + nombreActual);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```
**ConnectionBBDD.java**

```java
package org.example;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionBBDD {
    // Se guardan las credenciales de la Base de Datos
    private static final String URL = "jdbc:postgresql://localhost:5432/testDB";
    private static final String USER = "postgres";
    private static final String PASSWORD = "root";

    // Método donde se realiza la conexión a la Base de Datos
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            throw new RuntimeException("Error conectando a PostgreSQL", e);
        }
    }
}
```

**Main.java:**

```java
package org.example;

public class Main {
    static void main() {
        try {
            ConnectionBBDD.getConnection();
            System.out.println("Conexión correcta a PostgreSQL.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        Usuario usuario = new Usuario();

        // Llama a la función para traer los usuarios
        usuario.listarUsuarios();
        // Creamos un objeto Usuario para usar sus métodos.
        usuario.insertarUsuario("Juan");
        // llama al metodo borrar por nombre
        usuario.deleteByName("Ana"); // Comentarlo cuando quieras probar el update o buscar otro nombre
        // Actualizar Usuario
        usuario.actualizarUsuario("Juan","JOHN");

    }
}

```

**Consola:**

```console
Conexión correcta a PostgreSQL.
1 - Ana
2 - Carlos
3 - María
4 - Luis
```


