package IgorKup.bookErrata;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "errators")
public class ReaderErrata {
    @Id
    @GeneratedValue
    private int id;
    @ManyToOne
    private Book book;
    @Temporal(TemporalType.TIMESTAMP)
    private Date submited;
    @Column
    private String content;

    public ReaderErrata() {
        this.submited = Calendar.getInstance().getTime();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Date getSubmited() {
        return submited;
    }

    public void setSubmited(Date submited) {
        this.submited = submited;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
