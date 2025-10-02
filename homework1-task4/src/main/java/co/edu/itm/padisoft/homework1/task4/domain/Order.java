package co.edu.itm.padisoft.homework1.task4.domain;

import co.edu.itm.padisoft.homework1.task4.domain.interfaces.IService;
import co.edu.itm.padisoft.homework1.task4.domain.interfaces.ITechnician;

import java.time.LocalDateTime;
import java.util.UUID;

public class Order {


    private UUID id;
    private Client client;
    private ITechnician technician;
    private IService service;
    String status;
    LocalDateTime date;

    public Order(UUID id, Client client, IService service) {
        this.id = id;
        this.client = client;
        this.service = service;
        this.status = "PENDING";
        this.date = LocalDateTime.now();
    }

    public void assignTechnician(ITechnician technician) {
        this.technician = technician;
        this.status = "ASSIGNED";
    }

    public void updateStatus(String newStatus) {
        this.status = newStatus;
    }

    public void showOrder() {
        String message = String.format("""
                Order id: %s
                Status: %s
                Date: %s
                """, id, status, date);
        System.out.println(message);
        System.out.println(client.showDetails());
        System.out.println("Requested service: ");
        service.showDetails();

        if (technician != null) {
            System.out.println("Technician: ");
            technician.showInfo();
        }
    }

    public UUID getId() {
        return id;
    }

    public Client getClient() {
        return client;
    }
}
