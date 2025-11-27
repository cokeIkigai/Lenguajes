# 📜Métodos en Java: estructura y retorno de valores

Un **método** es un bloque de código que realiza una acción.  
Puede **retornar un valor** o **no retornar nada**.

---

## 1. Estructura general de un método

```java
[modificador] [tipoRetorno] [nombreMetodo](parámetros) {
    // código
    return valor; // solo si el método debe devolver algo
}
```

#### Partes explicadas:

- `modificador` → public, private, protected…

- `tipoRetorno` → tipo de dato que devuelve (int, String, boolean…) o void.

- `nombreMetodo` → identificador del método.

- `parámetros` → valores que recibe.

- `return` → devuelve un valor (solo si el método no es void).


### 2. Método que NO retorna valor (void)

Se usa para acciones que solo hacen algo, sin devolver datos.

```java
public void saludar(String nombre) {
    System.out.println("Hola " + nombre);
}
```

**Características:**

- void indica que no devuelve nada.

- El método solo ejecuta una instrucción, pero no manda un valor de vuelta.

- No lleva return con valores.

Uso:
```java
saludar("Coke");
```

### 3. Método que Sí retorna un valor

Devuelve un resultado al código que lo llama.
```java
public int sumar(int a, int b) {
    return a + b;
}
```

**Características:**

- El método declara que devuelve un int.

- Está obligado a usar return con un valor del tipo correcto.

- Ese valor puede ser almacenado o usado en otra operación.

Uso:

```java
int resultado = sumar(5, 3); // resultado = 8 
```

### 4. Ejemplo con retorno tipo String
```java
public String obtenerSaludo(String nombre) {
    return "Hola " + nombre;
}
```

### 5 . Diferenciar Devolver e imprimir por consola

```java
public void sumar(int numero1, int numero2) {
    System.out.println("la suma es: " + numero1 + numero2);
}

public int sumar(int numero1, int numero2) {
   return numero1 + numero2;
}

sumar(6 + 5); // Imprime por consola: 'la suma es: 11'
int sumaTotal = sumar(6 + 5); // sumatotal es = 11. Pero no se ve por consola
```

