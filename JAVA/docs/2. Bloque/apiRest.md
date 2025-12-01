# 💻 ¿Qué es una API REST?
Una `API REST` es una forma de comunicar aplicaciones entre sí usando **HTTP** (el mismo protocolo que usa tu navegador). 

Permite que un cliente (una web, app móvil, programa…):
- Pueda `pedir` datos. 
- `Enviar` información a un servidor siguiendo unas reglas estándar.
  
---

### ↔️ REST = Representational State Transfer
Es un estilo de arquitectura basado en estos principios:

- **Cliente–Servidor**: 
    El cliente pide datos → el servidor responde.

- **Sin estado (stateless)**: 
    Cada petición contiene toda la información necesaria. El servidor no recuerda peticiones anteriores.

- **Uso de HTTP y sus métodos**: GET, POST, PUT, PATCH, DELETE.

- **Recursos**: Todo se trata como un recurso (usuarios, pedidos, productos…).

<img src="../../img/apiRest1.png" alt="API_REST" width="600" />
