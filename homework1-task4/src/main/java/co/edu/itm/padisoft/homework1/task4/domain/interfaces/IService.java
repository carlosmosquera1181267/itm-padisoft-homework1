package co.edu.itm.padisoft.homework1.task4.domain.interfaces;

public interface IService extends Cloneable {
    IService clone();
    void showDetails();
    String getType();
}
