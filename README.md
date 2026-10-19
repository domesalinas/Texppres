# Texppres — Sistema Inteligente de Gestión Logística y Encomiendas

## 1. Descripción del proyecto

Texppres es un proyecto desarrollado para la asignatura de **Programación III: Estructuras de Datos y Algoritmos en Java**. Su propósito es contribuir a la organización y gestión de las operaciones logísticas relacionadas con el transporte de mercancías y encomiendas.

El proyecto surge de la necesidad de coordinar la información de los vehículos de carga, las rutas, los horarios de despacho, los conductores y el seguimiento de los envíos. La información desorganizada o desactualizada puede ocasionar demoras, asignaciones inadecuadas y dificultades para conocer el estado de las encomiendas.

Como propuesta de solución, Texppres contempla cinco módulos funcionales que permiten organizar la información de las operaciones logísticas y establecer una base para incorporar estructuras de datos y algoritmos que faciliten la búsqueda, la planificación y el control del transporte.

## 2. Objetivos del proyecto

### Objetivo general

Diseñar y desarrollar un sistema de gestión logística y encomiendas que permita organizar la información de los vehículos, las rutas, los horarios de despacho, los conductores y los envíos, mediante el uso de programación orientada a objetos, estructuras de datos y algoritmos en Java.

### Objetivos específicos

- Organizar la información de los vehículos de carga y sus características operativas.
- Gestionar las rutas logísticas y los horarios de despacho.
- Registrar y controlar las encomiendas y sus guías de envío.
- Administrar la información y la asignación del personal de reparto y los conductores.
- Generar información de apoyo para los reportes, la trazabilidad y los indicadores de desempeño logístico.

## 3. Integrantes del Grupo 9 y módulos asignados

| Integrante | Módulo asignado |
|---|---|
| Doménica Salinas | Módulo 1: Gestión de Flotas y Vehículos de Carga |
| Isabella Albuja | Módulo 2: Gestión de Rutas de Logística y Horarios de Despacho |
| Martín H. | Módulo 3: Control de Inventario de Encomiendas y Guías de Envío |
| Jordy | Módulo 4: Asignación y Control de Personal de Reparto y Conductores |
| Martín C. | Módulo 5: Reportes, Trazabilidad e Indicadores KPI |

## 4. Módulos funcionales

### Módulo 1. Gestión de Flotas y Vehículos de Carga

Administra la información de los vehículos que forman parte de la flota, incluyendo su identificación, marca, modelo, capacidad de carga y estado operativo. Esta información sirve de apoyo para organizar los recursos de transporte.

**Clases de dominio:**
- `GestionFlota.java`
- `Vehiculo.java`

### Módulo 2. Gestión de Rutas de Logística y Horarios de Despacho

Organiza los trayectos logísticos, los puntos de origen y destino, las distancias, los tiempos estimados de viaje y los horarios de salida y llegada. Este módulo contempla la planificación y la selección de rutas adecuadas.

**Clases de dominio:**
- `Ruta.java`
- `HorarioDespacho.java`

### Módulo 3. Control de Inventario de Encomiendas y Guías de Envío

Gestiona la información de las encomiendas y sus guías de envío, incluyendo los datos del paquete, los identificadores de seguimiento y los estados asociados al proceso de distribución.

**Clases de dominio:**
- `Encomienda.java`
- `GuiaEnvio.java`

### Módulo 4. Asignación y Control de Personal de Reparto y Conductores

Organiza la información del personal de reparto y los conductores, considerando sus datos de identificación, licencias, disponibilidad y turnos de trabajo para apoyar la coordinación de las operaciones de transporte.

**Clases de dominio:**
- `Conductor.java`
- `Turno.java`

### Módulo 5. Reportes, Trazabilidad e Indicadores KPI

Contempla la organización de la información necesaria para realizar el seguimiento de las operaciones logísticas y generar reportes e indicadores relacionados con los envíos y el desempeño del sistema.

**Clases de dominio:**
- `Reporte.java`
- `Trazabilidad.java`

## 5. Tecnologías utilizadas

- **Lenguaje de programación:** Java.
- **Paradigma de programación:** programación orientada a objetos.
- **Estructuras de datos y algoritmos:** se incorporarán de acuerdo con los requerimientos y las siguientes etapas del proyecto.
- **Control de versiones:** Git.
- **Repositorio del proyecto:** GitHub.

## 6. Estructura inicial del repositorio

La estructura prevista para el repositorio es la siguiente:

```text
Texppres/
├── README.md
├── .gitignore
└── src/
    ├── GestionFlota.java
    ├── Vehiculo.java
    ├── Ruta.java
    ├── HorarioDespacho.java
    ├── Encomienda.java
    ├── GuiaEnvio.java
    ├── Conductor.java
    ├── Turno.java
    ├── Reporte.java
    └── Trazabilidad.java
```



