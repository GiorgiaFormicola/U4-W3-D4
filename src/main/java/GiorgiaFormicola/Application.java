package GiorgiaFormicola;

import GiorgiaFormicola.dao.EventsDAO;
import GiorgiaFormicola.dao.LocationsDAO;
import GiorgiaFormicola.dao.ParticipationsDAO;
import GiorgiaFormicola.dao.PeopleDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Application {
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("events_management_pu");

    public static void main(String[] args) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        //CREATES DAO FOR EARCH CLASS
        LocationsDAO locationsDAO = new LocationsDAO(entityManager);
        EventsDAO eventsDAO = new EventsDAO(entityManager);
        PeopleDAO peopleDAO = new PeopleDAO(entityManager);
        ParticipationsDAO participationsDAO = new ParticipationsDAO(entityManager);

        //ADDS SOME LOCATIONS TO DB
       /* Location location1 = new Location("Stadio Olimpico", "Roma");
        Location location2 = new Location("Stadio San Siro", "Milano");
        Location location3 = new Location("Stadio Diego Armando Maradona", "Napoli");
        Location location4 = new Location("Wembley Stadium", "Regno Unito");

        try {
            locationsDAO.save(location1);
            locationsDAO.save(location2);
            locationsDAO.save(location3);
            locationsDAO.save(location4);
        } catch (RollbackException e) {
            System.out.println("Location " + location1.getName() + " is already saved in the database!");
        }*/

        //ADDS SOME PERSONS TO THE DB
       /* Person person1 = new Person("Mario", "Rossi", "mario@gmail.com", 1990, 8, 1, GenderType.M);
        Person person2 = new Person("Giovanni", "Verdi", "giovanni@gmail.com", 2010, 3, 22, GenderType.M);
        Person person3 = new Person("Sara", "Bianchi", "sara@gmail.com", 1997, 1, 22, GenderType.F);
        Person person4 = new Person("Giulia", "Bruni", "giulia@gmail.com", 1985, 5, 12, GenderType.F);

        try {
            peopleDAO.save(person1);
            peopleDAO.save(person2);
            peopleDAO.save(person3);
            peopleDAO.save(person4);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }*/

        //ADDS SOME CONCERTS TO THE DB

       /* Event concert1 = new Concert("Coldplay", 2026, 6, 15, "Amazing concert", EventType.PUBLIC, 7500, location1, GenreType.POP, true);
        Event concert2 = new Concert("Ed Sheeran", 2022, 3, 21, "Fabulous concert", EventType.PUBLIC, 5000, location2, GenreType.POP, true);
        Event concert3 = new Concert("Green Day", 2023, 8, 1, "Astonishing concert", EventType.PUBLIC, 3000, location3, GenreType.ROCK, false);
        Event concert4 = new Concert("Ludovico Einaudi", 2021, 2, 5, "Impressive concert", EventType.PUBLIC, 1000, location4, GenreType.CLASSICAL, false);

        try {
            eventsDAO.save(concert1);
            eventsDAO.save(concert2);
            eventsDAO.save(concert3);
            eventsDAO.save(concert4);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }*/


        //ADDS SOME FOOTBALL MATCHES TO THE DB
       /* FootballMatch footballMatch1 = new FootballMatch("Roma-Lazio", 2026, 6, 10, "Derby", EventType.PUBLIC, 7500, location1, "Roma", "Lazio");
        FootballMatch footballMatch2 = new FootballMatch("Roma-Napoli", 2026, 5, 10, "Sentita", EventType.PUBLIC, 3000, location2, "Napoli", "Roma");
        FootballMatch footballMatch3 = new FootballMatch("Roma-Milan", 2026, 2, 10, "Tosta", EventType.PUBLIC, 3000, location3, "Milan", "Roma");

        footballMatch1.setHomeTeamGoals(5);
        footballMatch1.setVisitingTeamGoals(2);
        footballMatch1.setWinningTeam();

        footballMatch2.setHomeTeamGoals(1);
        footballMatch2.setWinningTeam();

        footballMatch3.setHomeTeamGoals(1);
        footballMatch3.setVisitingTeamGoals(1);
        footballMatch3.setWinningTeam();

        try {
            eventsDAO.save(footballMatch1);
            eventsDAO.save(footballMatch2);
            eventsDAO.save(footballMatch3);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }*/


        //ADDS SOME ATHLETICS COMPETITIONS TO THE DB
        /*AthleticsCompetition competition1 = new AthleticsCompetition("Marathon", 2026, 4, 10, "Very tiring", EventType.PUBLIC, 1000, location1);
        AthleticsCompetition competition2 = new AthleticsCompetition("Hyrox", 2026, 4, 12, "Very stressfull", EventType.PRIVATE, 3000, location4);
        AthleticsCompetition competition3 = new AthleticsCompetition("Spartan Race", 2026, 2, 10, "Very funny", EventType.PRIVATE, 500, location3);

        competition1.setAthletesSet(new HashSet<>(List.of(person1, person2)));
        competition2.setAthletesSet(new HashSet<>(List.of(person1, person2, person3, person4)));
        competition3.setAthletesSet(new HashSet<>(List.of(person2, person4)));

        competition1.setWinner(person1);
        competition2.setWinner(person3);
        competition3.setWinner(person4);

        try {
            eventsDAO.save(competition1);
            eventsDAO.save(competition2);
            eventsDAO.save(competition3);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }*/


        //ADD SOME PARTICIPATIONS TO DB
        /*Participation participation1 = new Participation(concert1, person1, StateType.PENDING);
        Participation participation2 = new Participation(concert1, person2, StateType.PENDING);
        Participation participation3 = new Participation(concert1, person3, StateType.PENDING);
        Participation participation4 = new Participation(concert1, person4, StateType.PENDING);
        Participation participation5 = new Participation(footballMatch2, person2, StateType.PENDING);
        Participation participation6 = new Participation(footballMatch2, person3, StateType.PENDING);
        Participation participation7 = new Participation(footballMatch2, person1, StateType.PENDING);
        Participation participation8 = new Participation(competition2, person2, StateType.PENDING);
        Participation participation9 = new Participation(competition2, person3, StateType.PENDING);
        Participation participation10 = new Participation(competition3, person4, StateType.PENDING);
        Participation participation11 = new Participation(competition3, person1, StateType.PENDING);
        Participation participation12 = new Participation(concert3, person3, StateType.PENDING);

        try {
            participationsDAO.save(participation1);
            participationsDAO.save(participation2);
            participationsDAO.save(participation3);
            participationsDAO.save(participation4);
            participationsDAO.save(participation5);
            participationsDAO.save(participation6);
            participationsDAO.save(participation7);
            participationsDAO.save(participation8);
            participationsDAO.save(participation9);
            participationsDAO.save(participation10);
            participationsDAO.save(participation11);
            participationsDAO.save(participation12);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }*/

        System.out.println("Hello world");

    }
}