# 📅 Fechas y Dates

## Introducción

`java.util.Date` fue durante años la forma estándar de manejar fechas en Java, pero hoy se considera parte de la API antigua:

- Representa un instante en milisegundos desde 1970 (UTC)
- Mezcla conceptos como fecha, hora y zona sin diferenciarlos claramente. 
- Además, es mutable, tiene métodos confusos y obliga a usar clases como `Calendar` para operaciones básicas, lo que complica el código y aumenta la probabilidad de errores.

Desde `Java 8` se introdujo el paquete `java.time`, diseñado para sustituir a Date. 
Aquí aparecen tipos más claros y seguros según la necesidad: 
- `LocalDate` para solo fecha, 
- `LocalDateTime` para fecha y hora sin zona, 
- `ZonedDateTime` cuando intervienen zonas horarias.
- 
Estas clases son inmutables, legibles y facilitan cálculos, comparaciones y formateo.

---

Regla práctica:

Solo fecha (sin hora): LocalDate

Fecha + hora (sin zona): LocalDateTime

Fecha + hora + zona: ZonedDateTime

Timestamp universal (UTC): Instant

2) Las clases clave (mapa mental)
Fechas “humanas”

LocalDate → 2026-02-12

LocalTime → 10:30:15

LocalDateTime → 2026-02-12T10:30:15

Con zona / universal

ZoneId → "Europe/Madrid"

ZonedDateTime → fecha-hora en una zona (maneja cambios de hora)

OffsetDateTime → fecha-hora con offset (+01:00, +02:00)

Instant → punto en el tiempo (UTC)

Duraciones y periodos

Period → años/meses/días (calendario)

Duration → horas/minutos/segundos (tiempo exacto)

Formateo y parsing

DateTimeFormatter → patrones y parseo seguro

3) “Now” y creación de fechas
import java.time.*;

LocalDate hoy = LocalDate.now();
LocalDate hoyMadrid = LocalDate.now(ZoneId.of("Europe/Madrid"));

LocalDate fecha = LocalDate.of(2026, 2, 12);
LocalDateTime fechaHora = LocalDateTime.of(2026, 2, 12, 10, 30);

Instant ahoraUtc = Instant.now();
ZonedDateTime madrid = ZonedDateTime.now(ZoneId.of("Europe/Madrid"));

4) Sumar/restar y comparar
import java.time.*;

LocalDate d = LocalDate.of(2026, 2, 12);

LocalDate mas7 = d.plusDays(7);
LocalDate menos2Meses = d.minusMonths(2);

boolean antes = d.isBefore(LocalDate.now());
boolean despues = d.isAfter(LocalDate.now());
boolean igual = d.isEqual(LocalDate.now());

5) Diferencias: Period vs Duration
import java.time.*;

LocalDate a = LocalDate.of(2026, 2, 1);
LocalDate b = LocalDate.of(2026, 2, 12);

Period p = Period.between(a, b); // 11 días (según calendario)
int dias = p.getDays();

LocalDateTime x = LocalDateTime.of(2026, 2, 12, 10, 0);
LocalDateTime y = LocalDateTime.of(2026, 2, 12, 12, 30);

Duration dur = Duration.between(x, y); // 2h 30m exactos
long minutos = dur.toMinutes();

6) Zonas horarias y cambios de hora (muy importante)

Para “hora real” en el mundo: no uses LocalDateTime si hay zona implicada.

import java.time.*;

ZoneId madrid = ZoneId.of("Europe/Madrid");
ZonedDateTime z = ZonedDateTime.of(2026, 3, 29, 2, 30, 0, 0, madrid); 
// OJO: en cambios de hora, algunas horas no existen o se duplican.


Recomendación:

Guardar en BBDD como Instant o OffsetDateTime (UTC/offset).

Mostrar al usuario con ZonedDateTime en su zona.

7) Convertir entre tipos (tabla típica)
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

8) Formateo y parsing (String ↔ Date)
Formateo
import java.time.*;
import java.time.format.DateTimeFormatter;

LocalDate d = LocalDate.of(2026, 2, 12);
String s1 = d.format(DateTimeFormatter.ISO_LOCAL_DATE); // 2026-02-12

DateTimeFormatter es = DateTimeFormatter.ofPattern("dd/MM/yyyy");
String s2 = d.format(es); // 12/02/2026

Parsing
LocalDate d1 = LocalDate.parse("2026-02-12");
LocalDate d2 = LocalDate.parse("12/02/2026", DateTimeFormatter.ofPattern("dd/MM/yyyy"));

9) Truncar / redondear (quitar minutos/segundos)
import java.time.*;
import java.time.temporal.ChronoUnit;

LocalDateTime ldt = LocalDateTime.now();
LocalDateTime sinSegundos = ldt.truncatedTo(ChronoUnit.MINUTES);

10) Date legado ↔ java.time (cuando haya librerías antiguas)
import java.time.*;
import java.util.Date;

Date old = new Date();
Instant i = old.toInstant();
Date back = Date.from(i);

11) Errores típicos (para enseñar en clase)

Usar LocalDateTime para “hora real global” (pierdes zona/offset).

Guardar timestamps como String sin formato estándar.

Mezclar Period y Duration sin entender que no miden lo mismo.

No especificar Locale al formatear nombres de meses/días (si aplica).

Ignorar cambios de hora (DST).

12) Mini-proyecto de clase (para dominar TODO)

Objetivo: agenda de eventos con:

Entrada por consola: dd/MM/yyyy HH:mm y zona “Europe/Madrid”

Guardar internamente como Instant

Listar en Madrid y también en otra zona (por ejemplo “America/New_York”)

Calcular:

días hasta el evento (Period)

horas exactas hasta el evento (Duration)

si cae en fin de semana

13) Índice propuesto del “Tema”

Problema histórico (Date/Calendar) y solución (java.time)

Tipos principales y cuándo usar cada uno

Operaciones (sumas/restas, comparaciones)

Period vs Duration

Zonas horarias y DST

Formateo y parsing

Conversiones con legado

Ejercicios + mini-proyecto

Si quieres, te lo convierto a un tema listo para entregar (con teoría + ejercicios + soluciones) orientado a FP: dificultad progresiva, checklist de evaluación y 10-12 ejercicios típicos (parseo, formateo, diferencias, zonas, etc.).
