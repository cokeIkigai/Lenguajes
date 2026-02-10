# 🌐 Comunicación HTTP y Consumo de APIs en Java

<img src="../../img/http1.jpg" width=950 height=250>

## ❓Qué es HTTP

**HTTP** *(HyperText Transfer Protocol)* es el protocolo que `permite la comunicación` entre aplicaciones a través de Internet. Define cómo un cliente, como un navegador web o una aplicación Java, puede solicitar información a un servidor y cómo este responde a dicha solicitud. 

HTTP funciona siempre siguiendo un modelo de **petición–respuesta:** el cliente envía una petición y el servidor devuelve una respuesta con un código de estado y, en muchos casos, datos asociados.
  
<p align="center">
  <img src="../../img/http2.png" width="500" height="250">
</p>

## 👏 PETICIONES

Las `peticiones` HTTP se realizan mediante distintos **métodos** que indican la acción que se desea llevar a cabo:

- `Método GET` se utiliza para obtener información.
- `Método POST` para enviar nuevos datos.
- `Método PUT` para modificar información existente y DELETE para eliminar recursos.

Cuando el servidor `responde`, incluye un código de estado HTTP que indica el resultado de la operación:

## 🗣️ Tipos de respuestas en una API REST (HTTP) 

| Categoría | Código | Nombre | Uso habitual |
|---------|-------|--------|-------------|
| ✅ Éxito | 200 | OK | Petición correcta, devuelve datos (GET) |
| ✅ Éxito | 201 | Created | Recurso creado correctamente (POST) |
| ✅ Éxito | 204 | No Content | Operación correcta sin contenido (DELETE / PUT) |
| ❌ Cliente | 400 | Bad Request | Datos incorrectos o petición mal formada |
| ❌ Cliente | 401 | Unauthorized | Falta autenticación o es incorrecta |
| ❌ Cliente | 403 | Forbidden | Sin permisos para acceder al recurso |
| ❌ Cliente | 404 | Not Found | Recurso no encontrado |
| ❌ Cliente | 409 | Conflict | Conflicto con el estado del recurso |
| ⚠️ Servidor | 500 | Internal Server Error | Error genérico del servidor |
| ⚠️ Servidor | 502 | Bad Gateway | Error al comunicarse con otro servidor |
| ⚠️ Servidor | 503 | Service Unavailable | Servicio no disponible temporalmente |
| 🔁 Redirección | 301 | Moved Permanently | Recurso movido de forma permanente |
| 🔁 Redirección | 302 | Found | Redirección temporal |
| ℹ️ Informativo | 100 | Continue | Continuar con el envío de la petición |

[ResponsesCats](https://http.cat/)

---

## 🏢 API

**HTTP** se utiliza principalmente para `consumir APIs`. Una API es un servicio que expone información o funcionalidades a través de URLs accesibles mediante peticiones HTTP. 

- Estas APIs suelen devolver los datos en `formato JSON`.
- Un formato de texto estructurado muy común en aplicaciones modernas por su simplicidad y facilidad de uso.

<p align="center">
 <img src="../../img/HTTP.gif" width="500" height="250">
</p>
---

La siguiente funcionalidad es reocger o pedir informacdión a una API y manjear y controlar la información.

**pom.xml**:
```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>org.example</groupId>
    <artifactId>http</artifactId>
    <version>1.0-SNAPSHOT</version>

    <properties>
        <maven.compiler.source>25</maven.compiler.source>
        <maven.compiler.target>25</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>

    <dependencies>
        <dependency>
            <groupId>com.google.code.gson</groupId>
            <artifactId>gson</artifactId>
            <version>2.11.0</version>
        </dependency>
    </dependencies>

</project>

```

**Main:** 
```java
package org.example;

public class Main {
    public static void main(String[] args) {

        try {
            HttpClientPokemon http = new HttpClientPokemon();

            // Obtener los Pokémon (solo nombres)
            for (HttpClientPokemon.Pokemon p : http.getPokemons()) {
                System.out.println(p.name);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

```
**HttpClientPokemon**
```java
package org.example;

import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class HttpClientPokemon {

    // URL de PokeAPI
    private final String url = "https://pokeapi.co/api/v2/pokemon?offset=20&limit=1328";

    // Cliente HTTP
    private final HttpClient client = HttpClient.newHttpClient();

    // Metodo principal que hace la petición y devuelve los Pokémon
    public List<Pokemon> getPokemons() throws IOException, InterruptedException {

        // Construcción de la petición GET
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        // Envío de la petición
        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());

        // Parseo del JSON
        Gson gson = new Gson();
        PokemonResponse data = gson.fromJson(response.body(), PokemonResponse.class);

        return data.results;
    }

    // Clase interna (modelo Pokémon)
    public static class Pokemon {
        String name;
        String url;
    }

    // Clase interna (estructura JSON)
    public static class PokemonResponse {
        List<Pokemon> results;
    }
}
```

