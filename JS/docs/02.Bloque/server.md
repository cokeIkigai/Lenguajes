# 🌐 ¿Qué es un servidor?

Un servidor es un programa (o máquina) que está escuchando continuamente y preparado para responder cuando alguien le pide algo. Un servidor no hace nada hasta que alguien le pide algo

- Está activo en un puerto (ej: 3000)
- Espera solicitudes de clientes (navegador, app, etc.)
- Devuelve una respuesta


## 🔁 Tipos de peticiones HTTP (métodos)

Son las distintas formas en las que un cliente puede comunicarse con el servidor según lo que quiere hacer:

📥 **GET** → Obtener datos | Solo pide información | No modifica nada : ```/usuarios``` -> ver datos de usuario

📤 **POST** → Enviar datos | Envía información al servidor | Suele crear algo nuevo :  ```/usuarios``` -> crear usuario

✏️ **PUT** → Reemplazar datos | Actualiza completamente un recurso : ```PUT /usuarios/1``` -> editar todo un objeto

🩹 **PATCH** → Actualizar parcialmente | Modifica solo una parte : ```/usuarios/1``` -> cambiar solo un campo

❌ **DELETE** → Eliminar | Borra un recurso : ```/usuarios/1``` -> eliminar datos
