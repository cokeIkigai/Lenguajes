
**datos.xml:**

```xml
<?xml version="1.0" encoding="UTF-8"?>
<personas>
    <persona id="1">
        <nombre>Juan Pérez</nombre>
        <edad>30</edad>
        <email>juan.perez@email.com</email>
        <ciudad>Madrid</ciudad>
        <profesion>Desarrollador</profesion>
    </persona>
    
    <persona id="2">
        <nombre>María García</nombre>
        <edad>25</edad>
        <email>maria.garcia@email.com</email>
        <ciudad>Barcelona</ciudad>
        <profesion>Diseñadora</profesion>
    </persona>
    
    <persona id="3">
        <nombre>Carlos López</nombre>
        <edad>35</edad>
        <email>carlos.lopez@email.com</email>
        <ciudad>Valencia</ciudad>
        <profesion>Analista</profesion>
    </persona>
</personas
```

**Main.java:**

```java
package org.example;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) {
        try {
            // Obtener el archivo XML desde resources
            InputStream inputStream = Main.class.getClassLoader().getResourceAsStream("datos.xml");

            if (inputStream == null) {
                System.err.println("Error: No se encontró 'datos.xml' en resources");
                return;
            }

            // Parsear el archivo XML
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            // El parser lee el XML y construye un árbol en memoria
            Document document = builder.parse(inputStream);
            // Limpia y organiza el árbol para facilitar su uso
            document.getDocumentElement().normalize();

            // Obtener todas las etiquetas "persona"
            NodeList listaPersonas = document.getElementsByTagName("persona");


            // Recorrer y mostrar cada persona
            for (int i = 0; i < listaPersonas.getLength(); i++) {
            // Recoge cada bloque <persona> del xml
                Node nodoPersona = listaPersonas.item(i);

                if (nodoPersona.getNodeType() == Node.ELEMENT_NODE) {
                    Element persona = (Element) nodoPersona;

                    System.out.println("Persona #" + persona.getAttribute("id"));
                    System.out.println("  Nombre: " + persona.getElementsByTagName("nombre").item(0).getTextContent());
                    // Crre un método para reducir
                    System.out.println("  Edad: " + getValor(persona, "edad"));
                    System.out.println("  Email: " + getValor(persona, "email"));
                    System.out.println("  Ciudad: " + getValor(persona, "ciudad"));
                    System.out.println("  Profesión: " + getValor(persona, "profesion"));

                }
            }

            inputStream.close();
            System.out.println("\n Lectura completada");

        } catch (Exception e) {
            System.err.println(" ERROR: " + e.getMessage());
        }
    }

    private static String getValor(Element elementoPadre, String nombreElemento) {
        return elementoPadre.getElementsByTagName(nombreElemento)
                .item(0)
                .getTextContent();
    }
}
```
