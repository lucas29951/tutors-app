# ⚙️ Backend y API

Esta sección documenta el backend del proyecto **TeachMe**, el cual provee una **API REST** utilizada por la aplicación móvil Android para acceder y gestionar los datos del sistema.

El backend se encarga de centralizar la lógica del negocio, el acceso a la base de datos y la comunicación con la aplicación móvil.

---

## 🌐 URL de la API

La API del proyecto se encuentra disponible en la siguiente dirección:

👉 **https://lucasgrod.alwaysdata.net/api/**  

---

## 🛠️ Tecnologías Utilizadas

- Node.js
- Express.js
- MySQL
- API REST
- Arquitectura en capas

---

## 📡 Descripción General

La API expone distintos endpoints que permiten a la aplicación móvil:

- Obtener información de tutores y materias
- Registrar y consultar alumnos
- Solicitar y gestionar clases
- Registrar reseñas y calificaciones

Todos los endpoints utilizan el formato **JSON** para el intercambio de información.

---

## 📌 Endpoints Disponibles

### 👨‍🏫 Tutores

#### `GET /api/tutores`
Obtiene el listado completo de tutores.

**Uso:**  
Mostrar tutores disponibles en la aplicación.

---

#### `GET /api/tutores/materia/{materiaId}`
Obtiene los tutores asociados a una materia específica.

**Uso:**  
Búsqueda de tutores por materia.

---

### 📘 Materias

#### `GET /api/materias`
Obtiene el listado de materias disponibles.

**Uso:**  
Carga de materias para filtros y selección.

---

### 📅 Clases

#### `POST /api/clases`
Registra una nueva solicitud de clase.

**Datos esperados:**
- alumnoId
- tutorId
- materiaId
- fecha
- hora
- estado

**Uso:**  
Solicitud de clases desde la aplicación.

---

#### `GET /api/clases/alumno/{alumnoId}`
Obtiene las clases asociadas a un alumno.

**Uso:**  
Visualización de clases del alumno.

---

### ⭐ Reseñas

#### `POST /api/resenas`
Registra una reseña sobre un tutor.

**Datos esperados:**
- alumnoId
- tutorId
- puntuacion
- comentario

**Uso:**  
Calificación de tutores luego de una clase.

---

#### `GET /api/resenas/tutor/{tutorId}`
Obtiene las reseñas asociadas a un tutor.

**Uso:**  
Visualización de calificaciones y comentarios.

---

### 👤 Alumnos

#### `GET /api/alumnos`
Obtiene el listado de alumnos registrados.

**Uso:**  
Se utiliza para pruebas y validación del sistema.

---

#### `POST /api/alumnos`
Registra un nuevo alumno.

**Datos esperados:**
- nombre
- apellido
- email

**Uso:**  
Registro de alumnos desde la aplicación móvil.

---

## 🔒 Seguridad y Consideraciones

- La comunicación se realiza mediante HTTP/HTTPS
- Los datos se intercambian en formato JSON
- El backend valida la estructura básica de los datos recibidos

---


