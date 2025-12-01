
# 💻 ¿Qué es una API REST?
Una `API REST` es una forma de comunicar aplicaciones entre sí usando **HTTP** (el mismo protocolo que usa tu navegador). 

Permite que un cliente (una web, app móvil, programa…):
- Pueda `pedir` datos. 
- `Enviar` información a un servidor siguiendo unas reglas estándar.
  
---

### ↔️ REST = Representational State Transfer
Es un estilo de arquitectura basado en estos principios:

- **Cliente–Servidor**: 
    El cliente pide datos → el servidor responde.

- **Sin estado (stateless)**: 
    Cada petición contiene toda la información necesaria. El servidor no recuerda peticiones anteriores.

- **Uso de HTTP y sus métodos**: GET, POST, PUT, PATCH, DELETE.

- **Recursos**: Todo se trata como un recurso (usuarios, pedidos, productos…).

<img src="../../img/apiRest1.png" alt="API_REST" width="600" />
---

### ⏩ Comunicación Dominio y Endpoints

Para que una API pueda ser consultada necesita:

1. Un  `dominio`, que es un lugar donde va a recibir las peticiones. (Servidor)
   
2. Unos `endpoints`, que son los caminos específicos donde se piden los datos o se realizan acciones.

Así, la estructura siempre es:

- **DOMINIO** → dónde se envía la petición http://localhost:8080

- **ENDPOINT** → qué se solicita dentro del servidor http://localhost:8080/usuarios/3
--- 
### ENDPOINTS

Son los caminos específicos donde se piden los datos o se realizan acciones:

- **Colección**: Representan el conjunto completo de un tipo de recurso.
  - `/usuarios`, `/productos`, `/pedidos`
  
- **Elemento**: Permite acceder a un recurso concreto identificado de forma única, normalmente con un `ID`.
  - `/pedidos/5`
  
- **Sub-colecciones**: Representan recursos relacionados con un elemento concreto.
  
  - `/pedidos/20/articulos/5` -> *Artículo 5 del pedido 20* 
  
  --- 

### El diseño REST es clave por varias razones:

#### 1. Acceso a todos los elementos

El endpoint de colección permite obtener la lista completa de un recurso.

Ejemplo:
GET /usuarios devuelve todos los usuarios registrados.

Esto es esencial para:

Mostrar tablas o listados en la interfaz.

Hacer búsquedas y filtros.

Obtener datos para dropdowns o selects.

2. Es el lugar donde se crean nuevos recursos

REST define que los nuevos elementos se crean haciendo un POST sobre la colección.

Ejemplo:
POST /usuarios crea un usuario nuevo dentro de esa colección.

Esto:

Mantiene la API ordenada.

Evita rutas confusas como /crearUsuario.

Asegura un diseño estándar y predecible.

3. Homogeneidad y claridad en el diseño

Los endpoints de colección aseguran un diseño coherente, donde siempre sabes:

/recurso → conjunto

/recurso/{id} → elemento

Esta estructura consistente:

Facilita el aprendizaje.

Reduce errores del cliente (frontend o apps).

Permite a herramientas automáticas generar documentación o SDKs.

4. Permiten operaciones globales

En /usuarios puedes permitir:

filtros: /usuarios?rol=admin

paginación: /usuarios?page=2

búsquedas: /usuarios?nombre=ana

Esto evita sobrecargar los endpoints individuales.

5. Escalabilidad y mantenimiento

Diseñar correctamente las colecciones facilita:

Extender la API sin romper nada.

Añadir nuevos métodos o parámetros.

Integrar nuevas aplicaciones cliente.

Ejemplo: si mañana necesitas filtrar por estado:
GET /pedidos?estado=pendiente

No necesitas nuevos endpoints.
