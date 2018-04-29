package jpa1;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Ogloszenia {

    @Id
    @GeneratedValue
    Long id;

    String title;
    String prize;
    String Content;


    public Ogloszenia() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrize() {
        return prize;
    }

    public void setPrize(String prize) {
        this.prize = prize;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public Ogloszenia(String title, String prize, String content) {
        this.title = title;
        this.prize = prize;
        Content = content;
    }
}
