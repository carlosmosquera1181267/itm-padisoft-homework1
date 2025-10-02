package co.edu.itm.padisoft.homework1.task4.repository;

import co.edu.itm.padisoft.homework1.task4.domain.Client;
import co.edu.itm.padisoft.homework1.task4.domain.Order;
import co.edu.itm.padisoft.homework1.task4.domain.interfaces.IService;
import co.edu.itm.padisoft.homework1.task4.domain.interfaces.ITechnician;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OrderManager {

    private static OrderManager instance;
    //private int count;
    List<Order> orders;

    private OrderManager() {
        orders = new ArrayList<>();
        //count = 1;
    }

    public static OrderManager getInstance() {
        if (instance == null) {
            instance = new OrderManager();
        }
        return instance;
    }

    public Order createOrder(String orderId, Client client, IService service) {
        Order order = new Order(UUID.fromString(orderId), client, service);
        orders.add(order);
        System.out.println("Order created: " + order.getId());
        return order;
    }

    public Order findById(UUID id) {
        Order oldOlder = orders.stream().filter(order -> id.equals(order.getId())).findFirst().orElse(null);

        if (oldOlder == null) {
            System.out.println("No order found with id: " + id);
        }

        return oldOlder;
    }

    public void assignTechnician(String orderId, ITechnician technician) {
        Order order = findById(UUID.fromString(orderId));
        if (order != null) {
            order.assignTechnician(technician);
            System.out.println("Assigned technician");
        }
    }

    public void getAllOrders() {
        System.out.println("All orders");

        if (orders.isEmpty()) {
            System.out.println("No orders found");
        } else {
            orders.forEach(Order::showOrder);
        }
    }
}
