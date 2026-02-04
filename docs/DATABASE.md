# 🗄️ Diseño de la Base de Datos

Este documento describe el diseño de la base de datos utilizada en el proyecto **TeachMe**.
La base de datos fue diseñada teniendo en cuenta los actores del sistema, los requerimientos funcionales y la necesidad de mantener una estructura clara y escalable.

---

## 📦 Entidades Principales

### 1. `alumno`

Representa a los estudiantes que utilizan la aplicación.

**Atributos:**

| Campo | Tipo | Descripción |
| :--- | :--- | :--- |
| `alumno_id` | INT (PK) | Identificador único del alumno (Auto Incremental) |
| `nombre` | VARCHAR (100) | Nombre del alumno |
| `apellido` | VARCHAR (100) | Apellido del alumno |
| `email` | VARCHAR (150) | Correo electrónico (Único) |
| `password` | VARCHAR (255) | Hash de la contraseña |
| `fecha_registro` | TIMESTAMP | Fecha de registro del alumno |

---

### 2. `tutor`

Representa a los tutores disponibles para dictar clases particulares.

**Atributos:**

| Campo | Tipo | Descripción |
| :--- | :--- | :--- |
| `tutor_id` | INT (PK) | Identificador único del tutor (Auto Incremental) |
| `nombre` | VARCHAR (100) | Nombre del tutor |
| `apellido` | VARCHAR (100) | Apellido del tutor |
| `email` | VARCHAR (150) | Correo electrónico (Único) |
| `descripcion` | TEXT | Descripcion o información del tutor |
| `precio_hora` | DECIMAL (10,2) | Precio por hora de las clases |
| `latitud` | DECIMAL (9,6) | Latitud de la ubicación del tutor |
| `longitud` | DECIMAL (9,6) | Longitud de la ubicación del tutor |
| `fecha_registro` | TIMESTAMP | Fecha de registro del tutor |

---

### 3. `materia`

Representa las materias o áreas de conocimiento disponibles.

**Atributos:**

| Campo | Tipo | Descripción |
| :--- | :--- | :--- |
| `materia_id` | INT (PK) | Identificador de la materia (Auto Incremental) |
| `nombre` | VARCHAR (100) | Nombre de la materia |

---

### 4. `clase`

Representa una clase particular solicitada por un alumno.

**Atributos:**

| Campo | Tipo | Descripción |
| :--- | :--- | :--- |
| `clase_id` | INT (PK) | Identificador de la clase (Auto Incremental) |
| `alumno_id` | INT (FK) | Referencia a `alumno_id` (Tabla Alumno) |
| `tutor_id` | INT (FK) | Referencia a `tutor_id` (Tabla Tutor) |
| `materia_id` | INT (FK) | Materia solicitada, referencia a `materia_id` (Tabla Materia) |
| `fecha` | DATE | Fecha de la clase reservada |
| `hora` | TIME | Hora de la clase reservada |
| `estado` | ENUM | Estado: `'PENDIENTE'`, `'CONFIRMADO'`, `'COMPLETADO'`, `'CANCELADO'` |

---

### 5. `disponibilidad`

Representa los horarios disponibles de un tutor.

**Atributos:**

| Campo | Tipo | Descripción |
| :--- | :--- | :--- |
| `disponibilidad_id` | INT (PK) | Identificador de la disponibilidad (Auto Incremental) |
| `tutor_id` | INT (FK) | El tutor dueño del horario, referencia a `tutor_id` (Tabla Tutor) |
| `dia_semana` | VARCHAR (20) | Día de la semana |
| `hora_inicio` | TIME | Hora de inicio de la clase |
| `hora_fin` | TIME | Hora de fin de la clase |

---

### 6. `reseña`

Representa la valoración realizada por un alumno sobre un tutor.

**Atributos:**

| Campo | Tipo | Descripción |
| :--- | :--- | :--- |
| `resena_id` | INT (PK) | Identificador de la reseña (Auto Incremental) |
| `alumno_id` | INT (FK) | Alumno que realiza la reseña, referencia a `alumno_id` (Tabla Alumno) |
| `tutor_id` | INT (FK) | Tutor al que se le asigna la reseña, referencia a `tutor_id` (Tabla Tutor) |
| `puntuacion` | INT / CHECK | Puntuacion entre 1 y 5 |
| `comentario` | TEXT | Comentario acerca del tutor o la clase |
| `fecha` | TIMESTAMP | Fecha de registro de la reseña |

---

### 7. `tutor_materia`

Representa la relación entre tutores y materias que brindan.

**Atributos:**

| Campo | Tipo | Descripción |
| :--- | :--- | :--- |
| `tutor_id / materia_id` | INT (PK) | Identificador de la relación `tutor_materia` |
| `tutor_id` | INT (FK) | Tutor encargado, referencia a `tutor_id` (Tabla Tutor) |
| `materia_id` | INT (FK) | Materia que se brinda, referencia a `materia_id` (Tabla Materia) |

---

## 🔗 Relaciones entre Entidades

### Relación Alumno – Clase
- Un alumno puede solicitar muchas clases
- Cada clase pertenece a un único alumno
- Relación **1 a N**

---

### Relación Tutor – Clase
- Un tutor puede dictar muchas clases
- Cada clase es dictada por un solo tutor
- Relación **1 a N**

---

### Relación Tutor – Materia
- Un tutor puede enseñar varias materias
- Una materia puede ser enseñada por varios tutores
- Relación **N a N**
- Implementada mediante la tabla intermedia `tutor_materia`

---

### Relación Tutor – Disponibilidad
- Un tutor puede tener varios horarios disponibles
- Relación **1 a N**

---

### Relación Alumno – Reseña
- Un alumno puede realizar varias reseñas
- Relación **1 a N**

---
