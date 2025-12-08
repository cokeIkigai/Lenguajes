# Conectar con Bases de Datos

### 1. Bases de datos relacionales (SQL)

Modelan la información en tablas con `filas y columnas` y se basan en el lenguaje [SQL](../../SQL/readme.md).
Características clave:
- Esquema estructurado.
- Integridad referencial (claves primarias y foráneas).
- Muy usadas en aplicaciones empresariales.

`PostgreSQL`  `MySQL / MariaDB`  `SQL Server`  `Oracle DB`

### 2. Bases de datos NoSQL

No usan un modelo tabular fijo. Son más `flexibles` y escalan horizontalmente:
- Los datos son muy cambiantes.
- Necesitas alta escalabilidad.
- El esquema no está cerrado.

`Documentos → MongoDB` `Claves-valor → Redis` `Columnar → assandra` `Grafos → Neo4j`

---

### <img src="https://upload.wikimedia.org/wikipedia/commons/2/29/Postgresql_elephant.svg" alt="PostgreSQL" width="40" /> ¿Qué es PostgreSQL?

`PostgreSQL` es un sistema de gestión de bases de datos relacionales de código abierto, conocido por su fiabilidad, solidez y rendimiento. 

**Instalación:**

Para instalar postgre en múltiples Sistemas operativos debes descargarlo del instalador oficial [PostgreLink](https://www.postgresql.org/download)

- **Ejecutar** el instalador y seleccionar: `PostgreSQL Server` y `pgAdmin4`
- **pgAdmin4** es la herramienta visual para que no se haga todo desde la `consola` y permite realizar múltiples acciones sin comandos.
- **Puerto** → 5432.
---

### <img src="https://upload.wikimedia.org/wikipedia/en/d/dd/MySQL_logo.svg" alt="MySQL" width="80" /> ¿Qué es MySQL?

Uno de los motores SQL más extendidos, muy utilizado en LAMP, WordPress, e-commerce, etc. [mysql](https://dev.mysql.com/downloads/mysql/)

Para instalar MySQL Community en múltiples Sistemas operativos debes descargarlo del instalador oficial [MySQL Community Server LTS](https://www.postgresql.org/download)
- **Ejecutar** el instalador y seleccionar: `MySQL Community Server`.
- **MySQL Workbench** Herramientadel  cliente. [Workbench](https://dev.mysql.com/downloads/workbench/)
- **Puerto** → 3306.

--- 

### <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRxscOaGYIFYKsrgioo7pzV7YpbpkUOJgDe2A&s" alt="MongoDB" width="140" /> ¿Qué es MongoDB?

Es una Base de datos NoSQL orientada a documentos. Guarda datos en formato JSON/BSON. No tiene tablas, sino colecciones. [Mongodb Community](https://www.mongodb.com/try/download/community)

- **Ejecutar** el instalador y seleccionar: `Mongodb Community`.
- **Mongodb Compass** Herramientadel  cliente. [Mongodb Compass](https://www.mongodb.com/try/download/compass)
- **Puerto** → 27017.

Interfaz visual para ver bases de datos, colecciones y documentos.
