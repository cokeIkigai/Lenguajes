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
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.OutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {

    private static final HttpClient client = HttpClient.newHttpClient();

    public static void main(String[] args) throws Exception {

        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

        // Todo el routing aquí
        server.createContext("/", new HttpHandler() {
            @Override
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
                        send(exchange, 404, "Ruta no válida");
                        return;
                    }

                    HttpRequest request = HttpRequest.newBuilder()
                            .uri(URI.create(apiUrl))
                            .GET()
                            .build();

                    HttpResponse<String> response =
                            client.send(request, HttpResponse.BodyHandlers.ofString());

                    send(exchange, 200, response.body());

                } catch (Exception e) {
                    send(exchange, 500, "Error llamando a la API");
                }
            }
        });

        server.setExecutor(null);
        server.start();

        System.out.println("Servidor activo:");
        System.out.println("http://localhost:8080/dogs/list");
        System.out.println("http://localhost:8080/dogs/random");
    }

    private static void send(HttpExchange exchange, int status, String body) throws IOException {

        exchange.getResponseHeaders().add("Content-Type", "application/json");

        byte[] bytes = body.getBytes();
        exchange.sendResponseHeaders(status, bytes.length);

        OutputStream os = exchange.getResponseBody();
        os.write(bytes);
        os.close();
    }
}
```
## Proyecto con una organizaciónde carpetas mucho más organizada.
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

## 🧪 Ejercicio: Crear un JSON propio para construir rutas dinámicas

### 🎯 Objetivo
Partiendo del endpoint:

`https://dog.ceo/api/breeds/list/all`

debéis transformar la respuesta original en un **JSON más cómodo** que luego permita generar llamadas específicas como:

`https://dog.ceo/api/breed/affenpinscher/images/random`

La idea es que vuestro servidor NO solo reenvíe datos, sino que **procese y prepare información útil** para futuras rutas.

---

## ✅ Parte 1 — Normalizar el JSON de razas

La API devuelve algo parecido a:

```json
{
  "affenpinscher": [],
  "bulldog": ["boston","english","french"]
}
```

**Pasarlo a algo asi:**

```json
{
  "breeds": [
    { "name": "affenpinscher" },
    { "name": "bulldog-boston" },
    { "name": "bulldog-english" },
    { "name": "bulldog-french" }
  ]
}
```

## ✅ Parte 2 — Endpoint dinámico

Usando el JSON creado antes, implementar:
```
GET /dogs/random/{breed}
``` 

**Ejemplo:**

```
/dogs/random/affenpinscher
```

**Debe construir automáticamente:**

```
https://dog.ceo/api/breed/affenpinscher/images/random
```

## ✅ Parte 3 — Lógica adicional

Si la raza no existe en vuestro JSON → devolver error.

No se permite escribir las razas a mano.

Todo debe salir del endpoint list/all.
