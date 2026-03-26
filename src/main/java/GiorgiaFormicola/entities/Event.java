package GiorgiaFormicola.entities;

import GiorgiaFormicola.enums.EventType;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "events")
@Inheritance(strategy = InheritanceType.JOINED)
@NamedQuery(name = "getHomeGamesWon", query = "SELECT COUNT(f) FROM FootballMatch f WHERE f.winningTeam = f.homeTeam")
@NamedQuery(name = "getAwayGamesWon", query = "SELECT COUNT(f) FROM FootballMatch f WHERE f.winningTeam = f.visitingTeam")
@NamedQuery(name = "getDrawnMatches", query = "SELECT COUNT(f) FROM FootballMatch f WHERE f.winningTeam IS NULL ")
@NamedQuery(name = "getAthleticsCompetitionsByWinner", query = "SELECT a FROM AthleticsCompetition a WHERE a.winner = :person")
@NamedQuery(name = "getAthleticsCompetitionsByParticipant", query = "SELECT a FROM AthleticsCompetition a WHERE :person MEMBER OF a.athletesSet ")
public abstract class Event {
    //ATTRIBUTES
    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false, length = 30)
    private String title;

    @Column(name = "date", nullable = false)
    private LocalDate eventDate;

    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false, length = 30)
    private EventType eventType;

    @Column(name = "maximum_participants")
    private int maxNumberOfParticipants;

    //RELATION WITH LOCATION
    @ManyToOne
    @JoinColumn(name = "location_id", nullable = false)
    private Location location;

    //CONSTRUCTOR FOR DB
    public Event() {
    }

    //CONSTRUCTOR FOR JAVA
    public Event(String title, int year, int month, int day, String description, EventType eventType, int maxNumberOfParticipants, Location location) {
        this.title = title;
        this.eventDate = LocalDate.of(year, month, day);
        this.description = description;
        this.eventType = eventType;
        this.maxNumberOfParticipants = maxNumberOfParticipants;
        this.location = location;
    }

    //GETTERS
    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public String getDescription() {
        return description;
    }

    //SETTERS
    public void setDescription(String description) {
        this.description = description;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public int getMaxNumberOfParticipants() {
        return maxNumberOfParticipants;
    }

    public void setMaxNumberOfParticipants(int maxNumberOfParticipants) {
        this.maxNumberOfParticipants = maxNumberOfParticipants;
    }

    //TO STRING

    @Override
    public String toString() {
        return "id=" + id +
                ", title='" + title + '\'' +
                ", eventDate=" + eventDate +
                ", description='" + description + '\'' +
                ", eventType=" + eventType +
                ", maxNumberOfParticipants=" + maxNumberOfParticipants +
                ", location=" + location;
    }
}
