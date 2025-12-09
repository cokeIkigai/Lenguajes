# HTTP
HTTP es el protocolo que define cómo un cliente (normalmente un navegador o una aplicación) solicita recursos a un servidor y cómo este responde.
Funciona mediante peticiones (GET, POST, PUT, DELETE…) y respuestas que incluyen un código de estado (200, 404, 500…).

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

    <!-- Aquí debe ir la lista de dependencias -->
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

