# 📅 Fechas y Dates

## Introducción

`java.util.Date` fue durante años la forma estándar de manejar fechas en Java, pero hoy se considera parte de la API antigua:

- Representa un instante en milisegundos desde 1970 (UTC)
- Mezcla conceptos como fecha, hora y zona sin diferenciarlos claramente. 
- Además, es mutable, tiene métodos confusos y obliga a usar clases como `Calendar` para operaciones básicas, lo que complica el código y aumenta la probabilidad de errores.

Desde `Java 8` se introdujo el paquete `java.time`, diseñado para sustituir a Date. 
Estas clases son inmutables, legibles y facilitan cálculos, comparaciones y formateo.

---

## 🕒 Tipos principales de fechas y tiempos en `java.time`

| Tipo | Ejemplo | Qué representa | Cuándo usarlo |
|---|---|---|---|
| `LocalDate` | 2026-02-12 | Solo fecha (sin hora ni zona) | Cumpleaños, días de evento, calendarios |
| `LocalTime` | 10:30:15 | Solo hora (sin fecha ni zona) | Horarios diarios, aperturas, alarmas |
| `LocalDateTime` | 2026-02-12T10:30:15 | Fecha + hora sin zona | Apps locales donde no importa el país/zona |
| `ZoneId` | "Europe/Madrid" | Identificador de zona horaria | Convertir horas entre países |
| `ZonedDateTime` | 2026-02-12T10:30:15+01:00[Europe/Madrid] | Fecha + hora + zona completa | Sistemas internacionales, cambios de hora (DST) |
| `OffsetDateTime` | 2026-02-12T10:30:15+01:00 | Fecha + hora con offset fijo | APIs REST, JSON, comunicación entre sistemas |
| `Instant` | 2026-02-12T09:30:15Z | Punto exacto en UTC | Guardar en BBDD, logs, timestamps universales |
| `Period` | P1Y2M3D | Diferencia en años/meses/días | Edad, días entre fechas calendario |
| `Duration` | PT2H30M | Diferencia exacta en tiempo | Tiempos técnicos, segundos/minutos reales |
| `Year` | 2026 | Solo año | Filtros anuales, informes |
| `YearMonth` | 2026-02 | Año + mes | Facturación mensual, estadísticas |
| `MonthDay` | --02-12 | Día y mes sin año | Cumpleaños recurrentes |
| `Clock` | systemUTC() | Fuente de tiempo configurable | Testing, simulaciones de tiempo |
| `DateTimeFormatter` | dd/MM/yyyy | Formateo y parsing | Mostrar fechas al usuario |

---

### “Now” y creación de fechas
```java
import java.time.*;

public class Main {
    public static void main(String[] args) {
      LocalDate hoy = LocalDate.now();                                      // 2026-02-12
      LocalDate hoyMadrid = LocalDate.now(ZoneId.of("Europe/Madrid"));      // 2026-02-12
      LocalDate fecha = LocalDate.of(2026, 2, 12);                          // 2026-02-12
      LocalDateTime fechaHora = LocalDateTime.of(2026, 2, 12, 10, 30);      // 2026-02-12T10:30
      Instant ahoraUtc = Instant.now();                                     // 2026-02-12T10:15:32.458Z
      ZonedDateTime madrid = ZonedDateTime.now(ZoneId.of("Europe/Madrid")); // 2026-02-12T11:15:32.460+01:00[Europe/Madrid]
   }
}
```
### Comparación de Fechas

```java
public class Main {
    public static void main(String[] args) {

        LocalDate d = LocalDate.of(2026, 2, 12);      --2026-02-12
        LocalDate mas7 = d.plusDays(7);               -- 2026-02-19
        LocalDate menos2Meses = d.minusMonths(2);     -- 2025-12-12
        boolean antes = d.isBefore(LocalDate.now());  -- false
        boolean despues = d.isAfter(LocalDate.now()); -- false
        boolean igual = d.isEqual(LocalDate.now());   -- true
    }
}
```

### Diferencias: Period vs Duration
```java
import java.time.*;

LocalDate a = LocalDate.of(2026, 2, 1);
LocalDate b = LocalDate.of(2026, 2, 12);

Period p = Period.between(a, b); // 11 días (según calendario)
int dias = p.getDays();

LocalDateTime x = LocalDateTime.of(2026, 2, 12, 10, 0);
LocalDateTime y = LocalDateTime.of(2026, 2, 12, 12, 30);

Duration dur = Duration.between(x, y); // 2h 30m exactos
long minutos = dur.toMinutes();
```

### Zonas horarias y cambios de hora (muy importante)

Para “hora real” en el mundo, es mejor no usar `LocalDateTime` si hay zona implicada.

```java
import java.time.*;

ZoneId madrid = ZoneId.of("Europe/Madrid");
ZonedDateTime z = ZonedDateTime.of(2026, 3, 29, 2, 30, 0, 0, madrid); 

```

Recomendación:

Guardar en BBDD como Instant o OffsetDateTime (UTC/offset).

Mostrar al usuario con ZonedDateTime en su zona.

### Convertir entre tipos (tabla típica)
```java
LocalDate → LocalDateTime
LocalDate d = LocalDate.now();
LocalDateTime inicioDia = d.atStartOfDay();

LocalDateTime + zona → Instant
ZoneId zone = ZoneId.of("Europe/Madrid");
LocalDateTime ldt = LocalDateTime.now();
Instant instant = ldt.atZone(zone).toInstant();

Instant → ZonedDateTime
Instant i = Instant.now();
ZonedDateTime z = i.atZone(ZoneId.of("Europe/Madrid"));
```

### Formateo y parsing (String ↔ Date)
```java
import java.time.*;
import java.time.format.DateTimeFormatter;

LocalDate d = LocalDate.of(2026, 2, 12);
String s1 = d.format(DateTimeFormatter.ISO_LOCAL_DATE); // 2026-02-12

DateTimeFormatter es = DateTimeFormatter.ofPattern("dd/MM/yyyy");
String s2 = d.format(es); // 12/02/2026

Parsing
LocalDate d1 = LocalDate.parse("2026-02-12");
LocalDate d2 = LocalDate.parse("12/02/2026", DateTimeFormatter.ofPattern("dd/MM/yyyy"));
```

### Truncar / redondear (quitar minutos/segundos)
```java
import java.time.*;
import java.time.temporal.ChronoUnit;

LocalDateTime ldt = LocalDateTime.now();
LocalDateTime sinSegundos = ldt.truncatedTo(ChronoUnit.MINUTES);
```

### Date legado ↔ java.time (cuando haya librerías antiguas)
```java
import java.time.*;
import java.util.Date;

Date old = new Date();
Instant i = old.toInstant();
Date back = Date.from(i);
```

### Errores típicos 

- Usar LocalDateTime para “hora real global” (pierdes zona/offset).
- Guardar timestamps como String sin formato estándar.
- Mezclar Period y Duration sin entender que no miden lo mismo.
- No especificar Locale al formatear nombres de meses/días (si aplica).
- Ignorar cambios de hora (DST).

--- 

### 🧩 Ejecicios

1. **Match Day**
- Comprueba si hoy es el día del partido.
- Fecha del evento: 2026-02-12.

2. **Cuenta atrás**
- Calcula cuántos días faltan desde hoy hasta el partido.
- Fecha del evento: 2026-02-12.

3. **Registro de logs**
- Obtén el instante actual en UTC para guardar un registro del sistema.

4. **Hora internacional**
- Muestra la fecha y hora actual en la zona "Europe/Madrid".

5. **Creación de evento**
- Crea una fecha y hora fija para un evento:
- 2026-02-12 a las 10:30.

6. **Evento pasado o futuro**
- Indica si el evento (2026-02-12) ya ocurrió, es hoy o será en el futuro.

7. **Fin de semana**
- A partir de la fecha 2026-02-14, indica si cae en sábado o domingo.

8. **Sumar días**
- A la fecha 2026-02-12 súmale 7 días y muestra la nueva fecha.

9. **Restar meses**
- A la fecha 2026-02-12 réstale 2 meses.

10. **Conversión universal**
- Convierte la fecha y hora 2026-02-12T10:30 en un `Instant` usando la zona "Europe/Madrid".



