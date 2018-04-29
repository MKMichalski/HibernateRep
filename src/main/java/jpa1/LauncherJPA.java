package jpa1;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.io.IOException;
import java.util.List;

public class LauncherJPA {

    public static void main(String[] args) {


        EntityManager em = Persistence
                .createEntityManagerFactory("JPA1").createEntityManager();
        //Person p = new Person("a", "b");
        em.getTransaction().begin();
       // em.persist(p);
        Document document = null;
        try {
             document = Jsoup.connect("https://sprzedajemy.pl/szukaj?srchm=ls&catCode=&inp_category_id=5&inp_location_id=10&inp_text%5Bv%5D=mieszkania&sort=inp_srt_date_d&items_per_page=30").get();
            Elements elems = document.select(".details");

            for(Element e : elems){

                em.persist(
                        new Ogloszenia(e.select(".title").text(), e.select(".prize").text(), elems.text().trim()));

                System.out.println(e.text());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        em.getTransaction().commit();

//        em.find(Person.class, 1);

      //  List<Person> pople = em.createQuery("SELECT p from Person p", Person.class).getResultList();

        em.close();

    }


}
