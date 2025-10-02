package co.edu.itm.padisoft.homework1.task4.business;

import co.edu.itm.padisoft.homework1.task4.domain.impl.Service;
import co.edu.itm.padisoft.homework1.task4.domain.impl.Technician;
import co.edu.itm.padisoft.homework1.task4.domain.interfaces.IService;
import co.edu.itm.padisoft.homework1.task4.domain.interfaces.ITechnician;

import java.util.HashMap;
import java.util.Map;

public class PrototypeCatalog {

    private Map<String, IService> serviceCatalog;
    private Map<String, ITechnician> technicianCatalog;

    public PrototypeCatalog() {
        serviceCatalog = new HashMap<>();
        technicianCatalog = new HashMap<>();
        loadCatalog();
    }

    private void loadCatalog() {

        // Default services
        addService("plomeria",
                new Service("Plomeria", 120, "Reparación de tuberías y grifos"));

        addService("electricidad",
                new Service("Electricidad", 90, "Instalación y reparación eléctrica"));

        addService("pintura",
                new Service("Pintura", 240, "Pintura de interiores y exteriores"));

        addService("carpinteria",
                new Service("Carpintería", 180, "Reparación de muebles y estructuras"));


        // Default technicians
        Technician plumber = new Technician("Juan", "Pérez", 4.5);
        plumber.addSkill("Reparación de fugas");
        plumber.addSkill("Instalación de sanitarios");
        addTechnician("plomero1", plumber);

        Technician electrician = new Technician("María", "González", 4.9);
        electrician.addSkill("Cableado residencial");
        electrician.addSkill("Instalación de luminarias");
        addTechnician("electricista1", electrician);

    }

    public void addService(String id, IService service) {
        serviceCatalog.put(id, service);
    }

    public void addTechnician(String id, ITechnician technician) {
        technicianCatalog.put(id, technician);
    }

    public IService cloneService(String serviceId) {
        IService service = serviceCatalog.get(serviceId);
        return service != null ? service.clone() : null;
    }

    public ITechnician cloneTechnician(String technicianId) {
        ITechnician tech = technicianCatalog.get(technicianId);
        return tech != null ? tech.clone() : null;
    }

}
