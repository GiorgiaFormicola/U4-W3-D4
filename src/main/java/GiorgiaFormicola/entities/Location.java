package GiorgiaFormicola.entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "locations")
public class Location {
    //ATTRIBUTES
    @Id
    @GeneratedValue
    private UUID id;
    @Column(length = 30, nullable = false)
    private String name;
    @Column(length = 30, nullable = false)
    private String city;

    //CONSTRUCTOR FOR DB
    protected Location() {
    }

    //CONSTRUCTOR FRO JAVA
    public Location(String name, String city) {
        this.name = name;
        this.city = city;
    }

    //GETTERS
    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    //SETTERS
    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    //TO STRING
    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
