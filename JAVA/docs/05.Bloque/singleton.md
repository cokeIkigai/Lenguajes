# 🙎‍♂️Singleton

## ❔ ¿Qué es Singleton?

Singleton es un **patrón de diseño** que garantiza que una clase tenga SOLO UNA instancia (objeto) y proporciona un punto de acceso global a ella.

## ¿Para qué sirve?
Imagina que estás programando una aplicación y necesitas:

* Configuración global (idioma, tema oscuro/claro)
* Conexión a base de datos (una sola conexión compartida)
* Sistema de logging (registro de eventos)
* Gestor de caché (almacén temporal de datos)
  
---

```java

// Con final se evita que alguien herede y rompa el patrón.
public final class ClassSingleton {

    // Se comparte entre todas las instancias (en este caso, solo habrá una) mayúsculas
    private static ClassSingleton INSTANCE;

    private String info = "Initial info class";

    // Al ser privado, nadie fuera de esta clase puede hacer: new ClassSingleton()
    private ClassSingleton() {        
    }

    public static ClassSingleton getInstance() {
        
        if(INSTANCE == null) {
            
            INSTANCE = new ClassSingleton(); //--> Solo se ejecuta UNA VEZ en toda la vida del programa
        }

        // Siempre devuelve la MISMA instancia: La 1º vez: la recién creada y Las siguientes veces: la misma de antes
        return INSTANCE;
    }

    // getters and setters
  
}
```

**Sin Singleton:**

```java
public final class DirectorColegio {
    
    // El ÚNICO director (variable static)
    private static DirectorColegio directorUnico;
    
    // Datos del director
    private String nombre;
    private int anosExperiencia;
    private String telefono;
    
    // Constructor PRIVADO: ¡Solo se puede crear desde dentro!
    private DirectorColegio() {
        this.nombre = "Don Carlos";
        this.anosExperiencia = 15;
        this.telefono = "601234567";
    }
    
    // Método para conseguir al director
    public static DirectorColegio getDirector() {
        // Si todavía no hay director...
        if (directorUnico == null) {
            // ...lo nombramos (creamos la instancia)
            directorUnico = new DirectorColegio();
        }
        // Siempre devolvemos al MISMO director
        return directorUnico;
    }
    
    // Métodos para trabajar con el director
    // GETTERS Y SETTERS
}
```

--- 

### PROS y CONTRAS

✅ VENTAJAS (PROS):

| **Ventaja**| **Explicación** |
|------------|-----------------|
| Control estricto | Garantiza que solo haya una instancia |
| Acceso global	Fácil acceso desde cualquier parte del código |
| Ahorro de memoria	Reutiliza la misma instancia en vez de crear nuevas |
| Consistencia	Todos usan los mismos datos/configuraciones |

❌ DESVENTAJAS (CONTRAS):

| **Ventaja**|	**Explicación** |
|------------|------------------|
| Dificulta testing |	Las pruebas unitarias se complican |
| Oculta dependencias |	No es claro qué clases usan el Singleton |
| Problemas con hilos | 	En programas multihilo, puede causar errores |
| "Code smell" |	Muchos desarrolladores lo consideran mala práctica si se usa mal |
