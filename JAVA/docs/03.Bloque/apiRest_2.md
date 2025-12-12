# ¿Qué hace Spring Boot?

🍃 [Spring Boot](https://spring.io/quickstart) es un `framework` que te permite crear aplicaciones backend de forma rápida, sencilla y estructurada.

Su objetivo principal es `ahorrar` configuración, `arrancar` un servidor automáticamente y permitir `crear` **APIs REST** sin complicaciones.

**¿Qué hace Spring Boot exactamente?**

`Levanta` un servidor web automáticamente
al ejecutar tu aplicación, Spring Boot inicia un servidor embebido accesible en:

    *http://localhost:8080*


⚠️*No necesitas instalar servidores externos.*

- `Gestiona` peticiones HTTP
  
- `Recibe`: GET, POST, PUT, PATCH, DELETE
Y las `asocia` a los métodos que tú defines en tus *Controllers*.

- `Conecta` con bases de datos fácilmente
*Mediante Spring Data JPA* puedes conectarte a MySQL, PostgreSQL, H2, etc...sin escribir SQL para lo básico.

- `Configura` automáticamente lo necesario


--- 

### 🔰 Estructurar la API por capas

🌐 **Controller**: Recibe las `peticiones` del cliente (GET, POST, PUT…) y devuelve las respuestas.

⚙️ **Service**: Contiene la `lógica` de negocio: qué debe hacerse con los datos y cómo.

📚 **Repository**: Se encarga de `acceder` a la base de datos (guardar, buscar, borrar, actualizar).

🗄️ **Entity**: Representa una `tabla` de la base de datos y define la estructura de los datos.

---

### 🗄️ Entity (Entities)
Una Entity es una `clase` Java que representa una `tabla` de la base de datos.

Cada `atributo` de la clase representa un campo de la columna de la base de datos.

```java
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String email;

    // GETTERS Y SETTERS
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; } 
}

```
- Cuando Spring Boot convierte tu `entity a JSON` para enviarla al cliente, usa los getters para obtener los valores de cada campo.
  
---

### Relaciones entre tablas
**Uno a Uno**
```java
@Entity
@Table(name = "users")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    //... 

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    // ... getters and setters
}
```

**Uno a Muchos (1:N)**
```java
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    // Un usuario tiene muchas direcciones
    @OneToMany(mappedBy = "usuario")
    private List<Direccion> direcciones;
    // getters y setters...
}
```

**Muchos a uno (N:1)**
```java
@Entity
public class Direccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String calle;
    private String ciudad;
    // Muchas direcciones pertenecen a un usuario
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    // getters y setters...
}
```

**Muchos a Muchos (N:M)**
```java
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    
    @ManyToMany
    @JoinTable(
        name = "usuario_rol",
        joinColumns = @JoinColumn(name = "usuario_id"),
        inverseJoinColumns = @JoinColumn(name = "rol_id")
    )
    private Set<Rol> roles;
}
```
```java
@Entity
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
}
``` 

### 🌐 Controller

#### UsuarioController
```java
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<Usuario> getAll() {
        return usuarioService.getAll();
    }

    @GetMapping("/{id}")
    public Usuario getById(@PathVariable Long id) {
        return usuarioService.getById(id);
    }

    @PostMapping
    public Usuario create(@RequestBody Usuario usuario) {
        return usuarioService.create(usuario);
    }

    @PutMapping("/{id}")
    public Usuario update(@PathVariable Long id, @RequestBody Usuario usuario) {
        return usuarioService.update(id, usuario);
    }

    @PatchMapping("/{id}")
    public Usuario patch(@PathVariable Long id, @RequestBody Map<String, Object> cambios) {
        return usuarioService.patch(id, cambios);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        usuarioService.delete(id);
    }
}

```

### ⚙️ Service

Controla la lógica, en caso de que se necesite más complejidad.

```java
@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    // Inyección de dependencias
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    // Obtener todos los usuarios
    public List<Usuario> getAll() {
        return usuarioRepository.findAll();
    }

    // Obtener un usuario por ID
    public Usuario getById(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    // Crear usuario
    public Usuario create(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    // Actualizar completo (PUT)
    public Usuario update(Long id, Usuario datosNuevos) {
        Usuario usuario = getById(id);

        usuario.setNombre(datosNuevos.getNombre());
        usuario.setEmail(datosNuevos.getEmail());
        usuario.setRoles(datosNuevos.getRoles());

        return usuarioRepository.save(usuario);
    }

    // Actualizar parcial (PATCH)
    public Usuario patch(Long id, Map<String, Object> cambios) {
        Usuario usuario = getById(id);

        if (cambios.containsKey("nombre")) {
            usuario.setNombre((String) cambios.get("nombre"));
        }

        if (cambios.containsKey("email")) {
            usuario.setEmail((String) cambios.get("email"));
        }

        if (cambios.containsKey("roles")) {
            @SuppressWarnings("unchecked")
            Set<Rol> nuevosRoles = (Set<Rol>) cambios.get("roles");
            usuario.setRoles(nuevosRoles);
        }

        return usuarioRepository.save(usuario);
    }

    // Eliminar usuario
    public void delete(Long id) {
        usuarioRepository.deleteById(id);
    }
}
```


### 📚 Repository


```java
// Indica que esta interfaz es un repositorio JPA
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // Al extender JpaRepository, Spring crea automáticamente:
    // - findAll()      → obtener todos los usuarios
    // - findById(id)   → obtener un usuario por ID
    // - save(usuario)  → crear o actualizar un usuario
    // - deleteById(id) → borrar un usuario
    // No es necesario escribir código adicional para CRUD básico.

    // CRUD NO BÁSICOS

    // Buscar por nombre exacto
    List<Usuario> findByNombre(String nombre);

    // Buscar por email
    Optional<Usuario> findByEmail(String email);

    // Buscar por coincidencia parcial
    List<Usuario> findByNombreContaining(String texto);

    // Buscar por rol
    List<Usuario> findByRolesNombre(String nombreRol);
   
    // BÚSQUEDA SQL NATIVAS
    @Query("""
    SELECT u 
    FROM Usuario u 
    WHERE SIZE(u.roles) > :minRoles
    """)
    List<Usuario> usuariosConMasDeRoles(@Param("minRoles") int minRoles);
}
```

### 🔥 Consulas que se pueden hacer en un repository 
```java
// BÚSQUEDAS BÁSICAS
findByNombre(String nombre)
findByEmail(String email)
findById(Long id)

// COMPARADORES (>, <, BETWEEN...)
findByEdadGreaterThan(int edad)        // >
findByEdadLessThan(int edad)           // <
findByEdadGreaterThanEqual(int edad)   // >=
findByEdadLessThanEqual(int edad)      // <=
findByEdadBetween(int e1, int e2)      // BETWEEN e1 AND e2

//COINCIDENCIAS PARCIALES (LIKE)
findByNombreContaining(String txt)     // LIKE %txt%
findByNombreStartsWith(String txt)     // LIKE txt%
findByNombreEndsWith(String txt)       // LIKE %txt
findByNombreNotContaining(String txt)

//BOOLEANOS
findByActivoTrue()
findByActivoFalse()

//NULOS Y NO NULOS
findByEmailIsNull()
findByEmailIsNotNull()

//ORDENACIÓN
findByNombreOrderByEdadAsc(String nombre)
findByNombreOrderByEdadDesc(String nombre)

//FILTROS CON LISTAS / IN
findByIdIn(List<Long> ids)

//JOINS AUTOMÁTICOS (RELACIONES)
//ManyToMany:
findByRolesNombre(String nombreRol)
//OneToMany / ManyToOne:
findByDireccionesCiudad(String ciudad)
findByPedidosEstado(String estado)

//VALORES DISTINTOS
findDistinctByNombre(String nombre)

//CONDICIONES AND / OR
findByNombreAndEmail(String nombre, String email)
findByNombreOrEmail(String nombre, String email)

//NEGACIONES
findByNombreNot(String nombre)
findByEdadNot(int edad)

//FECHAS
findByFechaAfter(LocalDate fecha)
findByFechaBefore(LocalDate fecha)
findByFechaBetween(LocalDate f1, LocalDate f2)

//CONSULTAS COMBINADAS
findByNombreContainingAndActivoTrue(String nombre)
findByEdadGreaterThanAndCiudad(int edad, String ciudad)
findByNombreStartingWithOrEmailEndingWith(String n, String e)

//CONTADORES
countByActivoTrue()
countByRolNombre(String rol)

//ELIMINACIONES FILTRADAS
deleteByNombre(String nombre)
deleteByActivoFalse()
deleteByEdadLessThan(int edad)

//COMPROBAR EXISTENCIA
existsByEmail(String email)
existsById(Long id)

```





