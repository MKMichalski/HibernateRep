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

        Appartment a = new Appartment("Lodz", "pomorska", "5");
        Appartment b = new Appartment("Warszawa", "jakas", "50");
        session.save(a);
        session.save(b);
        p.addAppartement(a);
        p.addAppartement(b);
        session.save(p);

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

