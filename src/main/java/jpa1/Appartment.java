package jpa1;

import jpa1.Person;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Appartment {
    @Id
    @GeneratedValue
    long id;

    String miasto;
    String Ulica;
    String numer;

    @ManyToMany
    List<Person> owners = new ArrayList<>();

    public Appartment(String miasto, String ulica, String numer) {
        this.miasto = miasto;
        Ulica = ulica;
        this.numer = numer;
    }


    public Appartment() {
    }


    public long getId() {
        return id;
    }

    public String getMiasto() {
        return miasto;
    }

    public String getUlica() {
        return Ulica;
    }

    public String getNumer() {
        return numer;
    }

    public void addOwners(Person p){
        owners.add(p);

    }

}
