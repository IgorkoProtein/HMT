package IgorKup.ListMapping;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;
import places.dao.SessionManager;

/**
 * Created by User on 03.02.2019.
 */
public class BookTest {
    @Test
    public void createBookTest(){
        Session session = SessionManager.openSession();
        Transaction transaction = session.beginTransaction();

        BookL book = new BookL();
        book.setTitle("potter");
        book.getComments().add("Firs comment");
        book.getComments().add("Second comment");

        session.persist(book);

        transaction.commit();
        session.close();
    }

}