package GiorgiaFormicola.entities;

import GiorgiaFormicola.enums.GenderType;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "persons")
public class Person {
    //ATTRIBUTES
    @Id
    @GeneratedValue
    private UUID id;
    @Column(nullable = false, length = 30)
    private String name;
    @Column(nullable = false, length = 30)
    private String surname;
    @Column(nullable = false, length = 60)
    private String email;
    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;
    @Column(length = 1)
    @Enumerated(EnumType.STRING)
    private GenderType gender;

    //RELATION WITH PARTICIPATION
    @OneToMany(mappedBy = "person")
    private List<Participation> participationsList = new ArrayList<>();
    
    //CONSTRUCTOR FOR DB
    protected Person() {
    }

    //CONSTRUCTOR FOR JAVA
    public Person(String name, String surname, String email, int year, int month, int day, GenderType gender) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.birthDate = LocalDate.of(year, month, day);
        this.gender = gender;
    }

    //GETTERS

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public List<Participation> getParticipationsList() {
        return participationsList;
    }

    //SETTERS

    public GenderType getGender() {
        return gender;
    }

    public void setGender(GenderType gender) {
        this.gender = gender;
    }


    //TO STRING

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", birthDate=" + birthDate +
                ", gender=" + gender +
                '}';
    }
}
