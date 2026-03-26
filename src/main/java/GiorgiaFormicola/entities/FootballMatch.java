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

    public FootballMatch(String title, int year, int month, int day, String description, EventType eventType, int maxNumberOfParticipants, Location location, String homeTeam, String visitingTeam) {
        super(title, year, month, day, description, eventType, maxNumberOfParticipants, location);
        this.homeTeam = homeTeam;
        this.visitingTeam = visitingTeam;
        this.homeTeamGoals = 0;
        this.visitingTeamGoals = 0;
        this.winningTeam = null;
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

    public void setHomeTeamGoals(int homeTeamGoals) {
        this.homeTeamGoals = homeTeamGoals;
    }

    public int getVisitingTeamGoals() {
        return visitingTeamGoals;
    }

    public void setVisitingTeamGoals(int visitingTeamGoals) {
        this.visitingTeamGoals = visitingTeamGoals;
    }

    public String getWinningTeam() {
        return winningTeam;
    }

    public void setWinningTeam() {
        int homeGoals = getHomeTeamGoals();
        int visitingGoals = getVisitingTeamGoals();
        if (homeGoals > visitingGoals) {
            this.winningTeam = this.homeTeam;
        } else if (homeGoals < visitingGoals) {
            this.winningTeam = this.visitingTeam;
        } else {
            this.winningTeam = null;
        }
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
