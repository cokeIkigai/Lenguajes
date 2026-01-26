# 📚  Colecciones

🎯 ¿Qué son las Colecciones?
Las colecciones son estructuras especializadas que permiten almacenar, organizar y manipular grupos de objetos de manera eficiente. ¡Imagínalas como contenedores inteligentes para tus datos! 

Java nos ofrece una biblioteca completa en el paquete java.util que incluye todas las herramientas necesarias para trabajar con datos agrupados.

---

## 🌈 Tipos de Colecciones Disponibles

### 📋 List, LinkedList (Listas) - Como tu playlist favorita 🎵

- Mantienen el orden de inserción

- Permiten elementos duplicados

- Acceso por posición/index
- 
---

### LIST

Cuando necesitas acceso frecuente por posición

```java
import java.util.*;
public class ArrayListDemo {
    public static void main(String[] args) {
        
        // Crear lista
        List<String> lista = new ArrayList<>();
        
        // AGREGAR 
        lista.add("Manzana"); // posición 0
        lista.add("Banana");  // posición 1
        lista.add("Naranja"); // posición 2
        
        // ACCEDER por índice (MUY RÁPIDO)
        System.out.println("Elemento en posición 1: " + lista.get(1)); // Banana
    
        // RECORRER
        for (String fruta : lista) {
            System.out.println("- " + fruta);
        }
        // ELIMINAR por índice
        lista.remove(0); // Elimina "Manzana"
    }
}
```
---

### LinkedList

Cuando agregas/eliminas mucho en medio de la lista

```java
import java.util.*;
public class EjemploLinkedList {
    public static void main(String[] args) {
    
        LinkedList<String> linkedList = new LinkedList<>();
        
        // Uso métodos de List
        linkedList.add("A");
        linkedList.add("B");
        lista.add("H");
        lista.add(2, "C"); // Eficiente en LinkedList
        
        // Métodos ESPECÍFICOS de LinkedList
        linkedList.addFirst("Inicio");  // Solo en LinkedList
        linkedList.addLast("Fin");      // Solo en LinkedList
        
        // OBTENER primero/último
        System.out.println("Primero: " + lista.getFirst());
        System.out.println("Último: " + lista.getLast());

        // ELIMINAR primero/último (RÁPIDO)
        lista.removeFirst();
        lista.removeLast();
        
        // NO se puede cambiar fácilmente a otra implementación
        // ERROR de compilación
        // linkedList = new ArrayList<>(); 
    }
}
```

---

### 🎯 Sets (Conjuntos) - Como una lista de invitados únicos.

- HashSet, TreeSet
- NO permiten duplicados
- Garantizan unicidad de elementos
- Ideal para eliminar repetidos

---

### HashSet 

- Para verificación rápida de existencia
- Cuando necesitas saber rápido si algo existe, sin duplicados

```java
import java.util.*;
public class HashSetDemo {
    public static void main(String[] args) {
        // Crear conjunto
        Set<String> emails = new HashSet<>();
        
        // AGREGAR (ignora duplicados automáticamente)
        emails.add("ana@email.com");
        emails.add("pedro@email.com");
        emails.add("ana@email.com"); // NO se agrega
        
        // VERIFICAR existencia (SUPER RÁPIDO)
        System.out.println("¿Existe ana@email.com? " + emails.contains("ana@email.com")); // true
        
        // TAMAÑO (sin duplicados)
        System.out.println("Usuarios únicos: " + emails.size()); // 2
        
        // ELIMINAR
        emails.remove("pedro@email.com");
    }
}
```

--- 

### TreeSet 

- Para conjunto ordenado automáticamente
- Cuando necesitas elementos únicos Y ordenados
  
```java
import java.util.*;
public class TreeSetDemo {
    public static void main(String[] args) {
        // Crear conjunto ordenado
        Set<String> nombres = new TreeSet<>();
        
        // AGREGAR (se ordenan automáticamente)
        nombres.add("Carlos");
        nombres.add("Ana");
        nombres.add("Pedro");
        nombres.add("Ana"); //  Duplicado
        
        // ¡Se ordenan alfabéticamente solo!
        System.out.println("Nombres ordenados: " + nombres);
        // [Ana, Carlos, Pedro]
        
        // PRIMERO y ÚLTIMO
        TreeSet<Integer> numeros = new TreeSet<>();
        numeros.add(5);
        numeros.add(1);
        numeros.add(10);
        
        System.out.println("Menor: " + numeros.first()); // 1
        System.out.println("Mayor: " + numeros.last());  // 10
    }
}
```

### 🎪 Colas (Queues) - Como la fila del supermercado 🛒

- Comportamiento FIFO (First-In, First-Out)
- Perfectas para procesamiento por orden de llegada
- Cuando procesas elementos en orden de llegada (primero en entrar, primero en salir)

### Queue

```java 
import java.util.*;
public class QueueDemo {
    public static void main(String[] args) {
        // Crear cola
        Queue<String> cola = new LinkedList<>();
        
        // AGREGAR al final
        cola.add("Cliente 1");
        cola.add("Cliente 2");
        cola.add("Cliente 3");
        
        System.out.println("Cola: " + cola);
        
        // ATENDER (sacar el primero)
        String atendido = cola.poll(); // Saca "Cliente 1"
        System.out.println("Atendiendo: " + atendido);
        
        // VER siguiente sin sacar
        String siguiente = cola.peek();
        System.out.println("Siguiente: " + siguiente);
    }
}
``` 

### PriorityQueue

Para procesamiento por prioridad

```java
// 🎯 USO: Cuando procesas elementos por importancia/prioridad
import java.util.*;

public class PriorityQueueDemo {
    public static void main(String[] args) {
        // Crear cola de prioridad (menor número = mayor prioridad)
        PriorityQueue<Integer> emergencias = new PriorityQueue<>();
        
        // AGREGAR con prioridad
        emergencias.add(3); // Prioridad baja
        emergencias.add(1); // Prioridad ALTA
        emergencias.add(2); // Prioridad media
        
        // ATENDER por prioridad (siempre el menor primero)
        System.out.println("Atendiendo emergencias por prioridad:");
        while (!emergencias.isEmpty()) {
            System.out.println("Atendiendo prioridad: " + emergencias.poll());
        }
    }
}
```

### 🗺️ Mapas (Maps) - Como un diccionario 📖

- Pares clave-valor

- Acceso rápido por clave única

- ¡NO son técnicamente "colecciones" pero son fundamentales!

--- 

**HashMap:** 

- Para búsqueda rápida por clave.
- Cuando necesitas buscar/almacenar valores por una clave única
  
```java

import java.util.*;
public class HashMapDemo {
    public static void main(String[] args) {
        // Crear mapa clave-valor
        Map<String, Integer> edades = new HashMap<>();
        
        // AGREGAR
        edades.put("Ana", 25);
        edades.put("Pedro", 30);
        edades.put("Luis", 28);
        
        // BUSCAR por clave (SUPER RÁPIDO)
        Integer edadAna = edades.get("Ana");
        System.out.println("Edad de Ana: " + edadAna);
        
        // VERIFICAR si clave existe
        System.out.println("¿Existe Pedro? " + edades.containsKey("Pedro"));
        
        // RECORRER
        for (Map.Entry<String, Integer> entry : edades.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
```

---

### TreeMap

- Para mapa ordenado por clave.
- Cuando necesitas clave-valor ordenado por clave.

```java
import java.util.*;
public class TreeMapDemo {
    public static void main(String[] args) {
        // Crear mapa ordenado
        Map<String, String> diccionario = new TreeMap<>();
        
        // AGREGAR (se ordenan por clave automáticamente)
        diccionario.put("zorro", "animal");
        diccionario.put("apple", "fruta");
        diccionario.put("ball", "objeto");
        
        // ¡Se ordenan alfabéticamente por clave!
        System.out.println("Diccionario ordenado:");
        diccionario.forEach((k, v) -> System.out.println(k + " -> " + v));
        // apple -> fruta, ball -> objeto, zorro -> animal
    }
}
```

### Stack

- Para LIFO (último en entrar, primero en salir)
- Cuando necesitas comportamiento de pila (historial, deshacer)

```java

import java.util.*;
public class StackDemo {
    public static void main(String[] args) {
        // Crear pila
        Stack<String> historial = new Stack<>();
        
        // APILAR (push)
        historial.push("Página 1");
        historial.push("Página 2");
        historial.push("Página 3");
        
        System.out.println("Pila: " + historial);
        
        // DESAPILAR (pop) - saca el último que entró
        String ultimo = historial.pop(); // Saca "Página 3"
        System.out.println("Desapilando: " + ultimo);
        
        // VER tope sin sacar
        String tope = historial.peek();
        System.out.println("Tope actual: " + tope);
    }
}
```

## 📊 Colecciones Java - Guía Rápida

| Colección | Para usarla cuando... | Operación Rápida | Ejemplo Real |
|-----------|----------------------|------------------|--------------|
| **ArrayList** | Accedes mucho por índice | `get(index)` | Lista de estudiantes por número |
| **LinkedList** | Insertas/eliminas mucho en medio | `add(index, element)` | Lista de reproducción que editas |
| **HashSet** | Necesitas verificar existencia rápido | `contains(element)` | Verificar si usuario ya existe |
| **TreeSet** | Necesitas elementos únicos y ordenados | `first()`, `last()` | Ranking ordenado |
| **Queue** | Procesas en orden de llegada (FIFO) | `poll()`, `peek()` | Fila de atención |
| **PriorityQueue** | Procesas por importancia | `poll()` | Sala de emergencias |
| **HashMap** | Buscas valores por clave rápido | `get(key)` | Diccionario búsqueda rápida |
| **TreeMap** | Necesitas claves ordenadas | Navegación ordenada | Directorio telefónico ordenado |
| **Stack** | Sigues orden LIFO | `pop()`, `push()` | Historial navegación (atrás) |
