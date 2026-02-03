# 🧩 Análisis del Sistema

Esta sección describe el análisis del sistema correspondiente al proyecto **TeachMe**.  
El análisis contempla la descripción del problema, los actores del dominio, los requerimientos principales y algunos casos de uso relevantes.

---

## 📌 Descripción del Problema

En la actualidad, muchos estudiantes tienen dificultades para encontrar tutores o profesores particulares que se adapten a sus necesidades académicas, horarios y ubicación. La búsqueda suele realizarse de manera informal o mediante distintas plataformas, lo que vuelve el proceso lento y poco organizado.

Además, no siempre es sencillo comparar opciones, conocer la disponibilidad real de los tutores o gestionar las clases de forma clara. Por este motivo, surge la necesidad de una aplicación que centralice esta información y permita a los estudiantes acceder de manera simple a clases particulares, facilitando la búsqueda, selección y gestión de tutorías desde el celular.

---

## 👥 Actores del Dominio

### 1. Estudiante

Es el usuario principal de la aplicación.

**Responsabilidades:**
- Buscar tutores según materia
- Visualizar información de tutores
- Solicitar clases particulares
- Gestionar sus clases
- Consultar ubicaciones y disponibilidad

---

### 2. Tutor

Es el proveedor del servicio educativo.

**Responsabilidades:**
- Ofrecer tutorías en una o más materias
- Definir disponibilidad horaria
- Brindar clases a los alumnos

> Nota: En este proyecto, el tutor no es el foco principal de la aplicación móvil, sino un actor de soporte.

---

### 3. Sistema / Backend

Sistema que administra la información y la lógica del negocio.

**Responsabilidades:**
- Gestionar usuarios y datos
- Almacenar información en la base de datos
- Proveer datos a la aplicación móvil mediante una API REST

---

## ⚙️ Requerimientos del Sistema

La aplicación TeachMe debe satisfacer los siguientes requerimientos principales desde el punto de vista del alumno:

### 1. Gestión de Usuarios
- El alumno debe poder registrarse en la aplicación
- Iniciar y cerrar sesión
- Visualizar y editar su perfil

---

### 2. Búsqueda de Tutores
- Buscar tutores por materia
- Visualizar un listado de tutores disponibles
- Acceder al perfil detallado de un tutor

---

### 3. Visualización de Información
- Mostrar información básica del tutor (nombre, materias, experiencia)
- Visualizar ubicación del tutor mediante un mapa
- Consultar disponibilidad horaria

---

### 4. Gestión de Clases
- Solicitar una clase particular
- Visualizar clases solicitadas
- Consultar el estado de una clase (pendiente, confirmada, finalizada)

---

### 5. Uso del Dispositivo
- Manejo de permisos (ubicación)
- Almacenamiento local de datos
- Uso de preferencias del usuario (SharedPreferences)

---

## 📘 Casos de Uso

### Caso de Uso 1: Buscar Tutor por Materia

**Actor:** Alumno  
**Descripción:**  
El alumno ingresa a la aplicación y busca tutores disponibles para una materia específica.

**Flujo básico:**
1. El alumno selecciona una materia
2. El sistema muestra una lista de tutores
3. El alumno selecciona un tutor para ver su perfil

---

### Caso de Uso 2: Ver Perfil de Tutor

**Actor:** Alumno  
**Descripción:**  
El alumno visualiza la información detallada de un tutor seleccionado.

**Flujo básico:**
1. El alumno selecciona un tutor
2. El sistema muestra su información, materias y ubicación

---

### Caso de Uso 3: Solicitar Clase Particular

**Actor:** Alumno  
**Descripción:**  
El alumno solicita una clase con un tutor.

**Flujo básico:**
1. El alumno selecciona un tutor
2. Indica la materia y horario
3. El sistema registra la solicitud

---

### Caso de Uso 4: Visualizar Clases

**Actor:** Alumno  
**Descripción:**  
El alumno consulta las clases solicitadas o confirmadas.

**Flujo básico:**
1. El alumno accede a la sección de clases
2. El sistema muestra el listado correspondiente

---

