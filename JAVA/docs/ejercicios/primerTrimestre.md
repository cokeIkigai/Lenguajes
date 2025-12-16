// EJERCICIOS JAVA - DESDE CERO

// ======= NIVEL 1: VARIABLES BÁSICAS =======

// 1. Crea una variable entera llamada 'edad' con valor 25

// 2. Crea una variable double llamada 'precio' con valor 19.99

// 3. Crea una variable String llamada 'nombre' con tu nombre

// 4. Crea una variable boolean llamada 'activo' con valor true

// 5. Declara una constante PI con valor 3.1416 usando 'final'

// 6. Crea una variable char llamada 'inicial' con la primera letra de tu nombre

// ======= NIVEL 2: ARRAYS =======

// 7. Crea un array de enteros con los números 1 al 5

// 8. Crea un array de Strings con 3 nombres de frutas

// 9. Accede al tercer elemento de un array llamado 'numeros'

// 10. Cambia el valor de la segunda posición de un array 'colores' a "azul"

// 11. Recorre con for un array 'precios' y suma todos los valores

// 12. Encuentra el número mayor en un array 'temperaturas'

// 13. Crea un array bidimensional 3x3 para representar un tablero

// ======= NIVEL 3: ARRAYLIST =======

// 14. Crea un ArrayList de Strings llamado 'listaTareas'

// 15. Añade 3 elementos a un ArrayList 'nombres'

// 16. Elimina el segundo elemento de un ArrayList 'productos'

// 17. Recorre un ArrayList 'edades' y calcula el promedio

// 18. Convierte un array normal a ArrayList

// 19. Ordena alfabéticamente un ArrayList 'palabras'

// 20. Busca si existe "Java" en un ArrayList 'lenguajes'

// ======= NIVEL 4: LIST (Interfaz) =======

// 21. Declara una List<String> e instanciala como ArrayList

// 22. Crea una List<Integer> con valores del 1 al 10

// 23. Usa List para almacenar objetos 'Persona'

// 24. Filtra de una List<Integer> los números mayores a 5

// 25. Convierte List a array usando toArray()

// ======= NIVEL 5: BUCLES - ELIGE EL ADECUADO =======

// 26. Imprime números del 1 al 10 (¿for, while o do-while?)

// 27. Pide números hasta que se ingrese 0 (¿for, while o do-while?)

// 28. Intenta adivinar un número secreto con máximo 5 intentos (¿for, while o do-while?)

// 29. Muestra un menú hasta que usuario elija "salir" (¿for, while o do-while?)

// 30. Calcula factorial de un número (¿for, while o do-while?)

// 31. Valida que una contraseña tenga mínimo 8 caracteres (¿for, while o do-while?)

// ======= NIVEL 6: CONDICIONALES =======

// 32. Si 'edad' es mayor o igual a 18, muestra "Mayor de edad"

// 33. Si 'nota' está entre 5 y 6.9 muestra "Aprobado", entre 7-8.9 "Notable", 9-10 "Sobresaliente"

// 34. Usa switch para mostrar el día de la semana según número (1=Lunes, 2=Martes...)

// 35. Si 'saldo' es negativo, muestra "En rojo", si es 0 "Sin saldo", positivo "Saldo ok"

// 36. Verifica si un año es bisiesto usando múltiples condiciones

// 37. Según 'operador' (+, -, *, /), realiza la operación correspondiente entre a y b

// 38. Si 'usuario' es "admin" Y 'password' es "1234", permite acceso

// 39. Si es fin de semana (sábado o domingo) Y no está lloviendo, muestra "Parque"

// ======= NIVEL 7: CLASES BÁSICAS =======

// 40. Crea clase 'Libro' con atributos: titulo, autor, paginas (solo estos)

// 41. A la clase 'Libro', añade constructor vacío

// 42. A la clase 'Libro', añade constructor con todos los parámetros

// 43. A la clase 'Libro', añade getters SOLO para titulo y autor

// 44. A la clase 'Libro', añade setters SOLO para paginas

// 45. Crea clase 'CuentaBancaria' con atributos: numeroCuenta, saldo (privados)

// 46. A 'CuentaBancaria', añade getter para saldo PERO NO setter para saldo

// 47. Crea clase 'Coche' con marca, modelo, velocidad (marca privada, otros públicos)

// 48. A 'Coche', añade constructor que reciba solo marca y modelo


// ======= NIVEL 8: MÉTODOS DIVERSOS =======

// 49. En clase 'Calculadora', crea método static 'sumar' que reciba dos ints

// 50. En clase 'Calculadora', crea método 'restar' NO static que reciba dos doubles

// 51. En clase 'Persona', crea método void 'saludar' que imprima "Hola, soy [nombre]"

// 52. En clase 'Circulo', crea método 'calcularArea' que retorne double

// 53. En clase 'Estudiante', crea método 'estaAprobado' que retorne boolean

// 54. En clase 'Producto', crea método 'aplicarDescuento' que modifique el precio

// 55. En clase 'Utilidades', crea método static 'generarID' que retorne String aleatorio

// 56. En clase 'Figura', crea método abstracto 'calcularArea'

// 57. En clase 'GestorArchivos', crea método static 'contarLineas' que reciba String ruta

// ======= NIVEL 9: INSTANCIAS Y MAIN =======

// 58. En main, crea una instancia de 'Libro' usando constructor vacío

// 59. En main, crea una instancia de 'Libro' usando constructor con parámetros

// 60. Usando la instancia de Libro, llama al método setter para cambiar páginas

// 61. Usando la instancia de Libro, obtén el título con getter y muéstralo

// 62. Crea un array de 3 objetos 'Persona' con datos diferentes

// 63. Recorre el array de Personas y llama al método 'saludar' de cada una

// 64. Crea una List<Coche> y añade 2 instancias de Coche

// 65. En main, llama a Calculadora.sumar(5, 3) y muestra resultado

// 66. Modifica el saldo de una CuentaBancaria usando su método depositar(100)

// 67. Intenta acceder directamente a un atributo privado (debería fallar)

// 68. Crea un objeto, modifica sus atributos, y muestra el antes/después

// 69. En main, maneja una excepción si se divide por cero

// 70. Crea un menú en main que permita crear y gestionar objetos Persona

// ======= NIVEL 10: EJERCICIOS INTEGRADORES =======

// 71. Crea sistema de reservas: clase Reserva, array de Reservas en main

// 72. Simula carrito compras: clase Producto, ArrayList en main para carrito

// 73. Juego simple: clase Jugador, turnos con while, condiciones de victoria

// 74. Gestor contactos: buscar por nombre, agregar, eliminar

// 75. Simulador banco: transferencias entre cuentas, historial

// 76. To-Do List: marcar tareas completadas, filtrar por estado

// 77. Sistema votación: clase Candidato, contar votos, mostrar ganador

// 78. Inventario: clase Item, control stock, alerta stock bajo

// 79. Agenda eventos: ordenar por fecha, eventos próximos

// 80. Juego piedra-papel-tijera: 3 rondas, contador puntos

