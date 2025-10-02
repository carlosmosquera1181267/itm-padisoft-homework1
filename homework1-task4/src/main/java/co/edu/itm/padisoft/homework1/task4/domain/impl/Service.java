package co.edu.itm.padisoft.homework1.task4.domain.impl;

import co.edu.itm.padisoft.homework1.task4.domain.interfaces.IService;

public class Service implements IService {

    private String type;
    private int estimatedTime;
    private String description;

    public Service(String type, int estimatedTime, String description) {
        this.type = type;
        this.estimatedTime = estimatedTime;
        this.description = description;
    }

    @Override
    public IService clone() {
        return new Service(this.type, this.estimatedTime, this.description);
    }

    @Override
    public void showDetails() {
        String message = String.format("""
                Service: %s
                Estimated time: %s min
                Description: %s
                """, type, estimatedTime, description);
        System.out.println(message);
    }

    @Override
    public String getType() {
        return this.type;
    }
}
