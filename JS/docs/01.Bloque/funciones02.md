📚 Funciones útiles en JavaScript (guía rápida)
🔹 Arrays (las más usadas)
const arr = [1, 2, 3, 4];
map → transformar
arr.map(x => x * 2);
filter → filtrar
arr.filter(x => x > 2);
reduce → acumular
arr.reduce((acc, x) => acc + x, 0);
forEach → recorrer
arr.forEach(x => console.log(x));
find → primer elemento que cumple
arr.find(x => x > 2);
some → alguno cumple
arr.some(x => x > 3);
every → todos cumplen
arr.every(x => x > 0);
🔹 Strings
const texto = " Hola Mundo ";
trim() → quitar espacios
texto.trim();
toUpperCase() / toLowerCase()
texto.toUpperCase();
includes()
texto.includes("Mundo");
split()
texto.split(" ");
🔹 Números
parseInt() / parseFloat()
parseInt("10");
Number()
Number("123");
toFixed()
(3.1416).toFixed(2); // "3.14"
🔹 Objetos
const obj = { a: 1, b: 2 };
Object.keys()
Object.keys(obj); // ["a","b"]
Object.values()
Object.values(obj); // [1,2]
Object.entries()
Object.entries(obj);
🔹 JSON
JSON.parse('{"a":1}');
JSON.stringify({a:1});
🔹 Utilidades
console.log() → debug
setTimeout()
setTimeout(() => console.log("Hola"), 1000);
setInterval()
setInterval(() => console.log("Tick"), 1000);
