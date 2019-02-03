package IgorKup.ListMapping;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "booksL")
public class BookL {
    @Id
    @GeneratedValue
    private int id;
    @Column(nullable = false)
    private String title;
    @ElementCollection
    @OrderColumn(columnDefinition = "int", name = "orderColum")
    @Column(name = "comment")
    private List<String> comments = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getComments() {
        return comments;
    }

    public void setComments(List<String> comments) {
        this.comments = comments;
    }
}
