package GiorgiaFormicola.dao;

import GiorgiaFormicola.entities.Location;
import GiorgiaFormicola.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class LocationsDAO {
    private final EntityManager entityManager;

    public LocationsDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Location newLocation) {
        EntityTransaction transaction = this.entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(newLocation);
        transaction.commit();
        System.out.println("The location " + newLocation.getName() + " has been saved successfully!");
    }

    public Location getById(String id) {
        Location found = entityManager.find(Location.class, UUID.fromString(id));
        if (found == null) throw new NotFoundException(id);
        return found;
    }

    public void delete(String id) {
        Location found = this.getById(id);
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(found);
        transaction.commit();
        System.out.println("The location " + found.getName() + " has been deleted successfully!");
    }
}
