
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
### 🔛 ENDPOINTS

Son los caminos específicos donde se piden los datos o se realizan acciones:

- **Colección**: Representan el conjunto completo de un tipo de recurso.
  - `/usuarios`, `/productos`, `/pedidos`
  
- **Elemento**: Permite acceder a un recurso concreto identificado de forma única, normalmente con un `ID`.
  - `/pedidos/5`
  
- **Sub-colecciones**: Representan recursos relacionados con un elemento concreto.
  
  - `/pedidos/20/articulos/5` -> *Artículo 5 del pedido 20* 
  
  --- 

### ❗El diseño REST es clave 

REST define funciones claras para cada método HTTP dentro de esta colección.
| Método     | Uso en la colección                                              | Ejemplo 
| ---------- | --- | ------------------ | 
| **GET** | Obtener todos los elementos | `GET /usuarios` | Lista completa del recurso  |
| **POST**   | Crear un nuevo elemento  | `POST /usuarios`| Inserta un nuevo usuario en la colección |
| **PUT**    | Reemplazar toda la colección | `PUT /usuarios`| Rara vez usado, no práctico              |
| **PATCH**  | Actualizar parcialmente toda la colección | `PATCH /usuarios`  | Inusual                                  |
| **DELETE** | Borrar toda la colección                  | `DELETE /usuarios` | Muy raro y peligroso  |

--- 

**GET y POST** son los métodos principales en una colección.

**PUT, PATCH, DELETE** se usan sobre elementos, no sobre colecciones.

---

#### GET — Obtener datos 📥

El método `GET` en un endpoint de colección sirve para leer todos los elementos de un recurso.

No modifica nada, solo `consulta` información.

Similar a un `SELECT *` en bases de datos.

*Ejemplos:* /usuarios, /productos, /pedidos

🔎 **Características:**

- Devuelve todos los registros.

- Permite filtros, búsquedas, ordenaciones y paginación.

- Solo lectura, sin cambios en el sistema.

*Ejemplo con filtros:* /usuarios?rol=admin&page=2


📄 **Usos comunes:**

- Mostrar tablas o listados completos.

- Cargar dropdowns o selects.

- Buscar usuarios, productos o pedidos.

- Cargar datos iniciales en pantallas.

- Actualizar componentes visuales.

---

#### POST — Crear nuevos elementos ✨

`POST` se usa en un endpoint de colección para crear un recurso nuevo.

`Envía` datos desde el cliente hacia el servidor.

*Ejemplo:* POST /usuarios

🔎 **Características:**

- `Inserta` un nuevo elemento en la colección.

- `Evitar` rutas como /crearUsuario.


📝 **Usos comunes:**

- `Registrar` nuevos usuarios.

- `Añadir` productos.

- `Crear` pedidos.

- `Enviar` formularios desde un frontend.

- `Generar` nuevos elementos desde la aplicación.

#### 🔄 PUT — Reemplazar un elemento completo 

`PUT` se utiliza para `actualizar` por completo un recurso existente.

Debe enviarse `toda` la información del elemento, no solo una parte.

*Ejemplo:* PUT /usuarios/5

🔎 **Características:**

- `Reemplaza` por completo el recurso.

- Si faltan campos, se pueden `sobrescribir` con valores vacíos.

- Se usa `sobre elementos`, no sobre colecciones.

📝 **Usos comunes:**

- `Actualizar` totalmente un registro.

- Guardar datos `completos` de un formulario.

- `Sustituir` un elemento antiguo por uno nuevo.
  
---

#### PATCH — Actualizar parcialmente ✂️

`PATCH` permite `modificar` solo los campos necesarios de un elemento.

Ideal para `actualizaciones` pequeñas.

*Ejemplo:* PATCH /usuarios/5

🔎 **Características:**

- `Cambia` únicamente los campos enviados.

- No altera el resto de datos del recurso.

- Se usa siempre sobre un `elemento`, nunca sobre colecciones.

📝**Usos comunes:**

- Cambiar solo el `email` o la `contraseña`.

- Actualizar el `estado` de un pedido.

- Ajustar pequeñas `partes` de un recurso.

#### DELETE — Eliminar un elemento ❌

`DELETE` elimina un recurso concreto.

Una vez eliminado, no debería seguir existiendo en la colección.

*Ejemplo:* DELETE /usuarios/5

🔎 **Características:**

- `Borra` el elemento indicado.

- Acción `definitiva` (no reversible).

- Siempre sobre `elementos` , no sobre colecciones.

**Usos comunes:**

- `Borrar` usuarios o productos.

- `Cancelar` pedidos.

- `Limpiar` datos del sistema.

