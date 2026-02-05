

```java

// Ejercicio 1:
public class CalculadoraDescuento {
    public double calcularPrecioFinal(double precio, boolean esClienteVip) {
        double descuento;
        if (esClienteVip) {
            descuento = precio * 0.20;
            double precioFinal = precio - descuento;
            System.out.println("Descuento aplicado: " + descuento);
            return precioFinal;
        } else {
            descuento = precio * 0.10;
            double precioFinal = precio - descuento;
            System.out.println("Descuento aplicado: " + descuento);
            return precioFinal;
        }
    }
}
```
