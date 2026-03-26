package GiorgiaFormicola.dao;

import GiorgiaFormicola.entities.Participation;
import GiorgiaFormicola.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class ParticipationsDAO {
    private final EntityManager entityManager;

    public ParticipationsDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Participation newParticipation) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(newParticipation);
        transaction.commit();
        System.out.println("Partecipation of " + newParticipation.getPerson().getName() + " " + newParticipation.getPerson().getName() + " has been saved successfully!");
    }

    public Participation getById(String id) {
        Participation found = entityManager.find(Participation.class, UUID.fromString(id));
        if (found == null) throw new NotFoundException(id);
        return found;
    }

    public void delete(String id) {
        Participation found = this.getById(id);
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(found);
        transaction.commit();
        System.out.println("Partecipation of " + found.getPerson().getName() + " " + found.getPerson().getName() + " has been deleted successfully!");
    }
}
