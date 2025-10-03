# 🧩 Tarea 1, Punto 4 – Patrones de Diseño

Este proyecto fue desarrollado utilizando **Java 21** y demuestra la implementación de **patrones creacionales** adicionales (a los 3 puntos anteriores) de acuerdo a la temática que
estén trabajando en la especialización y utilizando buenas prácticas de diseño orientado a objetos.

---

## 📁 Estructura del Proyecto

```text
homework1-task4/
├── build.gradle.kts         # Script de construcción Gradle en Kotlin DSL
├── settings.gradle.kts      # Nombre y configuración del proyecto
├── gradlew                  # Wrapper para ejecutar Gradle (Linux/macOS)
├── gradlew.bat              # Wrapper para ejecutar Gradle (Windows)
├── gradle/                  # Scripts del wrapper (opcional)
│   └── wrapper/
│       └── gradle-wrapper.properties
├── docs/                    # Documentación adicional
│   └── class_diagram.md     # Diagrama de clases UML en Mermaid
├── src/
│   ├── main/
│   │   ├── java/            # Código fuente en Java
│   │   │   └── co/
│   │   │       └── edu/
│   │   │           └── itm/
│   │   │               └── padisoft/
│   │   │                   └── homework1/
│   │   │                       └── task4/
│   │   │                           ├── Main.java
│   │   │                           └── business
│   │   │                               └── PrototypeCatalog.java
│   │   │                           └── domain
│   │   │                               └── impl
│   │   │                                   ├── Service.java
│   │   │                                   └── Technician.java
│   │   │                               └── interfaces
│   │   │                                   ├── IService.java
│   │   │                                   └── ITechnicial.java
│   │   │                               ├── Client.java
│   │   │                               └── Order.java
│   │   │                           └── repository
│   │   │                               └── OrderManager.java
│   │   └── resources/       # Archivos de configuración o recursos
│   └── test/
│       └── java/            # Código fuente de pruebas (JUnit, etc.)
├── README.md                # Este archivo
└── .gitignore               # Archivos y carpetas ignorados por Git
```

---

## 🛠️ Tecnologías y herramientas

- **Java 21**
- **Mermaid** (para diagramas de clases UML)
- Editor sugerido: VS Code o IntelliJ IDEA
- Opcional: Mermaid CLI o MarkChart para previsualizar Mermaid localmente

---

## 📌 Diagrama de Clases

Puedes ver el **diagrama de clases UML** que representa la arquitectura del proyecto en el siguiente archivo:

👉 [Ver class_diagram.md](docs/class_diagram.md)

> 💡 Este archivo contiene un diagrama Mermaid que se renderiza automáticamente al visualizar el archivo en GitHub.

---

## 🚀 Cómo ejecutar el proyecto

1. Asegúrate de tener **Java 21** instalado.
2. Compila y ejecuta el proyecto desde línea de comandos:

```bash
./gradlew clean build
./gradlew run

