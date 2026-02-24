# ⏰ Timer y TimerTask

**Timer y TimerTask** es como un "despertador" para programas. Le dices "ejecuta esto cada X tiempo" y él lo hace automáticamente.

> Ejemplo de la vida real: Un despertador suena a las 7:00 AM cada día → ESO ES CRON

---

## 🚀 EJEMPLO 1: El más básico (Hola cada 2 segundos)

```java
import java.util.Timer;
import java.util.TimerTask;

public class EjemploBasico {
    public static void main(String[] args) {
        // 1. Crear el despertador
        Timer timer = new Timer();
        
        // 2. Crear la tarea (qué quieres que haga)
        TimerTask tarea = new TimerTask() {
            @Override
            public void run() {
                System.out.println("🔔 ¡Hola! Han pasado 2 segundos");
            }
        };
        
        // 3. Programar: espera 0ms y luego cada 2000ms (2 segundos)
        timer.scheduleAtFixedRate(tarea, 0, 2000);
        
        System.out.println("⏰ Timer iniciado - Se ejecutará cada 2 segundos");
    }
}
```
- Cópialo, pégalo y ejecuta
- Verás mensajes cada 2 segundos

---

## ⏱️ EJEMPLO 2: Contador de segundos (para entender el tiempo)

```java
import java.util.Timer;
import java.util.TimerTask;

public class ContadorSegundos {
    private static int contador = 0;
    
    public static void main(String[] args) {
        Timer timer = new Timer();
        
        TimerTask tarea = new TimerTask() {
            @Override
            public void run() {
                contador++;
                System.out.println("Segundo " + contador);
                
                if (contador == 10) {
                    System.out.println("🎯 ¡Llegamos a 10 segundos! Paramos.");
                    timer.cancel(); // Detiene el timer
                    System.out.println("⏹️ Timer detenido");
                }
            }
        };
        
        System.out.println("⏱️ Contador iniciado (llegará hasta 10)");
        timer.scheduleAtFixedRate(tarea, 0, 1000); // Cada 1 segundo
    }
}
```

---

## ⏲️ EJEMPLO 3: Temporizador con cuenta atrás (muy útil)

```java
import java.util.Timer;
import java.util.TimerTask;

public class CuentaAtras {
    private static int segundosRestantes = 10;
    
    public static void main(String[] args) {
        Timer timer = new Timer();
        
        TimerTask tarea = new TimerTask() {
            @Override
            public void run() {
                System.out.println("⏳ Quedan: " + segundosRestantes + " segundos");
                segundosRestantes--;
                
                if (segundosRestantes < 0) {
                    System.out.println("🚨 ¡TIEMPO TERMINADO!");
                    timer.cancel();
                }
            }
        };
        
        System.out.println("🎮 Cuenta atrás iniciada desde 10");
        timer.scheduleAtFixedRate(tarea, 0, 1000);
    }
}
```

## 📊 EJEMPLO 4: Múltiples tareas a la vez

```java
import java.util.Timer;
import java.util.TimerTask;

public class MultiplesTareas {
    public static void main(String[] args) {
        Timer timer = new Timer();
        
        // Tarea 1: Cada 2 segundos
        TimerTask tarea1 = new TimerTask() {
            @Override
            public void run() {
                System.out.println("📌 Tarea 1: Cada 2 segundos");
            }
        };
        
        // Tarea 2: Cada 3 segundos
        TimerTask tarea2 = new TimerTask() {
            @Override
            public void run() {
                System.out.println("  📌 Tarea 2: Cada 3 segundos");
            }
        };
        
        // Tarea 3: Cada 5 segundos
        TimerTask tarea3 = new TimerTask() {
            @Override
            public void run() {
                System.out.println("    📌 Tarea 3: Cada 5 segundos");
            }
        };
        
        // Programar todas
        timer.scheduleAtFixedRate(tarea1, 0, 2000);
        timer.scheduleAtFixedRate(tarea2, 0, 3000);
        timer.scheduleAtFixedRate(tarea3, 0, 5000);
        
        System.out.println("⏰ 3 tareas ejecutándose simultáneamente");
    }
}
```

---

 ## 🎯 EJEMPLO 5: Una tarea que se ejecuta UNA SOLA VEZ

 ```java
import java.util.Timer;
import java.util.TimerTask;

public class UnaVez {
    public static void main(String[] args) {
        Timer timer = new Timer();
        
        TimerTask tarea = new TimerTask() {
            @Override
            public void run() {
                System.out.println("🎯 ¡Esta tarea solo se ejecuta UNA VEZ!");
                System.out.println("    Después de 5 segundos de espera");
            }
        };
        
        System.out.println("⏰ Esperando 5 segundos...");
        // schedule (no scheduleAtFixedRate) para una sola vez
        timer.schedule(tarea, 5000); // Se ejecuta una vez después de 5 segundos
    }
}
```

---

## 🔢 EJEMPLO 6: Temporizador con horas, minutos y segundos

```java
import java.util.Timer;
import java.util.TimerTask;

public class TemporizadorHHMMSS {
    private static int horas = 0;
    private static int minutos = 0;
    private static int segundos = 0;
    private static int totalSegundos = 5; // Cambia esto para más tiempo
    
    public static void main(String[] args) {
        Timer timer = new Timer();
        
        TimerTask tarea = new TimerTask() {
            @Override
            public void run() {
                if (totalSegundos > 0) {
                    totalSegundos--;
                    
                    // Calcular horas, minutos, segundos restantes
                    int h = totalSegundos / 3600;
                    int m = (totalSegundos % 3600) / 60;
                    int s = totalSegundos % 60;
                    
                    // Formato bonito: 00:00:00
                    System.out.printf("⏱️  Tiempo restante: %02d:%02d:%02d%n", h, m, s);
                    
                    if (totalSegundos == 0) {
                        System.out.println("🔔 ¡TIEMPO TERMINADO!");
                        timer.cancel();
                    }
                }
            }
        };
        
        System.out.println("🎮 Temporizador iniciado: 00:00:05 (5 segundos)");
        timer.scheduleAtFixedRate(tarea, 0, 1000);
    }
}
```

## 🛑 EJEMPLO 7: Cómo parar un timer desde fuera

```java
import java.util.Timer;
import java.util.TimerTask;
import java.util.Scanner;

public class PararTimer {
    private static Timer timer;
    
    public static void main(String[] args) {
        timer = new Timer();
        Scanner scanner = new Scanner(System.in);
        
        TimerTask tarea = new TimerTask() {
            @Override
            public void run() {
                System.out.println("🔔 Timer activo... (Pulsa ENTER para parar)");
            }
        };
        
        timer.scheduleAtFixedRate(tarea, 0, 2000);
        
        System.out.println("⏰ Timer iniciado. Pulsa ENTER para detenerlo.");
        scanner.nextLine(); // Espera a que el usuario pulse ENTER
        
        timer.cancel();
        System.out.println("⏹️ Timer detenido manualmente");
        scanner.close();
    }
}
```


