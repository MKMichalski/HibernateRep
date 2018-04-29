import jpa1.Appartment;
import jpa1.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class HibernateTest {

    public static void main(String[] args) {

        org.hibernate.cfg.Configuration cfg = new Configuration().configure("./hibernate.cfg.xml");
        SessionFactory sessionFactory = cfg.buildSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();

        Person p = new Person("Mateusz", "Michalski");
        session.save(p);
        Person p2 = new Person ("Krzysiek", "Kowalski");
        session.save(p2);

        Appartment a = new Appartment("Lodz", "pomorska", "5");
        a.addOwners(p2);
        a.addOwners(p);

        //jpa1.Person p3 = session.createQuery("Select p FROM jpa1.Person p where id=2", jpa1.Person.class);
        //jpa1.Person p3 = session.get(jpa1.Person.class, 1);
       // session.save(p3);
       // a.addOwners(p3);

        session.save(a);

//        p.addAppartement(a);
//        session.save(p);

        session.getTransaction().commit();

        List<Person> people = session.createQuery("SELECT p from Person p", Person.class).getResultList();

        for(Person pe : people){
            System.out.print(pe.getFirstName() + " ");
            System.out.println(pe.getLastName());

            List<Appartment> miesz = pe.getAppartments();
           for (Appartment ap : miesz){
                       System.out.print(ap.getMiasto() + " ");
                       System.out.print(ap.getUlica() + " ");
                       System.out.println(ap.getNumer() + " ");
           }

        }


        session.close();
        sessionFactory.close();

    }
}

