package co.edu.itm.padisoft.homework1.task4.domain.impl;

import co.edu.itm.padisoft.homework1.task4.domain.interfaces.ITechnician;

import java.util.ArrayList;
import java.util.List;

public class Technician  implements ITechnician {

    private String firstName;
    private String lastName;
    private Double rating;
    private List<String> skills;
    private boolean available;

    public Technician(String first, String lastName, Double rating) {
        this.firstName = first;
        this.lastName = lastName;
        this.rating = rating;
        this.skills = new ArrayList<>();
        this.available = true;
    }

    @Override
    public ITechnician clone() {
        Technician clone  = new Technician(this.firstName, this.lastName, this.rating);
        clone.skills = new ArrayList<>(this.skills);
        clone.available = this.available;
        return clone;
    }

    public void addSkill(String skill) {
        this.skills.add(skill);
    }

    @Override
    public void showInfo() {
        String shortAvailable = this.available ? "Yes" : "No";
        String message = String.format("""
                Technician: %s %s
                Skills: %s
                Rating: %s
                Available: %S
                """, firstName, lastName, skills, rating, shortAvailable);
        System.out.println(message);
    }

    @Override
    public boolean isAvailable() {
        return available;
    }

    @Override
    public String getName() {
        return firstName + " " + lastName;
    }
}
