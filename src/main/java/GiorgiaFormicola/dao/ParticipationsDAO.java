package GiorgiaFormicola.dao;

import GiorgiaFormicola.entities.Event;
import GiorgiaFormicola.entities.Participation;
import GiorgiaFormicola.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;
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

    public List<Participation> getParticipationsPendingByEvent(Event event) {
        TypedQuery<Participation> query = entityManager.createNamedQuery("getParticipationsPendingByEvent", Participation.class);
        query.setParameter("event", event);
        return query.getResultList();
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
