package GiorgiaFormicola.entities;


import GiorgiaFormicola.enums.StateType;
import jakarta.persistence.*;

import java.util.UUID;

/*@Entity
@Table(
        name = "partecipazioni",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"evento_id", "persona_id"})
        }
)*/

@Entity
@Table(name = "participations")
@NamedQuery(name = "getParticipationsPendingByEvent", query = "SELECT p FROM Participation p WHERE event = :event AND state = 'PENDING'")
public class Participation {
    //ATTRIBUTES
    @Id
    @GeneratedValue
    private UUID id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StateType state;

    //RELATION WITH EVENT
    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;

    //RELATION WITH PERSON
    @ManyToOne
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;

    //CONSTRUCTOR FOR DB
    protected Participation() {
    }

    //CONSTRUCTOR FOR JAVA
    public Participation(Event event, Person person, StateType state) {
        this.event = event;
        this.person = person;
        this.state = state;
    }

    //GETTERS
    public UUID getId() {
        return id;
    }

    public Event getEvent() {
        return event;
    }

    public Person getPerson() {
        return person;
    }

    //SETTERS
    public void setPerson(Person person) {
        this.person = person;
    }

    public StateType getState() {
        return state;
    }

    public void setState(StateType state) {
        this.state = state;
    }

    //TO STRING
    @Override
    public String toString() {
        return "Participation{" +
                "id=" + id +
                ", state=" + state +
                ", event=" + event +
                ", person=" + person +
                '}';
    }
}
