package GiorgiaFormicola.entities;

import GiorgiaFormicola.enums.EventType;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "athletics_competitions")
public class AthleticsCompetition extends Event {
    //RELATION WITH PERSON
    @ManyToMany
    @JoinTable(
            name = "athletes_competitions",
            joinColumns = @JoinColumn(name = "competition_id"),
            inverseJoinColumns = @JoinColumn(name = "athlete_id")
    )
    private Set<Person> athletesSet = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "winner_id")
    private Person winner;

    protected AthleticsCompetition() {
    }

    ;

    public AthleticsCompetition(String title, int year, int month, int day, String description, EventType eventType, int maxNumberOfParticipants, Location location) {
        super(title, year, month, day, description, eventType, maxNumberOfParticipants, location);
    }

    public Set<Person> getAthletesSet() {
        return athletesSet;
    }

    public void setAthletesSet(Set<Person> athletesSet) {
        this.athletesSet = athletesSet;
    }

    public Person getWinner() {
        return winner;
    }

    public void setWinner(Person winner) {
        this.winner = winner;
    }

    @Override
    public String toString() {
        return "AthleticsCompetition{" +
                super.toString() +
                ", winner=" + winner +
                '}';
    }
}
