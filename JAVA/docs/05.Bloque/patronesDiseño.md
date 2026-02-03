# ⚙️ Patrones de diseño

<img src="../../img/patrones.png" width="550">

## ¿Qué es un Patrón de Diseño?

Los **patrones de diseño** son soluciones a nivel de diseño para problemas recurrentes que nosotros como ingenieros de software enfrentamos frecuentemente.
Es como una descripción sobre como `atacar` estos **problemas** y `diseñar una solución.

Usar estos patrones es considerado una **buena práctica**, ya que el diseño de la solución ha sido probado y comprobado, resulta en una legibilidad más alta en el código final. Los patrones de diseño son frecuentemente creados y usados en lenguajes de Programación Orientada a Objetos, como Java, en el cuál la mayoría de los ejemplos estarán escritos desde ahora en adelante.

---

## 🖌️Tipos de patrones de diseño

Hay cerca de 26 patrones actualmente **"descubiertos"**

Estos 26 puede ser clasificados en 3 tipos:

1. **Creacionales:** Estos patrones son diseñados para la `instanciación de clases`. Pueden ser patrones de creación tanto de clases como de objetos.
2. **Estructurales:** Estos patrones son diseñados con respecto a la `estructura y composición` de una clase. La principal meta de la mayoría de estos patrones es la de `incrementar la funcionalidad` de la(s) clase(s) involucrada(s), sin cambiar mucho de su composición.
3. **De comportamiento:** Estos patrones son diseñados dependiendo de `cómo` una clase se `comunica con otras`.

---

### 🌍 Patrones Creacionales

Estos patrones están diseñados para la **instanciación de clases**. Se enfocan en cómo crear objetos de manera `flexible`, `reutilizable` y `controlada`. 

**Patrones principales:**

  * **Singleton** - Garantiza una única instancia de una clase
  * **Factory Method** - Define una interfaz para crear objetos, pero deja que las subclases decidan qué clase instanciar
  * **Abstract Factory** - Proporciona una interfaz para crear familias de objetos relacionados
  * **Builder** - Separa la construcción de un objeto complejo de su representación
  * **Prototype** - Crea nuevos objetos copiando un objeto existente (prototipo)

*Para recordar: Creacionales = "¿Cómo CREO objetos?"*

---

### ⚒️ Patrones Estructurales

Estos patrones están diseñados con respecto a la `estructura` y `composición` de clases y objetos. Buscan aumentar la funcionalidad manteniendo una estructura flexible.

**Patrones principales:**

* **Adapter** - Permite que interfaces incompatibles trabajen juntas
* **Bridge** - Separa una abstracción de su implementación
* **Composite** - Permite tratar objetos individuales y composiciones de objetos de manera uniforme
* **Decorator** - Añade responsabilidades adicionales a un objeto dinámicamente
* **Facade** - Proporciona una interfaz simplificada a un subsistema complejo
* **Flyweight** - Minimiza el uso de memoria compartiendo tanto como sea posible
*Proxy - Proporciona un sustituto o representante de otro objeto

Para recordar: Estructurales = "¿Cómo ENSAMBLO objetos?"

### 😊 Patrones de Comportamiento

Estos patrones están diseñados según `cómo los objetos se comunican` e interactúan entre sí. Gestionan algoritmos, responsabilidades y comunicación.

**Patrones principales:**

* **Chain of Responsibility** - Permite que más de un objeto maneje una solicitud
* **Command** - Encapsula una solicitud como un objeto
* **Interpreter** - Define una representación para la gramática de un lenguaje
* **Iterator** - Proporciona una forma de acceder secuencialmente a los elementos de una colección
* **Mediator** - Define un objeto que encapsula cómo interactúan otros objetos
* **Memento** - Captura y externaliza el estado interno de un objeto
* **Observer** - Define una dependencia uno-a-muchos entre objetos
* **State** - Permite que un objeto altere su comportamiento cuando cambia su estado interno
* **Strategy** - Define una familia de algoritmos, encapsula cada uno y los hace intercambiables
* **Template Method** - Define el esqueleto de un algoritmo en una operación
* **Visitor** - Representa una operación a realizar sobre elementos de una estructura de objetos

*Para recordar: Comportamiento = "¿Cómo se COMPORTAN y COMUNICAN los objetos?"*
