# 🎨 Diseño de la Aplicación – TeachMe

En esta sección se documenta el diseño visual y funcional de la aplicación **TeachMe**, incluyendo la estructura de la interfaz, la navegación y la disposición de los elementos visuales utilizando la herramienta **Figma**.

---

## 🔗 Enlace al Proyecto en Figma

El diseño completo de la aplicación se encuentra disponible en el siguiente enlace:

👉 **[Proyecto TeachMe – Figma](https://www.figma.com/design/Bqri2majlakdtjara5u0Dg/Tutors-App?node-id=0-1&t=BqJZF0ibqjQ8Q9t5-1)**  

---

## 📱 Pantallas Diseñadas

Pantallas principales que componen la aplicación desde el punto de vista del **alumno**, actor principal del sistema.

---

### 1. Pantalla de Bienvenida

Pantalla inicial de la aplicación.

**Función:**
- Presentar la aplicación al usuario
- Permitir acceder al inicio de sesión o al registro

---

### 2. Pantalla de Registro

Permite al alumno crear una cuenta en la aplicación.

**Elementos principales:**
- Campos de datos personales
- Botón de registro
- Validaciones básicas

---

### 3. Pantalla de Inicio de Sesión

Permite al alumno ingresar a la aplicación.

**Elementos principales:**
- Campos de email y contraseña
- Botón de acceso
- Enlace para recuperación de contraseña

---

### 4. Pantalla Principal (Home)

Pantalla principal luego del inicio de sesión.

**Función:**
- Acceso rápido a las funcionalidades principales
- Navegación hacia búsqueda de tutores, clases y perfil

---

### 5. Pantalla de Búsqueda de Tutores

Permite al alumno buscar tutores según la materia.

**Función:**
- Selección de materia
- Visualización de resultados
- Acceso al perfil del tutor

---

### 6. Pantalla de Perfil del Tutor

Muestra la información detallada de un tutor.

**Elementos principales:**
- Datos personales
- Materias que enseña
- Precio por hora
- Descripción
- Calificación

---

### 7. Pantalla de Disponibilidad del Tutor

Permite visualizar los horarios disponibles del tutor.

**Función:**
- Seleccionar fecha y horario
- Solicitar una clase particular

---

### 8. Pantalla de Mis Clases

Permite al alumno gestionar sus clases.

**Función:**
- Visualizar clases solicitadas
- Consultar estado de cada clase

---

### 9. Pantalla de Detalle de Clase

Muestra información detallada de una clase.

**Función:**
- Visualizar datos del tutor
- Ver estado de la clase
- Acceder a opciones según el estado

---

### 10. Pantalla de Perfil del Alumno

Permite visualizar y gestionar la información personal del alumno.

**Función:**
- Visualización de datos personales
- Cierre de sesión

---

## 🧭 Navegación de la Aplicación

La navegación entre pantallas se realiza mediante:

- Fragments
- Navigation Component
- Barra de navegación inferior

---

