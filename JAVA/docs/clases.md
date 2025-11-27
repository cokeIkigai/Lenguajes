# 📋 Resumen: Clases en Java

Una **clase** es el modelo o plantilla que se usa para crear objetos.  
Define **atributos** (datos) y **métodos** (acciones).  
Es un concepto clave de la Programación Orientada a Objetos (POO).
Por cada clase creada será un archivo (recomendable)

---

# 📁 1. ¿Qué es una clase?

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
