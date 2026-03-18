## 🧩 Introducción: Servidor HTTP en Java sin frameworks

Arrancar un **servidor HTTP** directamente desde Java permite entender cómo funciona realmente la comunicación web sin depender de frameworks como `Spring Boot`. Usando únicamente clases estándar del lenguaje, es posible crear un servicio que escuche peticiones, interprete rutas y responda con datos externos, igual que una API REST básica.

Este enfoque ayuda a comprender conceptos clave como:

- El ciclo `request → response`
- El manejo de rutas (`routing`)
- El consumo de APIs externas mediante `HttpClient`
- La estructura mínima de un backend sin capas innecesarias

En este ejemplo, todo se centraliza en el `main`, que actúa como:

- Punto de entrada del servidor
- Router básico de endpoints
- Cliente HTTP para consumir una API pública

La finalidad no es construir una arquitectura compleja, sino visualizar cómo Java puede comportarse como **servidor** y **cliente HTTP** al mismo tiempo. A partir de aquí, el código puede evolucionar fácilmente hacia una estructura más organizada con `controllers`, `services` o incluso integrarse posteriormente con frameworks más avanzados.


```java
package controllers;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class DogsController {

    private final HttpClient client = HttpClient.newHttpClient();

    public void handle(HttpExchange exchange) throws IOException {

        String path = exchange.getRequestURI().getPath();
        String method = exchange.getRequestMethod();

        //  CORS
        exchange.getResponseHeaders().add("Access-Control-Allow-Origin", "*");
        exchange.getResponseHeaders().add("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
        exchange.getResponseHeaders().add("Access-Control-Allow-Headers", "Content-Type");

        if (method.equalsIgnoreCase("OPTIONS")) {
            exchange.sendResponseHeaders(204, -1);
            return;
        }

        try {

            //  GET
            if (method.equalsIgnoreCase("GET")) {

                String apiUrl;

                if (path.equals("/dogs/list")) {
                    apiUrl = "https://dog.ceo/api/breeds/list/all";
                }
                else if (path.equals("/dogs/random")) {
                    apiUrl = "https://dog.ceo/api/breeds/image/random";
                }
                else {
                    sendResponse(exchange, 404, "Endpoint dogs no válido");
                    return;
                }

                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(apiUrl))
                        .GET()
                        .build();

                HttpResponse<String> response =
                        client.send(request, HttpResponse.BodyHandlers.ofString());

                sendResponse(exchange, 200, response.body());
            }

            //  POST (NUEVO)
            else if (method.equalsIgnoreCase("POST")) {

                if (path.equals("/dogs/favorite")) {

                   
                    String body = new String(
                            exchange.getRequestBody().readAllBytes(),
                            StandardCharsets.UTF_8
                    );

                    System.out.println("Body recibido: " + body);

                  
                    JsonObject json = JsonParser.parseString(body).getAsJsonObject();

                    String breed = json.get("breed").getAsString();
                    String image = json.get("image").getAsString();

                   
                    System.out.println("Perro favorito: " + breed + " - " + image);

                   
                    JsonObject responseJson = new JsonObject();
                    responseJson.addProperty("status", "ok");
                    responseJson.addProperty("message", "Guardado correctamente");

                    sendResponse(exchange, 200, responseJson.toString());
                }
                else {
                    sendResponse(exchange, 404, "Endpoint POST no válido");
                }
            }

            else {
                sendResponse(exchange, 405, "Método no permitido");
            }

        } catch (Exception e) {
            e.printStackTrace();
            sendResponse(exchange, 500, "Error en DogsController");
        }
    }

    private void sendResponse(HttpExchange exchange, int status, String body) throws IOException {

        exchange.getResponseHeaders().add("Content-Type", "application/json");

        byte[] bytes = body.getBytes();

        exchange.sendResponseHeaders(status, bytes.length);

        OutputStream os = exchange.getResponseBody();
        os.write(bytes);
        os.close();
    }
}
```
## Proyecto con una organización de carpetas mucho más organizada.
### Main:

```java
package org.example;

import com.sun.net.httpserver.HttpServer;
import java.net.InetSocketAddress;
import router.RouterHandler;

public class Main {

    public static void main(String[] args) throws Exception {
        // Se crea el servior y desde qué puerto va estar escuchando
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        // cada vez que arranca y se pone (http://localhost:8080)
        server.createContext("/", new RouterHandler());

        server.setExecutor(null);
        server.start();

        System.out.println("Servidor iniciado en http://localhost:8080");
    }
}
```

### Router:

```java
package router;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import controllers.DogsController;

import java.io.IOException;
import java.io.OutputStream;

public class RouterHandler implements HttpHandler {

    private final DogsController dogsController = new DogsController();

    @Override
    public void handle(HttpExchange exchange) throws IOException {

        String path = exchange.getRequestURI().getPath();

        if (path.startsWith("/dogs")) {
            dogsController.handle(exchange);
            return;
        }

        String response = "404 - Ruta no encontrada";
        exchange.sendResponseHeaders(404, response.length());
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
}

```

### Controllers:

```java
package controllers;

import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class DogsController {

    private final HttpClient client = HttpClient.newHttpClient();

    public void handle(HttpExchange exchange) throws IOException {

        String path = exchange.getRequestURI().getPath();

        try {

            String apiUrl;

            if (path.equals("/dogs/list")) {
                apiUrl = "https://dog.ceo/api/breeds/list/all";
            }
            else if (path.equals("/dogs/random")) {
                apiUrl = "https://dog.ceo/api/breeds/image/random";
            }
            else {
                sendResponse(exchange, 404, "Endpoint dogs no válido");
                return;
            }

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(apiUrl))
                    .GET()
                    .build();

            HttpResponse<String> response =
                    client.send(request, HttpResponse.BodyHandlers.ofString());

            sendResponse(exchange, 200, response.body());

        } catch (Exception e) {
            sendResponse(exchange, 500, "Error llamando a la API dogs");
        }
    }

    private void sendResponse(HttpExchange exchange, int status, String body) throws IOException {

        exchange.getResponseHeaders().add("Content-Type", "application/json");

        byte[] bytes = body.getBytes();

        exchange.sendResponseHeaders(status, bytes.length);

        OutputStream os = exchange.getResponseBody();
        os.write(bytes);
        os.close();
    }
}
```

--- 

## 🧪 Ejercicio: Crear un JSON

### 🎯 Objetivo
Partiendo del endpoint:

`https://dog.ceo/api/breeds/list/all`

Crear con ese endpoint de la apiDogs lo siguiente:
1. Devuelva todas los nombre de las razas.
2. Devuelva los nombres solo de los que no tienen subRazas
3. Devuela los nombres de los que tengan subRazas

Debéis transformar la respuesta original en un **JSON más cómodo**.
Para el siguiente debéis usar estos endpoints que recoge

`https://dog.ceo/api/breeds/image/random`
`https://dog.ceo/api/breed/affenpinscher/images/random`

1. Devuelva una imagen random
2. Devuelva 5 imágenes de perros random
3. Devulevan n cantidad de perros radom añadidos. 

