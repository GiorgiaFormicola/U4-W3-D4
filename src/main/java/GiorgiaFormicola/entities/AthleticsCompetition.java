package GiorgiaFormicola.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "athletics_competitions")
public class AthleticsCompetition extends Event {
    //RELATION WITH PERSON
    @ManyToMany(mappedBy = "competitionsList")
    private List<Person> athletesList = new ArrayList<>();
    
    @ManyToOne
    @JoinColumn(name = "winner_id")
    private Person winner;
}
