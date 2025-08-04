# 🛠️ Sistema de Gestión de Productos

Aplicación en Java basada en consola para gestionar productos usando **JDBC**, **MySQL** y una **arquitectura en capas** (Controller, Service, DAO, DTO).

---

## 📚 Funcionalidades

- Agregar nuevos productos
- Listar todos los productos
- Actualizar productos (actualización parcial soportada)
- Eliminar productos (con validación de existencia)
- Buscar producto por ID
- Manejo de errores de entrada y conexión a base de datos

---

## 🧱 Arquitectura

El proyecto sigue una estructura por capas:

```plaintext
ProductManagement/
├── src/
│   └── main/
│       └── java/
│           ├── controller/
│           │   └── ProductController.java
│           ├── dao/
│           │   ├── ProductDao.java
│           │   └── ProductDaoImpl.java
│           ├── dto/
│           │   ├── ProductCreateDto.java
│           │   ├── ProductResponseDto.java
│           │   └── ProductUpdateDto.java
│           ├── model/
│           │   └── Product.java
│           ├── service/
│           │   └── ProductService.java
│           ├── util/
│           │   ├── ErrorCode.java
│           │   └── JDBCConnectionManager.java
│           └── main/
├── .gitignore
├── docker-compose.yml
├── init.sql
├── pom.xml
└── README.md
```
---

## 🛠️ Tecnologías Utilizadas

- Java 17
- JDBC (conector MySQL)
- MySQL 8.x
- IntelliJ IDEA
- Maven

---


## 🚀 Cómo ejecutar

### 1. Clona el repositorio

Puedes clonar el repositorio con HTTPS o SSH:

#### 🔐 Vía HTTPS

```bash
git clone https://github.com/kritzanyeraldin/ProductManagement.git
cd ProductManagement
```

#### 🔐 Vía SSH

```bash
git clone git@github.com:kritzanyeraldin/ProductManagement.git
cd ProductManagement
```

### 2. Inicia la base de datos con Docker Compose (opcional)
Asegúrate de tener Docker y Docker Compose instalados.
Desde la misma carpeta donde está el archivo docker-compose.yml, ejecuta:
```bash
docker-compose up -d
```
Esto levantará un contenedor de MySQL con la base de datos productdb en el puerto 3306.

Para detener o eliminar el contenedor, se ejecuta
```bash
docker-down
```

### 3. Descarga y agrega el driver JDBC de MySQL

Descarga el conector JDBC desde:  
🔗 [https://dev.mysql.com/downloads/connector/j/](https://dev.mysql.com/downloads/connector/j/)

Extrae el archivo `.jar` (por ejemplo: `mysql-connector-j-8.4.0.jar`) y colócalo en una carpeta `lib/` dentro del proyecto.

Finalmente, ejecuta el proyecto


