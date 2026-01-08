
# Markdown

Markdown es un lenguaje de marcado ligero para escribir texto estructurado de forma rápida y legible, muy usado en GitHub, documentación técnica y proyectos de programación.
Para más información en esta página: [MarkDown](https://tutorialmarkdown.com/markdown)

## Títulos y secciones

Dependiendo de la cantidad de `#` que se le añada será de menor tamaño e importancia. Se utiliza para títulos, secciones, subsecciones.

```md
# Título principal
## Sección
### Subsección
#### Nivel 4
```
--- 

## Texto básico

La tipografía puede ser modificada para darle un poco de forma y estilo.

```md
**Negrita**
*Cursiva*
~~Tachado~~
`código en línea`
```
Ejemplos: 

**Negrita**

*Cursiva*

~~Tachado~~

`código en línea`

---

## Listas

Las listas sirven para dar forma a la organización de puntos y que quede mejor representada cada apartado.

### a) Listas sin ordenar

Son listas que no van numeradas y se poner con un guión `-`
```
- Elemento 1
- Elemento 2
    - Subelemento    // si se hace una tabulación se genera una sublista
```
**Ejemplo**:

- Elemento 1
- Elemento 2
    - Subelemento 

### b) Listas ordenadas

Son listas que se numeran, hace falta poner el numero junto con el punto `1.`
```
1. Paso uno
2. Paso dos
3. Paso tres
```

---

## Enlaces

Permite hacer enlaces de referenciar a url, imágenes de archivo o desde el repositorio.

1. Link url:
```md 
[Github](https://github.com) [Nombre](link URL)
```
[Github](https://github.com)

2. Imágenes
```mad
![Texto alternativo](../JAVA/img/Compass.PNG)
```
![Compass](../JAVA/img/Compass.PNG)
Ejemplo en repositorio:


### Bloques de código

Se pueden añadir diferentes estilo de lenguajes para darle familiaridad.
Se añaden 3 tildes francesas ```lenguaje y se cierra con otras 3 tildes ```

Código con lenguaje (recomendado)

```java
public class Main {
    public static void main(String[] args) {
        System.out.println("Hola Markdown");
    }
}
```

Lenguajes habituales: `java`, `sql`, `bash`, `json`, `xml`, `html`, `css`.

---

### 8. Tablas
```
| Campo | Tipo | Descripción |
|------|------|-------------|
| *[Github](https://github.com)*  | web  | Identificador |
| name | text | Nombre |
```
| Campo | Tipo | Descripción |
|------|------|-------------|
| *[Github](https://github.com)*  | web  | Identificador |
| name | text | Nombre |

### 9. Citas
> Esto es una cita o nota importante

### 10. Separadores
---
___

### 11. Checklists (muy usado en GitHub)
- [x] Proyecto creado
- [ ] CRUD completo
- [ ] Documentación

### 12. Comentarios ocultos
```< !-- Esto no se ve en el render -->
```
<!-- Esto no se ve en el render -->

Útil para instrucciones internas o marcas de corrección.

### 13 Emojis

Le da otra personalizión al documento.  😄 😍 :satisfied: 😉

[Emojis](https://tutorialmarkdown.com/emojis)
