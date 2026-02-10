# Comunicación HTTP y Consumo de APIs en Java

**HTTP** *(HyperText Transfer Protocol)* es el protocolo que permite la comunicación entre aplicaciones a través de Internet. Define cómo un cliente, como un navegador web o una aplicación Java, puede solicitar información a un servidor y cómo este responde a dicha solicitud. HTTP funciona siempre siguiendo un modelo de petición–respuesta: el cliente envía una petición y el servidor devuelve una respuesta con un código de estado y, en muchos casos, datos asociados.

Las peticiones HTTP se realizan mediante distintos métodos que indican la acción que se desea llevar a cabo. El método GET se utiliza para obtener información, POST para enviar nuevos datos, PUT para modificar información existente y DELETE para eliminar recursos. Cuando el servidor responde, incluye un código de estado HTTP que indica el resultado de la operación, como 200 cuando la petición se ha realizado correctamente, 404 cuando el recurso no existe o 500 cuando se produce un error interno en el servidor.

En el contexto de la programación, HTTP se utiliza principalmente para consumir APIs. Una API es un servicio que expone información o funcionalidades a través de URLs accesibles mediante peticiones HTTP. Estas APIs suelen devolver los datos en formato JSON, un formato de texto estructurado muy común en aplicaciones modernas por su simplicidad y facilidad de uso.

El objetivo de este bloque es aprender a recoger información de una API desde Java, procesar la respuesta recibida y trabajar con los datos de forma controlada dentro del programa. Para ello, se utiliza el cliente HTTP incorporado en Java, que permite construir peticiones, enviarlas a un servidor y recibir la respuesta correspondiente.

En este proyecto se emplea Maven para la gestión de dependencias, lo que permite incorporar librerías externas de forma sencilla. En concreto, se utiliza la librería Gson, que facilita la conversión de datos en formato JSON a objetos Java. Gracias a Gson, el JSON recibido desde la API puede transformarse directamente en clases Java, evitando tener que procesar manualmente el contenido de la respuesta.

El programa realiza una petición HTTP de tipo GET a una API pública, recibe la respuesta en formato JSON y la convierte en objetos Java mediante Gson. A partir de esos objetos, la aplicación puede acceder a la información recibida y mostrarla o procesarla según sea necesario. Este flujo reproduce un escenario real de comunicación entre aplicaciones y sienta las bases para el trabajo con servicios web, APIs REST y aplicaciones backend más avanzadas.

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

