# 🔢 Algoritmos

## 🚩 1. Concepto general de algoritmo

Un **algoritmo** es una secuencia `finita` y `ordenada` de pasos diseñada para resolver un problema específico. 



Un **algoritmo** convierte datos de entrada en resultados útiles siguiendo una lógica clara.

### 📍 Propiedades fundamentales

1️⃣ **Claridad**: Cada instrucción es inequívoca.

2️⃣ **Finitud**: Debe terminar.

3️⃣ **Determinismo**: Para la misma entrada, produce la misma salida.

4️⃣ **Estructura**: Entrada → Proceso → Salida.

5️⃣ **Eficiencia**: Minimiza tiempo y recursos.

---

## 🚩 2. Componentes modernos de un algoritmo

### 📍 Entrada
Datos proporcionados por el usuario, sensores o sistemas.

### 📍 Procesamiento
Transformación mediante operaciones como:
- Cálculo matemático.
- Comparación lógica.
- Búsquedas.
- Ordenaciones.
- Estructuras de control (bucles, decisiones).
- Algoritmos recursivos.

### 📍 Salida
Resultado final: texto, número, acción, gráfico, mensaje, decisión automatizada.

---

## 🚩 3. Representación de algoritmos

### A. Pseudocódigo
Lenguaje híbrido que facilita el diseño previo al código.

#### Saludar según la hora del día

```console
INICIO
LEER hora

SI hora < 12 ENTONCES
ESCRIBIR "Buenos días"
SINO SI hora < 20 ENTONCES
ESCRIBIR "Buenas tardes"
SINO
ESCRIBIR "Buenas noches"
FIN SI
FIN
```

#### Decidir si una persona puede entrar a un local

```console
INICIO
LEER edad

SI edad >= 18 ENTONCES
ESCRIBIR "Puedes entrar"
SINO
ESCRIBIR "No puedes entrar"
FIN SI
FIN
```
---

