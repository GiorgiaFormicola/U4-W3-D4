package GiorgiaFormicola.entities;

import GiorgiaFormicola.enums.EventType;
import GiorgiaFormicola.enums.GenreType;
import jakarta.persistence.*;

@Entity
@Table(name = "concerts")
public class Concert extends Event {
    @Column(name = "genre", nullable = false)
    @Enumerated(EnumType.STRING)
    private GenreType genreType;
    @Column(name = "on_streaming", nullable = false)
    private boolean onStreaming;

    protected Concert() {
    }

    public Concert(String title, int year, int month, int day, String description, EventType eventType, int maxNumberOfParticipants, Location location, GenreType genreType, boolean onStreaming) {
        super(title, year, month, day, description, eventType, maxNumberOfParticipants, location);
        this.genreType = genreType;
        this.onStreaming = onStreaming;
    }

    public GenreType getGenreType() {
        return genreType;
    }

    public boolean isOnStreaming() {
        return onStreaming;
    }

    public void setOnStreaming(boolean onStreaming) {
        this.onStreaming = onStreaming;
    }

    @Override
    public String toString() {
        return "Concert{" +
                super.toString() +
                ", genreType=" + genreType +
                ", onStreaming=" + onStreaming +
                '}';
    }
}
