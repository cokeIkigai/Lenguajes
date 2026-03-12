
```java
package org.example;
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
import java.nio.charset.StandardCharsets;

public class Main {

    private static final HttpClient client = HttpClient.newHttpClient();

    public static void main(String[] args) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

        server.createContext("/", new HttpHandler() {
            @Override
            public void handle(HttpExchange exchange) throws IOException {
                addCorsHeaders(exchange);
                String method = exchange.getRequestMethod();
                String path = exchange.getRequestURI().getPath();

                // Esto se llama CORS preflight request. Es el primer TOC TOC, me permites llamar?
                if (method.equalsIgnoreCase("OPTIONS")) {
                    exchange.sendResponseHeaders(204, -1);
                    return;
                }
                try {
                    String apiUrl;
                    if (path.equals("/dogs/list")) {
                        String resultado = llamarApi("https://dog.ceo/api/breeds/list/all");
                        send(exchange, 200, resultado);
                        return;
                    }

                   if (path.equals("/dogs/random")) {
                        String resultado = llamarApi("https://dog.ceo/api/breeds/image/random");
                        send(exchange, 200, resultado);
                        return;
                    }

                    if (path.startsWith("/dogs/image/")) {
                        String raza = path.replace("/dogs/image/", "");
                        apiUrl = "https://dog.ceo/api/breed/" + raza + "/images/random";
                        String resultado = llamarApi(apiUrl);
                        send(exchange, 200, resultado);
                        return;
                    }

                    if (path.equals("/dogs/clicks")) {
                        String body = new String(
                                exchange.getRequestBody().readAllBytes(),
                                StandardCharsets.UTF_8
                        );

                        System.out.println("Metodo recibido: " + method);
                        System.out.println("Clicks recibidos:");
                        System.out.println(body);

                        send(exchange, 200, "{\"ok\":true}");
                        return;
                    }

                 send(exchange, 404, "{\"error\":\"Ruta no válida\"}");

                } catch (Exception e) {
                    e.printStackTrace();
                    send(exchange, 500, "{\"error\":\"Error en servidor\"}");
                }
            }
        });

        server.setExecutor(null);
        server.start();

        System.out.println("Servidor activo:");
        System.out.println("http://localhost:8080/dogs/list");
        System.out.println("http://localhost:8080/dogs/random");
        System.out.println("http://localhost:8080/dogs/image/affenpinscher");
        System.out.println("POST -> http://localhost:8080/dogs/clicks");
    }

    private static void addCorsHeaders(HttpExchange exchange) {
        exchange.getResponseHeaders().add("Access-Control-Allow-Origin", "*");
        exchange.getResponseHeaders().add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        exchange.getResponseHeaders().add("Access-Control-Allow-Headers", "Content-Type, Authorization");
    }

    private static void send(HttpExchange exchange, int status, String body) throws IOException {
        exchange.getResponseHeaders().add("Content-Type", "application/json; charset=UTF-8");
        byte[] bytes = body.getBytes(StandardCharsets.UTF_8);
        exchange.sendResponseHeaders(status, bytes.length);
        try (OutputStream os = exchange.getResponseBody()) {
            os.write(bytes);
        }
    }

    private static String llamarApi(String apiUrl) throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .GET()
                .build();
        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }
}
``` 

```html
<!DOCTYPE html>
<html lang="es">
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dog API Razas</title>
    <link rel="stylesheet" href="index.css">
  </head>
  <body>
    <h1>Dog API Front</h1>

    <div class="zona">
      <h2>Enviar datos al backend</h2>
      <button onclick="enviarContador()">Enviar contador</button>
    </div>

    <div class="zona">
      <h2>Razas</h2>
      <button onclick="cargarRazas()">Cargar razas</button>
      <div id="contenedorRazas"></div>
    </div>

    <div class="zona">
      <h2>Resultado</h2>
      <div id="razaSeleccionada"></div>
      <pre id="resultado">Aquí aparecerá el JSON...</pre>
      <img id="imagenPerro" alt="Imagen del perro">
    </div>
    
  </body>
  <script src="index.js">  </script>
</html>
```

```css
 body {
      font-family: Arial, sans-serif;
      margin: 20px;
      background: #f4f4f4;
    }

    h1, h2 {
      margin-bottom: 10px;
    }

    .zona {
      background: white;
      padding: 16px;
      margin-bottom: 20px;
      border-radius: 12px;
      box-shadow: 0 2px 8px rgba(0,0,0,0.08);
    }

    #contenedorRazas {
      display: flex;
      flex-wrap: wrap;
      gap: 8px;
    }

    button {
      border: none;
      padding: 8px 12px;
      border-radius: 8px;
      cursor: pointer;
      background: #222;
      color: white;
    }

    button:hover {
      opacity: 0.9;
    }

    #resultado {
      white-space: pre-wrap;
      background: #111;
      color: #00ff88;
      padding: 12px;
      border-radius: 8px;
      overflow-x: auto;
    }

    #imagenPerro {
      max-width: 500px;
      width: 100%;
      border-radius: 12px;
      display: none;
      margin-top: 12px;
    }

    #razaSeleccionada {
      font-weight: bold;
      margin-top: 10px;
    }
```

```js
const BASE_URL = "http://localhost:8080";

// contador de clicks por raza
const contador = {}

async function cargarRazas(){

    const response = await fetch(BASE_URL + "/dogs/list")
    const data = await response.json()

    const contenedor = document.getElementById("contenedorRazas")
    contenedor.innerHTML = ""

    const razas = Object.keys(data.message)

    razas.forEach(raza => {

        const boton = document.createElement("button")
        boton.textContent = raza

        boton.onclick = () => clickRaza(raza)

        contenedor.appendChild(boton)
    })

}

async function clickRaza(raza){

    // mostrar raza seleccionada
    document.getElementById("razaSeleccionada").textContent =
        "Raza seleccionada: " + raza


    // contador simple
    if(!contador[raza]){
        contador[raza] = 0
    }

    contador[raza]++


    // mandar contador al backend
    enviarContador()


    // pedir imagen de esa raza
    const response = await fetch(BASE_URL + "/dogs/image/" + raza)
    const data = await response.json()

    document.getElementById("resultado").textContent =
        JSON.stringify(data,null,2)

    const img = document.getElementById("imagenPerro")
    img.src = data.message
    img.style.display = "block"

}

function enviarContador(){

    // convertir objeto contador a array
    const array = Object.entries(contador).map(([nombre,veces]) => {
        return {nombre,veces}
    })

    fetch(BASE_URL + "/dogs/clicks",{
        method:"POST",
        headers:{
            "Content-Type":"application/json"
        },
        body: JSON.stringify(array)
    })

}
```
