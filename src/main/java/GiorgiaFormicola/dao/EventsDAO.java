package GiorgiaFormicola.dao;

import GiorgiaFormicola.entities.Concert;
import GiorgiaFormicola.entities.Event;
import GiorgiaFormicola.enums.GenreType;
import GiorgiaFormicola.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.UUID;

public class EventsDAO {
    private final EntityManager entityManager;

    public EventsDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Event newEvent) {
        EntityTransaction transaction = this.entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(newEvent);
        transaction.commit();
        System.out.println("The event " + newEvent.getTitle() + " has been saved successfully!");
    }

    public Event getById(String id) {
        Event eventFound = entityManager.find(Event.class, UUID.fromString(id));
        if (eventFound == null) throw new NotFoundException(id);
        return eventFound;
    }

    public List<Concert> getConcertsOnStreaming(boolean aBoolean) {
        TypedQuery<Concert> query = entityManager.createQuery("SELECT c FROM Concert c WHERE c.onStreaming = :aBoolean", Concert.class);
        query.setParameter("aBoolean", aBoolean);
        return query.getResultList();
    }

    public List<Concert> getConcertsByGenre(GenreType genreType) {
        TypedQuery<Concert> query = entityManager.createQuery("SELECT c FROM Concert c WHERE c.genreType = :genreType", Concert.class);
        query.setParameter("genreType", genreType);
        return query.getResultList();
    }

    public long getHomeGamesWon() {
        TypedQuery<Long> query = entityManager.createNamedQuery("getHomeGamesWon", Long.class);
        return query.getSingleResult();
    }

    public long getAwayGamesWon() {
        TypedQuery<Long> query = entityManager.createNamedQuery("getAwayGamesWon", Long.class);
        return query.getSingleResult();
    }

    public void delete(String id) {
        Event eventFound = this.getById(id);
        EntityTransaction transaction = this.entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(eventFound);
        transaction.commit();
        System.out.println("The event " + eventFound.getTitle() + " has been deleted successfully!");
    }
}
