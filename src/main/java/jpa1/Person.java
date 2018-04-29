package jpa1;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Person {

    @Id
    @GeneratedValue()
    long id;


    String firstName;
    String lastName;

    @ManyToMany
    List<Appartment> appartments = new ArrayList<>();

    public List<Appartment> getAppartments() {
        return appartments;
    }

    public void setAppartments(List<Appartment> appartments) {
        this.appartments = appartments;
    }

    public Person() {
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }


    public void addAppartement(Appartment appartment){
        appartments.add(appartment);

    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

}
