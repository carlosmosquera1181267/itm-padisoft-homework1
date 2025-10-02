package co.edu.itm.padisoft.homework1.task4;

import co.edu.itm.padisoft.homework1.task4.business.PrototypeCatalog;
import co.edu.itm.padisoft.homework1.task4.domain.Client;
import co.edu.itm.padisoft.homework1.task4.domain.Order;
import co.edu.itm.padisoft.homework1.task4.domain.interfaces.IService;
import co.edu.itm.padisoft.homework1.task4.domain.interfaces.ITechnician;
import co.edu.itm.padisoft.homework1.task4.repository.OrderManager;

import java.util.UUID;

public class Main {
    public static void main(String[] args) {

        StringBuffer sb = new StringBuffer();
        sb.append("""
                 ╔════════════════════════════════════════════════╗
                 ║    SISTEMA DE CONEXIÓN HOGAR - TÉCNICO         ║
                 ║    Patrones: Prototype + Singleton             ║
                 ╚════════════════════════════════════════════════╝
        """);

        // Inicializar el Catalogo de prototipos
        PrototypeCatalog catalog = new PrototypeCatalog();

        // Obtener la instancia unica del gestor de datos
        OrderManager manager = OrderManager.getInstance();

        // Demostrar que es Singleton
        OrderManager manager2 = OrderManager.getInstance();
        sb.append("Es la misma instancia? ");
        sb.append(manager.equals(manager2));

        // Crear clientes
        Client client1 = new Client(
                "Carlos",
                "Rodríguez",
                "carlos@email.com",
                "300-123-4567",
                "Calle 10 #20-30, Medellín"
        );

        Client client2 = new Client(
                "Ana",
                "Martínez",
                "ana@email.com",
                "301-987-6543",
                "Carrera 50 #45-67, Medellín"
        );

        // Clonar servicios desde prototipos (PROTOTYPE)
        sb.append("\r\n--- Clonando servicios desde prototipos ---");
        IService plumberService = catalog.cloneService("plomeria");
        IService electricityService = catalog.cloneService("electricidad");

        // Clonar técnicos desde prototipos
        sb.append("\r\n--- Clonando técnicos desde prototipos ---");
        ITechnician plumber = catalog.cloneTechnician("plomero1");
        ITechnician electricity = catalog.cloneTechnician("electricista1");

        // Creacion de Ordenes
        sb.append("\r\n========== CREACION DE ORDENES ==========");
        String uuid1 = UUID.randomUUID().toString();
        String uuid2 = UUID.randomUUID().toString();

        Order order1 = manager2.createOrder(uuid1, client1, plumberService);
        Order order2 = manager.createOrder(uuid2, client2, electricityService);

        // Asignar tecnicos
        sb.append("\r\n========== ASIGNACIÓN DE TECNICOS ==========");
        manager.assignTechnician(uuid1, plumber);
        manager.assignTechnician(uuid2, electricity);

        System.out.println(sb.toString());
        manager2.getAllOrders();
        System.out.println("""
                ╔════════════════════════════════════════════════╗
                ║           DEMO COMPLETADA                      ║
                ╚════════════════════════════════════════════════╝
                """);

    }
}