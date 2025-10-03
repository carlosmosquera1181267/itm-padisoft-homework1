# Diagrama de Clases - Patrones Prototype y Singleton

Este diagrama muestra la aplicacion de los patrones creacionales Prototype y Singleton
de acuerdo a la tematica del proyecto de grado que se esta desarrollando. 

## Contexto
Dentro del proyecto de grado se esta planteando desarrollar una plataforma digital que permita solicitar de manera ágil la ayuda de expertos en servicios técnicos generales incorporando mecanismos de validación y seguridad para garantizar la confiabilidad de la atención. En este ejercicio el alcance es mas pequeño y representativo para cumplir con los patrones indicados. 

## Ejemplo de ejecucion
En el archivo [Main.java](../src/main/java/co/edu/itm/padisoft/homework1/task4/Main.java) tiene una representacion de la ejecucion de la aplicacion el cual sera descrito en los siguientes pasos:

### Definicion de los cliente
Se inician 2 clientes con diferente informacion, estos son los usuarios que solicitaran servicios de diferentes tecnicos

### Clonar Servicios desde prototipos
Se crean instancias basadas en el patron prototype de los servicios de plomeria y electricidad, se clona desde un servicio existente precargado por defecto en el sistema.

### Clonar Tecnicos desde prototipos
Se crean instancias de tecnicos basado un plomero y un electricista, se clonan desde un mapa de tecnicos por defecto que tiene cargada la aplicacion.

### Creacion de Ordenes (Conexion Cliente - Tecnico)
En este paso se utiliza una clase [OrderManager](../src/main/java/co/edu/itm/padisoft/homework1/task4/repository/OrderManager.java) la cual simula un repositorio y es la encargada de crear la ordenes (cita de un servicio tecnico con un cliente), asignarle un tecnico a una orden y listar las ordenes.

En este caso la clase [OrderManager](../src/main/java/co/edu/itm/padisoft/homework1/task4/repository/OrderManager.java) fue diseñada utilizando el patron Singleton para almacenar las ordenes en una unica instancia es decir en el mismo sector de memoria.

### Asignacion de Tecnicos
En esta seccion se muestra como ase asigna a una orden un tecnico basado en sus habilidades.

### Listar las Ordenes creadas
En la ultima seccion del proceso se imprimen las ordenes creadas mostrando los datos del servicio solicitado y el tecnico asignado.


```mermaid
classDiagram
    class Client {
        -String firstName
        -String lastName
        -String address
        -String phoneNumber
        -String email
        +String showDetails()
    }
    class IService {
        <<interface>>
        +Iservice clone()
        +showDetails()
        +String getType()
    }
    class Service {
        -String type
        -int estimatedTime
        -String description
        +IService clone()
        +showDetails()
        +String getType
    }
    Service --|> IService
    class ITechnician {
        <<interface>>
        +ITechnician clone()
        +String showFullName()
        +boolean isAvalaible()
        +showInfo()
    }
    class Technician {
        -String firstName
        -String lastName
        -double rate
        -List<String> skills
        -boolean available
        +ITechnician clone()
        +String showFullName()
        +boolean isAvalaible()
        +showInfo()
    }
    ITechnician --|> Technician
    class Order {
        -String id
        -Client client
        -ITechnician technician
        -IService service
        -Date orderDate
        -String status
        +assignTechnician(ITechnician technician)
        +updateStatus(String status)
        +showOrder()
    }
    Order ..> Client
    Order ..> IService
    Order ..> ITechnician
    class OrderManager {
        -OrderManager instance
        -List<Order> orders
        -OrderManager()
        +OrderManager getInstance()
        +Order createOrder(String orerId, Client cliente, IService service)
        +assignTechnician(String orderId, ITechnician technician)
        +getAllOrders()
        +findById(String orderId)
    }
    OrderManager ..> OrderManager
    OrderManager ..> Order
    OrderManager ..> Client
    OrderManager ..> IService
    OrderManager ..> ITechnician
    class PrototypeCatalog {
        -Map serviceCatalog
        -Map technicianCatalog
        +PrototypeCatalog()
        -loadCatalog()
        +addService(IService service)
        +addtechnician(ITechnician technician)
        +cloneService(String serviceId)
        +cloneTechnician(String technicianId)
    }
    PrototypeCatalog ..> IService
    PrototypeCatalog ..> ITechnician

