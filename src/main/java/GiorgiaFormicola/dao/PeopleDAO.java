package GiorgiaFormicola.dao;

import GiorgiaFormicola.entities.Person;
import GiorgiaFormicola.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class PeopleDAO {
    private final EntityManager entityManager;

    public PeopleDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Person newPerson) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(newPerson);
        transaction.commit();
        System.out.println("Person " + newPerson.getName() + " " + newPerson.getSurname() + " has been saved successfully!");
    }

    public Person getById(String id) {
        Person found = entityManager.find(Person.class, UUID.fromString(id));
        if (found == null) throw new NotFoundException(id);
        return found;
    }

    public void delete(String id) {
        Person found = this.getById(id);
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(found);
        transaction.commit();
        System.out.println("Person " + found.getName() + " " + found.getSurname() + " has been deleted successfully!");
    }
}
