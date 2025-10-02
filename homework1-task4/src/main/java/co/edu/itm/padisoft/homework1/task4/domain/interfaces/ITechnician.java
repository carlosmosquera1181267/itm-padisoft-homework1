package co.edu.itm.padisoft.homework1.task4.domain.interfaces;

public interface ITechnician extends Cloneable {
    ITechnician clone();
    void showInfo();
    boolean isAvailable();
    String getName();
}
