# 📜 Resumen: Clases en Java

Una **clase** es el modelo o plantilla que se usa para crear objetos.  
Define **atributos** (datos) y **métodos** (acciones).  
Es un concepto clave de la Programación Orientada a Objetos (POO).
Por cada clase creada será un archivo (recomendable)

---

# 🔨 1. ¿Qué es una clase?

- Es una **estructura** que describe cómo serán los objetos.
- Cada objeto creado a partir de una clase se llama **instancia**.

### Ejemplo básico
```
[Modificador de acceso] [tipo] [identificador/nombre de la clase]{
    Atributos
    [Modificador de acceso] [tipo] [identificador]

    Constructor                               (Argumentos)
    [tipo] [identificador/nombre del Contructor]([Tipo][nombre del argumento]){
        this.[nombre de atributo] = [nombre del argumento]
    }

    Métodos
    [Modificador de acceso] [tipo] [identificador/nombre de la clase]
}
```
```java
// Crear Clase:
//  [Modificador de acceso] [tipo] [identificador/nombre de la clase] {
public class Persona {
    // Atributos:

    //[Modificador de acceso] [tipo] [identificador]
    private String nombre;   // atributo
    private int edad;        // atributo

//  Constructor:

//  [tipo] [identificador/nombre del Contructor]([Tipo][nombre del argumento])
    class Persona(String nombre, int edad){
        this.nombre = nombre;
        this.edad = edad;
    }

//  Método:

//  [Modificador de acceso] [tipo] [identificador/nombre del método]([Tipo][nombre del argumento]){
    public void saludar() {   
        System.out.println("Hola, soy " + nombre);
    }
}
```

## 📄 Clase Main

La clase `Main` es la clase donde arranque o decimos que arranque el programa.
Hay una línea de código que le dice al compilador donde debe fijarse y es:

```java
public class Main{
    // Esta líne es donde arranca y se llama línea de la lógica
    public static void main(String[] args){
 // Código
    }
}
```

##  🔨 Creación del Objeto Persona en Main
Desde la Clase Main se le llama a la clase Persona y se le instancia. Pasa de clase a objeto.
- Persona.java (archivo)
```java
public class Persona {
     
    public String nombre;   
    public int edad;        

    class Persona(String nombre, int edad){
        this.nombre = nombre;
        this.edad = edad;
    }

    // Recomendable poner constructor vacio
    class Persona(){}

    public void mostrarInformacion() {
        System.out.println("Nombre: " + nombre + ", Edad: " + edad);
        direccion.mostrarDireccion(); 
    }
}
```
- 📄 Main.java (archivo)
```java
public class Main{
    public static void main(String[] args){
        // Instanciar Persona
        Persona persona1 = new Persona("Sergio", 25);
        Persona persona2 = new Persona("Ana", 35);

        // Mostrar información
        persona1.mostrarInformacion();
        // Mostrar información
        persona2.mostrarInformacion();

        // Instanciar Persona
        Persona p = new Persona();
        //Asignar valores (Es posible al tenerlos en public)
        p.nombre = "Ana";
        p.edad = 25;
        // Mostrar información
        p.mostrarInformacion();
    }
}
```
# 2. 🔨 Modificadores de acceso (resumen)

`public` Accesible desde **cualquier lugar**.

`private` Solo accesible **dentro de la misma clase**.

`protected` Accesible desde: 

- La `misma clase` 
- El mismo `paquete` 
- `Subclases` (herencia)

`default` (sin poner nada) Accesible solo dentro del **mismo paquete**.

# 3. Encapsular Getters y Setters

Se usa `private` en los atributos para proteger datos y se crearán métodos como los `getters/setters` para acceder a ellos.

```java
public class Persona {
     
    private String nombre;   
    private int edad;        

    class Persona(String nombre, int edad){
        this.nombre = nombre;
        this.edad = edad;
    }
    
    class Persona(){}

    // GETTERS Y SETTERS

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }


    public void mostrarInformacion() {
        System.out.println("Nombre: " + nombre + ", Edad: " + edad);
        direccion.mostrarDireccion(); 
    }
}
```
