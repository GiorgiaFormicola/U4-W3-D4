package GiorgiaFormicola.entities;

import GiorgiaFormicola.enums.EventType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "football_matches")
public class FootballMatch extends Event {
    @Column(name = "home_team", nullable = false, length = 30)
    private String homeTeam;
    @Column(name = "visiting_team", nullable = false, length = 30)
    private String visitingTeam;
    @Column(name = "winning_team", nullable = true, length = 30)
    private String winningTeam;
    @Column(name = "home_team_goals", nullable = false)
    private int homeTeamGoals;
    @Column(name = "visiting_team_goals", nullable = false)
    private int visitingTeamGoals;

    protected FootballMatch() {
    }

    public FootballMatch(String title, int year, int month, int day, String description, EventType eventType, int maxNumberOfParticipants, Location location, String homeTeam, String visitingTeam, int homeTeamGoals, int visitingTeamGoals) {
        super(title, year, month, day, description, eventType, maxNumberOfParticipants, location);
        this.homeTeam = homeTeam;
        this.visitingTeam = visitingTeam;
        this.homeTeamGoals = homeTeamGoals;
        this.visitingTeamGoals = visitingTeamGoals;
        if (homeTeamGoals > visitingTeamGoals) this.winningTeam = homeTeam;
        if (homeTeamGoals < visitingTeamGoals) this.winningTeam = visitingTeam;
        else this.winningTeam = null;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public String getVisitingTeam() {
        return visitingTeam;
    }

    public int getHomeTeamGoals() {
        return homeTeamGoals;
    }

    public int getVisitingTeamGoals() {
        return visitingTeamGoals;
    }

    public String getWinningTeam() {
        return winningTeam;
    }

    @Override
    public String toString() {
        return "FootballMatch{" +
                super.toString() +
                ", homeTeam='" + homeTeam + '\'' +
                ", visitingTeam='" + visitingTeam + '\'' +
                ", winningTeam='" + winningTeam + '\'' +
                ", homeTeamGoals=" + homeTeamGoals +
                ", visitingTeamGoals=" + visitingTeamGoals +
                '}';
    }

    ;
}
